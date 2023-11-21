package com.ngockhuong.barcode.qrcode

import org.junit.jupiter.api.Test

class QRCodeServiceTest {
    @Test
    fun `test generateQRCode success`() {
        val qrCodeService = QRCodeService()
        val content = "Hello World"
        val width = 100
        val height = 100
        val qrCode = qrCodeService.generateQRCode(content, width, height)
        assert(qrCode != null)
    }
}
