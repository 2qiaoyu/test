package com.joham.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;

/**
 * 读取json文件
 *
 * @author qiaoyu
 */
public class JsonReader {

    /**
     * 读取json文件
     *
     * @param fileName
     * @return
     */
    private static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String path = JsonReader.class.getClassLoader().getResource("provinces.json").getPath();
        String s = readJsonFile(path);
        JSONArray jsonArray = JSON.parseArray(s);
        //构建JSONArray数组
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject key = (JSONObject) jsonArray.get(i);
            String name = (String) key.get("name");
            String code = (String) key.get("code");
            System.out.println(name);
            System.out.println(code);
        }
    }
}
