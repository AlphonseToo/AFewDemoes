package com;

import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.ShearCaptcha;
import org.springframework.util.FastByteArrayOutputStream;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class DemoYZM {
    public static void main(String[] args) throws Exception {
        String text = "kjhd";
        // 设置验证码格式：宽、高、验证码长度和干扰线条数
        LineCaptcha lineCaptcha = new LineCaptcha(100, 50, 4, 150);
        BufferedImage image1 = (BufferedImage) lineCaptcha.createImage(text);
        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        File file = new File("C:\\Users\\Mine\\Desktop\\3.jpeg");
        ImageIO.write(image1, "jpeg", file);
//        lineCaptcha.write("C:\\Users\\Mine\\Desktop\\2.jpeg");

        ShearCaptcha shearCaptcha = new ShearCaptcha(100, 50, 4, 150);
        BufferedImage image2 = (BufferedImage) shearCaptcha.createImage(text);
        File file2 = new File("C:\\Users\\Mine\\Desktop\\21.jpeg");
        ImageIO.write(image2, "jpeg", file2);
    }
}
