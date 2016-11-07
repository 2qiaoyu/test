package com.joham.json;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class WeatherBean_Baidu implements Serializable {
    private String error;//错误号
    private String status;//状态值
    private String date;//日期
    private List<WeatherBean_Baidu_City> results;//城市天气预报集合（因为一次可以查询多个城市）
}
