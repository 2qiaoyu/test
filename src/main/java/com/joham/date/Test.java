package com.joham.date;

import java.util.Date;

/**
 * Created by joham on 2016/1/29.
 */
public class Test {
    public static void main(String[] args) {
        /**
         * 判断字符串是否为日期字符串
         */
        System.out.println(DateUtil.isDate("2015-9-6 15:32"));

        /**
         * 将日期字符串转化为日期
         */
        System.out.println(DateUtil.StringToDate("2016-9-8"));

        /**
         * 将日期转化为日期字符串
         */
        System.out.println(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));

        /**
         * 将日期字符串转化为另一日期字符串
         */
        System.out.println(DateUtil.StringToString("2015-8-5 18:54", "yyyy-MM-dd"));

        /**
         * 增加日期的年份
         */
        System.out.println(DateUtil.addYear("2015-8-5 18:54", 3));
        System.out.println(DateUtil.addYear(new Date(), 3));

        /**
         * 增加日期的月份
         */
        System.out.println(DateUtil.addMonth("2015-8-5 18:54", 15));
        System.out.println(DateUtil.addMonth(new Date(), 15));

        /**
         * 增加日期的天数
         */
        System.out.println(DateUtil.addDay("2015-8-5 18:54", 15));
        System.out.println(DateUtil.addDay(new Date(), 15));

        /**
         * 获取日期的时间
         */
        System.out.println(DateUtil.getTime(new Date()));

        /**
         * 获取日期的星期
         */
        System.out.println(DateUtil.getWeek("2016-1-29"));

        /**
         * 获取两个日期相差的天数
         */
        System.out.println(DateUtil.getIntervalDays("2016-1-20","2016-1-29"));

        /**
         * 获取期间的年龄
         */
        System.out.println(DateUtil.getAge(new Date(),DateUtil.StringToDate("1988-04-19")));
    }
}
