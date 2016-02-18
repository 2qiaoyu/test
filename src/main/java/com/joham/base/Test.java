package com.joham.base;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by joham on 2015/10/13.
 */
public class Test {
    public static void main(String[] args) throws UnknownHostException {
        testIndexof();
        //getHostIp();
        //xiaoshu();
    }

    /**
     * indexof查询该字符是否在字符串中存在
     */
    public static void testIndexof(){
        String ip = "126.168.1.1";
        System.out.println(ip.indexOf("."));
        System.out.println(ip.indexOf("a"));
        System.out.println(ip.substring(0,ip.indexOf(".")));
    }

    /**
     * 字符串拆成字符
     */
    public static void testStringToChar(){
        String idCard = "320121198804190013";
        char[] arr = idCard.toCharArray();
        for(int i =0 ;i < arr.length ;i++){
            System.out.println(arr[i]);
        }
    }

    /**
     * //现在时间距离1970.1.1的毫秒数
     */
    public static void testCurrentTimeMillis(){
        System.out.println(System.currentTimeMillis());
    }

    /**
     * 获取本机IP和主机名
     * @throws UnknownHostException
     */
    public static void getHostIp()throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        System.out.println(InetAddress.getLocalHost().getHostName());
    }

    /**
     * 判断是否为一位小数，是的话变为2位小数
     */
    public static void xiaoshu(){
        String num = "0.1";
        if(num.substring(num.indexOf(".")+1,num.length()).length()==1){
            StringBuffer sb = new StringBuffer(num);
            sb.append("0");
            num = sb.toString();
        }
        System.out.println(num);
    }

    public static void test(){
        System.out.println(Test.class.getAnnotations());
    }
}
