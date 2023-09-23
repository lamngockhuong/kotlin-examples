# Barcode

QR Code examples

## 1. ZXing (Zebra Crossing)

```
implementation("com.google.zxing:core:3.5.2")
implementation("com.google.zxing:javase:3.5.2")
```

**1.1. Generate QR Code:**

Example 1:
- http://localhost:8080/qrcode/generate?width=500&height=500&text=LamNgocKhuong

Example 2:
- http://localhost:8080/qrcode/generate2?width=500&height=500&text=LamNgocKhuong

**1.2. Download QR Code:**

Example 1:
- http://localhost:8080/qrcode/download?width=500&height=500&text=LamNgocKhuong

Example 2:
- http://localhost:8080/qrcode/download2?width=500&height=500&text=LamNgocKhuong
