package com.joham.qrcode;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * 二维码生成和解析
 *
 * @author joham
 */
public class QRCodeTest {

    public static void main(String[] args) throws Exception {
//        initImage();
        analysisImage();
    }

    /**
     * 生成二维码
     */
    private static void initImage() throws Exception {
        String filePath = "/Users/joham/Downloads/";
        String fileName = "test.png";
        //内容
        String content = "http://www.baidu.com";
        // 图像宽度
        int width = 200;
        // 图像高度
        int height = 200;
        // 图像类型
        String format = "png";
        Map<EncodeHintType, Object> hints = new HashMap<>(16);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        // 生成矩阵
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.QR_CODE, width, height, hints);
        Path path = FileSystems.getDefault().getPath(filePath, fileName);
        // 输出图像
        MatrixToImageWriter.writeToPath(bitMatrix, format, path);
        System.out.println("输出成功");
    }

    /**
     * 解析二维码
     */
    private static void analysisImage() throws Exception {
        String filePath = "/Users/joham/Downloads/test.png";
        BufferedImage image;
        try {
            image = ImageIO.read(new File(filePath));
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            // 对图像进行解码
            Result result = new MultiFormatReader().decode(binaryBitmap, hints);
            System.out.println(result.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
