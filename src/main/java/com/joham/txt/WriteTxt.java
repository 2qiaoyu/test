package com.joham.txt;

import java.io.*;

/**
 * txt文件写入
 *
 * @author joham
 */
public class WriteTxt {

    public static void main(String[] args) {
        writeTxt();
    }

    private static void writeTxt() {
        try {
            FileWriter fw = new FileWriter("/Users/joham/my/test/src/main/java/com/joham/txt/test1.txt");
            String s = "hello world";
            fw.write(s, 0, s.length());
            fw.flush();
            fw.close();
        } catch (IOException e) {

        }
    }

    private static void writeTxt1() {
        try {
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("/Users/joham/my/test/src/main/java" +
                    "/com/joham/txt/test2.txt"));
            String s = "hello world";
            osw.write(s, 0, s.length());
            osw.flush();
            osw.close();
        } catch (IOException e) {

        }
    }

    private static void writeTxt2() {
        try {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("/Users/joham/my/test/src" +
                    "/main/java/com/joham/txt/test3.txt")), true);
            String s = "hello world";
            pw.println(s);
            pw.close();
        } catch (IOException e) {

        }
    }
}
