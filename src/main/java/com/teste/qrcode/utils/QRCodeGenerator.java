package com.teste.qrcode.utils;

import com.teste.qrcode.domain.Salao;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;


import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {

    public static void generateQRCode(Salao restaurante) throws WriterException, IOException {
        String qrCodePath = "C:\\Users\\joao.carlos\\Desktop\\teste";
        String qrCodeName = qrCodePath+restaurante.getSalao()+restaurante.getId()+"-QRCODE.png";
        var qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(
                "ID: " +restaurante.getId() + "\n"+
                      "Url: " +restaurante.getUrl(),
                BarcodeFormat.QR_CODE, 400, 400);

        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}
