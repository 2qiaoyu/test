package com.joham.json;

import lombok.Data;

import java.io.Serializable;

@Data
public class WeatherBean_Baidu_City_Weatherdata implements Serializable {
    private String date;// 日期
    private String dayPictureUrl;// 白天的天气图片
    private String nightPictureUrl;// 晚上的天气图片
    private String weather;// 天气
    private String wind;// 风向
    private String temperature;// 温度
}

