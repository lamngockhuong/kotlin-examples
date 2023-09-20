package com.ngockhuong.codes.qrcode

import com.google.zxing.BarcodeFormat
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.qrcode.QRCodeWriter
import org.springframework.stereotype.Service
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream

@Service
class QRCodeService {
    fun generateQRCode(content: String, width: Int, height: Int): BufferedImage? {
        val qrCodeWriter = QRCodeWriter()
        val bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height)
        return MatrixToImageWriter.toBufferedImage(bitMatrix)
    }

    fun generateQRCodeByteArray(content: String, width: Int, height: Int): ByteArray {
        val qrCodeWriter = QRCodeWriter()
        val bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height)

        ByteArrayOutputStream().use { output ->
            val writer = QRCodeWriter()
            val bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, width, height)
            MatrixToImageWriter.writeToStream(bitMatrix, "png", output)

            return output.toByteArray()
        }
    }
}
