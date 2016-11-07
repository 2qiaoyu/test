package com.joham.pwd;

import com.joham.api.MD5Util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class TestPwd {
    public static void main(String[] args) {
        String customerId = "1";
        String salt = "2df12a4bfc558ef8c6d87c48defb43087ffffea8e3d3eb67001ae52bc2be1f5b";
        String pwd = "123456";
        System.out.println(MD5Util.md5Hex(customerId + pwd + salt));

//        String product = "dewfewfwefwef";
//        System.out.println(product.length());
//        System.out.println(product.substring(0,10));
//        System.out.println(product.substring(0,10).length());
//
//        DecimalFormat format=new DecimalFormat("0.00");
//        String amount = format.format(BigDecimal.valueOf(3000));
//        System.out.println(amount);
    }
}
