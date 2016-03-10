package com.joham.mail;

/**
 * 发送邮件
 */
public class TestMail {
    public static void main(String[] args) {
        String smtp = "smtp.exmail.qq.com";
        String from = "*****";
        String to = "*****";
        String copyto = "*****";
        String subject = "邮件主题";
        String content = "邮件内容";
        String username = "*****";
        String password = "******";
        String filename = "E:\\test\\test.txt";
        Mail.sendAndCc(smtp, from, to, copyto, subject, content, username, password, filename);
    }
}
