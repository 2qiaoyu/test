package com.joham.base;

/**
 * 判断系统版本
 *
 * @author joham
 */
public class Test6 {

    public static void main(String[] args) {
        String osName = System.getProperty("os.name");
        System.out.println(osName);
        if (osName.startsWith("Mac OS")) {
            // 苹果
        } else if (osName.startsWith("Windows")) {
            // windows
        } else {
            // unix or linux
        }
    }
}
