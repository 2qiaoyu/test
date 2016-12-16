package com.joham.date;

import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TestDate {

    /**
     * 记录日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(TestDate.class);

    public static void main(String[] args) throws Exception {
        // 定义输出日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd EEE");
        Date currentDate = new Date();
        List<Date> days = dateToWeek(currentDate);
        System.out.println("今天的日期: " + sdf.format(currentDate));
        LOGGER.info("今天的日期: " + sdf.format(currentDate));
        for (Date date : days) {
            System.out.println(sdf.format(date));
        }
        getToday();
        System.out.println(compare_date("2016-12-19 15:22:36", "2015-12-19 15:22:35"));
        System.out.println(DateUtil.getWeek(new Date()));
    }

    /**
     * 根据日期获得星期几
     *
     * @param mdate
     * @return
     */
    public static List<Date> dateToWeek(Date mdate) {
        int b = mdate.getDay();
        Date fdate;
        List<Date> list = new ArrayList<Date>();
        Long fTime = mdate.getTime() - b * 24 * 3600000;
        for (int a = 1; a <= 7; a++) {
            fdate = new Date();
            fdate.setTime(fTime + (a * 24 * 3600000));
            list.add(a - 1, fdate);
        }
        return list;
    }

    /**
     * 获得当前日期和前几天
     */
    public static void getToday() {
        Calendar calendar = Calendar.getInstance();
        String startTime = new SimpleDateFormat("yyyy-MM-dd EEE").format(calendar.getTime());
        //前6天是几号星期几
        calendar.add(Calendar.DATE, -6);
        String endTime = new SimpleDateFormat("yyyy-MM-dd EEE").format(calendar.getTime());
        System.out.println(startTime);
        System.out.println(endTime);
    }

    /**
     * 比较日期大小(两种方式)
     *
     * @return
     */
    public static boolean compare_date(String nowDate, String endDate) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dt1 = df.parse(nowDate);
            Date dt2 = df.parse(endDate);
            if (dt1.getTime() <= dt2.getTime()) {
                return true;
            } else if (dt1.getTime() > dt2.getTime()) {
                return false;
            }
//            if(dt1.before(dt2))
//                return true;
//            else
//                return false;
        } catch (Exception exception) {
            LOGGER.error("日期对比失败！", exception);
        }
        return false;
    }
}
