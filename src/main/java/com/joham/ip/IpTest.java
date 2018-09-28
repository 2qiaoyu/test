package com.joham.ip;

/**
 * ip地址测试
 *
 * @author joham
 */
public class IpTest {

    public static void main(String[] args) {
        String ip = "10.9.11.142, 117.190.190.28";
        if (ip != null && ip.contains(",")) {
            ip = ip.substring(0, ip.indexOf(",")).trim();
        }
        System.out.println(ip);
    }
}
