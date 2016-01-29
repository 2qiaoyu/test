package com.joham.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        String path = "D:/ideaProject/jifu/jifu_site/target/jifu_site-0.0.1-SNAPSHOT/WEB-INF/classes/com/ningpai/web/config/app.properties";
        //InputStream inputStream = new FileInputStream(path);
        //Properties properties = PropertiesUtil.readPropertiesFile(inputStream);
        Properties properties = PropertiesUtil.readPropertiesFile(path);
        System.out.println(properties.getProperty("APP_SERVER"));
    }
}
