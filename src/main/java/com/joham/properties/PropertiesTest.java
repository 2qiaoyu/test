package com.joham.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        String path = "D:/ideaProject/app.properties";
        //InputStream inputStream = new FileInputStream(path);
        //Properties properties = PropertiesUtil.readPropertiesFile(inputStream);
        Properties properties = PropertiesUtil.readPropertiesFile(path);
        System.out.println(properties.getProperty("APP_SERVER"));
    }
}
