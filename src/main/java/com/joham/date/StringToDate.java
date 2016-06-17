package com.joham.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {

    public static void main(String[] args) {
        Date date = new Date();
        String str = dateToStr(date);
        System.out.println(str);
        System.out.println(strToDate(str));
    }

    /**
     * Date转字符串
     */
    public static String dateToStr(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    /**
     * 字符串转Date
     */
    public static Date strToDate(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
}
