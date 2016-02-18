package com.joham.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 截取网站域名
 */
public class Test1 {public static void main(String[] args) {
    String url = "http://192.168.7.12:8000/login.html";
    Matcher m = Pattern.compile("^http://[^/]+/").matcher(url);
    while(m.find()){
        System.out.println(m.group());
    }
}
}
