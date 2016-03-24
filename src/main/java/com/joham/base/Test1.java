package com.joham.base;

import org.apache.commons.lang.ObjectUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 截取网站域名
 */
public class Test1 {
    public static void main(String[] args) {
        String url = null;
        if (url.indexOf("login") != -1) {
            Matcher m = Pattern.compile("^http://[^/]+/").matcher(url);
            while (m.find()) {
                url = m.group();
            }
        }
        System.out.println(url);
    }
}
