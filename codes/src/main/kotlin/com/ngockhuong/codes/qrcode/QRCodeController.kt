package com.ngockhuong.codes.qrcode

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ContentDisposition
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.awt.image.BufferedImage

@RestController
@RequestMapping("qrcode")
class QRCodeController {
    @Autowired
    lateinit var qrCodeService: QRCodeService

    @GetMapping(value = ["/generate"], produces = [MediaType.IMAGE_PNG_VALUE])
    fun generate(
        @RequestParam("text", required = true) text: String,
        @RequestParam("width", defaultValue = "250", required = true) width: Int,
        @RequestParam("height", defaultValue = "250", required = true) height: Int
    ): ResponseEntity<BufferedImage> {
        // Must create BufferedImageHttpMessageConverter bean to avoid an error
        val qrImage = qrCodeService.generateQRCode(text, width, height)
        return ResponseEntity.ok().body(qrImage)
    }

    @GetMapping(value = ["/generate2"], produces = [MediaType.IMAGE_PNG_VALUE])
    fun generate2(
        @RequestParam("text", required = true) text: String,
        @RequestParam("width", defaultValue = "250", required = true) width: Int,
        @RequestParam("height", defaultValue = "250", required = true) height: Int
    ): ResponseEntity<ByteArray> {
        val qrImage = qrCodeService.generateQRCodeByteArray(text, width, height)
        return ResponseEntity.ok().body(qrImage)
    }

    @GetMapping(value = ["/download"], produces = [MediaType.IMAGE_PNG_VALUE])
    fun download(
        @RequestParam("text", required = true) text: String,
        @RequestParam("width", defaultValue = "250", required = true) width: Int,
        @RequestParam("height", defaultValue = "250", required = true) height: Int
    ): ResponseEntity<BufferedImage> {
        val qrImage = qrCodeService.generateQRCode(text, width, height)

        val headers = HttpHeaders()
        headers.contentDisposition =
            ContentDisposition.builder("attachment").filename("file-${width}x${height}.png").build()
        headers.contentDisposition
        headers.cacheControl = "no-cache,no-store,must-revalidate"
        headers.pragma = "no-cache"
        headers.expires = 0

        return ResponseEntity.ok().headers(headers).body(qrImage)
    }

    @GetMapping(value = ["/download2"], produces = [MediaType.APPLICATION_OCTET_STREAM_VALUE])
    fun download2(
        @RequestParam("text", required = true) text: String,
        @RequestParam("width", defaultValue = "250", required = true) width: Int,
        @RequestParam("height", defaultValue = "250", required = true) height: Int
    ): ResponseEntity<ByteArray> {
        val qrImage = qrCodeService.generateQRCodeByteArray(text, width, height)

        val headers = HttpHeaders()
        headers.contentDisposition =
            ContentDisposition.builder("attachment").filename("file-${width}x${height}.png").build()
        headers.contentDisposition
        headers.cacheControl = "no-cache,no-store,must-revalidate"
        headers.pragma = "no-cache"
        headers.expires = 0

        return ResponseEntity.ok().headers(headers).body(qrImage)
    }
}
