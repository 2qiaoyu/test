package com.joham.txt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * txt文件读取
 *
 * @author joham
 */
public class ReadTxt {

    private static Logger logger = LoggerFactory.getLogger(ReadTxt.class);

    public static void main(String[] args) {
        readTxtFile("/Users/joham/my/test/src/main/java/com/joham/txt/test.txt");
    }

    public static void readTxtFile(String filename) {
        try {
            InputStream is = new FileInputStream(new File(filename));
            InputStreamReader fr = new InputStreamReader(is);
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {

        }
    }
}
