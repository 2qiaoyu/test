package com.joham.base;

/**
 * 获得邮箱域名
 *
 * @author joham
 */
public class GetMailHost {

    public static void main(String[] args) {
        String mail = "123456@qq.com";
        System.out.println(mail.substring(mail.indexOf("@") + 1, mail.indexOf(".")));
    }
}
