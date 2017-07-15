package com.joham.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class JDK8Date {
    public static void main(String[] args) {
        timeBasic();
//        System.out.println(timeToString(LocalDateTime.now()));
//        System.out.println(stringToTime("2017-07-15 12:45:29"));
//        System.out.println(dateToString(LocalDate.now()));
//        System.out.println(stingToDate("2017-07-15"));
    }

    //java8 time 基础
    private static void timeBasic() {
        //当前日期
        System.out.println(LocalDate.now());
        //当前时间
        System.out.println(LocalDateTime.now());
        //当前年
        System.out.println("年:" + LocalDate.now().getYear());
        //当前月
        System.out.println("月:" + LocalDate.now().getMonthValue());
        //当前日
        System.out.println("日:" + LocalDate.now().getDayOfMonth());
        //星期几
        System.out.println("星期" + LocalDate.now().getDayOfWeek());
        //日期是否相等
        System.out.println(LocalDate.of(2017, 7, 15).equals(LocalDate.now()));
        //是否是闰年
        System.out.println(LocalDate.now().isLeapYear());
        //增加两年
        System.out.println(LocalDateTime.now().plusYears(2));
        //增加两个月
        System.out.println(LocalDateTime.now().plusMonths(2));
        //增加两周
        System.out.println(LocalDateTime.now().plusWeeks(2));
        //增加两天
        System.out.println(LocalDateTime.now().plusDays(2));
        //增加两小时LocalDate.of(2016, 7, 8
        System.out.println(LocalDateTime.now().plusHours(2));
        //增加两分钟
        System.out.println(LocalDateTime.now().plusMinutes(2));
        //增加两秒
        System.out.println(LocalDateTime.now().plusSeconds(2));
        //获取当前时区
        System.out.println(Clock.systemDefaultZone());
        //指定日期是否早于今天
        System.out.println(LocalDate.now().isBefore(LocalDate.of(2016, 7, 8)));
        //指定日期是否晚于今天
        System.out.println(LocalDate.now().isAfter(LocalDate.of(2016, 7, 8)));
        //这个月有多少天
        System.out.println(YearMonth.now().lengthOfMonth());
        //距离2018年还有几个月
        System.out.println(Period.between(LocalDate.now(), LocalDate.of(2018, 1, 1)).getMonths());
        //两个时间之间差几秒
        System.out.println(Duration.between(Instant.now(), Instant.now().plusSeconds(2)).getSeconds());
        //距离2018年有多少天
        System.out.println(ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.of(2018, 1, 1)));
        //获得时间戳
        System.out.println(Instant.now());
        //格式化时间
        System.out.println(LocalDate.parse("20170715", DateTimeFormatter.BASIC_ISO_DATE));
    }

    /**
     * 时间转字符串
     */

    public static String timeToString(LocalDateTime localDateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTimeFormatter.format(localDateTime);
    }

    /**
     * 字符串转时间
     */
    public static LocalDateTime stringToTime(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(date, dateTimeFormatter);
        return localDateTime;
    }

    /**
     * 日期转字符串
     */

    public static String dateToString(LocalDate localDate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateTimeFormatter.format(localDate);
    }

    /**
     * 字符串转日期
     */
    public static LocalDate stingToDate(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
        return localDate;
    }
}
