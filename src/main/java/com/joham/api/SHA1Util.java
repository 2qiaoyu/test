package com.joham.api;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1Util {
    public static String SHA1(String inStr) {
        MessageDigest md = null;
        String outStr = null;
        try {
            md = MessageDigest.getInstance("SHA-1"); // 选择SHA-1，也可以选择MD5
            byte[] digest = md.digest(inStr.getBytes()); // 返回的是byet[]，要转化为String存储比较方便
            outStr = bytetoString(digest);
        } catch (NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        }
        return outStr;
    }

    public static String bytetoString(byte[] digest) {
        String str = "";
        String tempStr = "";

        for (int i = 1; i < digest.length; i++) {
            tempStr = (Integer.toHexString(digest[i] & 0xff));
            if (tempStr.length() == 1) {
                str = str + "0" + tempStr;
            } else {
                str = str + tempStr;
            }
        }
        return str.toLowerCase();
    }

    public static String sortSHA1(String str) {
        return SHA1(sort(str));
    }

    /**
     * ascii 升序
     */
    public static String sort(String str) {
        char chs[] = str.toCharArray();
        int size = chs.length;
        char temp;
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j > i; j--) {
                if (chs[j] < chs[j - 1]) {
                    temp = chs[j];
                    chs[j] = chs[j - 1];
                    chs[j - 1] = temp;
                }
            }
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        System.out.println(sort("cbAa_"));
    }
}
