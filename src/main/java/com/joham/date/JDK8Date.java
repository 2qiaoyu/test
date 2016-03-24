package com.joham.date;

import java.time.*;

/**
 * Created by joham on 2016/3/22.
 */
public class JDK8Date {
    public static void main(String[] args) {
//        localdate();
        localdatetime();
    }

    private static void localdate() {
        LocalDate localDate = LocalDate.of(2016, Month.MARCH, 22);
        //年
        int year = localDate.getYear();
        //月
        int month = localDate.getMonthValue();
        //日
        int day = localDate.getDayOfMonth();
        //星期
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        //该月的天数
        int monthDay = localDate.lengthOfMonth();
        //是否是闰年
        boolean leap = localDate.isLeapYear();
        System.out.println(year + ":" + month + ":" + day + ":" + dayOfWeek.getValue() + ":" + monthDay);
        System.out.println(leap);
        System.out.println(localDate.now());
    }

    public static void localdatetime() {
        LocalDateTime localDateTime = LocalDateTime.of(2016, Month.MARCH,10,20,30);
        Instant instant = Instant.now();
        System.out.println(localDateTime);
        System.out.println(instant);
    }
}
