package com.joham.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件末尾追加字符串
 */
public class Test {
    public static void main(String[] args) throws IOException {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter("/Users/joham/Documents/catalina", true));
            out.write("aString");
        } catch (IOException e) {
        } finally {
            if (out != null) {
                out.close();
            }
        }

    }
}
