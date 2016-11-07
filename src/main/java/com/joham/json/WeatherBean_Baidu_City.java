package com.joham.json;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class WeatherBean_Baidu_City implements Serializable {
    private String currentCity;//城市名称
    private String pm25;//pm2.5值
    private List<WeatherBean_Baidu_City_Index> index;//指数集合
    private List<WeatherBean_Baidu_City_Weatherdata> weather_data;//几天的天气集合
}
