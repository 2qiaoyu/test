package com.joham.pwd;

import com.joham.api.MD5Util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class TestPwd {
    public static void main(String[] args) {
//        String salt = "1a2b3c";
//        String pwd = "000000";
//        System.out.println(MD5Util.md5Hex(MD5Util.md5Hex(pwd)+"."+salt));
//        System.out.println(MD5Util.md5Hex("admin"));

        String product = "dewfewfwefwef";
        System.out.println(product.length());
        System.out.println(product.substring(0,10));
        System.out.println(product.substring(0,10).length());

        DecimalFormat format=new DecimalFormat("0.00");
        String amount = format.format(new BigDecimal("3000.00"));
        System.out.println(amount);
    }
}
