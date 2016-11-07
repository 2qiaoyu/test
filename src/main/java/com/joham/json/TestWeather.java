package com.joham.json;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class TestWeather {
    public static void main(String[] args) throws Exception {
        String city = URLEncoder.encode("南京", "UTF-8");
        String url = "http://api.map.baidu.com/telematics/v3/weather?location=" + city + "&output=json&ak=FK9mkfdQsloEngodbFl4FeY3";
        GetMethod getMethod = new GetMethod(url);
        String result = "";
        try {
            HttpClient httpClient = new HttpClient();
            httpClient.executeMethod(getMethod);
            result = getMethod.getResponseBodyAsString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jsonObj = JSONObject.fromObject(result);
        Map<String, Class> classMap = new HashMap<String, Class>();
        classMap.put("results", WeatherBean_Baidu_City.class);
        classMap.put("index", WeatherBean_Baidu_City_Index.class);
        classMap.put("weather_data", WeatherBean_Baidu_City_Weatherdata.class);
        // 将JSON转换成WeatherBean_Baidu
        WeatherBean_Baidu weather = (WeatherBean_Baidu) JSONObject.toBean(jsonObj,
                WeatherBean_Baidu.class, classMap);
        //通过fastjosn解析
        WeatherBean_Baidu weatherBean_baidu = (WeatherBean_Baidu)JSON.parseObject(result, WeatherBean_Baidu.class);
        //通过jackson解析
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherBean_Baidu weatherBean_baidu1 = objectMapper.readValue(result, WeatherBean_Baidu.class);
        System.out.println(weatherBean_baidu.getResults().get(0).getCurrentCity());
        System.out.println(weatherBean_baidu1.getResults().get(0).getCurrentCity());
        System.out.println(weather.getResults().get(0).getCurrentCity());
    }
}
