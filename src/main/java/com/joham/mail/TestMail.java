package com.joham.mail;

/**
 * 发送邮件
 */
public class TestMail {
    public static void main(String[] args) {
        String smtp = "smtp.exmail.qq.com";
        String from = "qiaoyu@qianmi.com";
        String to = "2qiaoyu@163.com";
        String copyto = "694113006@qq.com";
        String subject = "邮件主题";
        String content = "邮件内容";
        String username = "qiaoyu@qianmi.com";
        String password = "Joham880419";
        String filename = "E:\\项目\\奥天\\新问题.doc";
        Mail.sendAndCc(smtp, from, to, copyto, subject, content, username, password, filename);
    }
}
