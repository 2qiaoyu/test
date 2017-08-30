package com.joham.base;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws UnknownHostException {
//        testIndexof();
        //getHostIp();
        //xiaoshu();
        testCurrentTimeMillis();
        Long time = 1497783879000L;
        getDateFromCurrentTimeMillis(time);
//        int size = 221929;
//        int k = (size / 10000) * 10000 + size % 10000;
//        System.out.println(k);
    }

    /**
     * indexof查询该字符是否在字符串中存在
     */
    public static void testIndexof() {
        String ip = "126.168.1.1";
        System.out.println(ip.indexOf("."));
        System.out.println(ip.indexOf("a"));
        System.out.println(ip.substring(0, ip.indexOf(".")));
    }

    /**
     * 字符串拆成字符
     */
    public static void testStringToChar() {
        String idCard = "12312312312312312";
        char[] arr = idCard.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * //现在时间距离1970.1.1的毫秒数
     */
    public static void testCurrentTimeMillis() {
        System.out.println(System.currentTimeMillis());
    }

    /**
     * 获取本机IP和主机名
     *
     * @throws UnknownHostException
     */
    public static void getHostIp() throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        System.out.println(InetAddress.getLocalHost().getHostName());
    }

    /**
     * 判断是否为一位小数，是的话变为2位小数
     */
    public static void xiaoshu() {
        String num = "0.1";
        if (num.substring(num.indexOf(".") + 1, num.length()).length() == 1) {
            StringBuffer sb = new StringBuffer(num);
            sb.append("0");
            num = sb.toString();
        }
        System.out.println(num);
    }

    public static void test() {
        System.out.println(Test.class.getAnnotations());
    }

    /**
     * 根据CurrentTimeMillis得到精确时间
     *
     * @param time
     */
    public static void getDateFromCurrentTimeMillis(Long time) {
        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));
    }
}
