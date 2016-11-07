package com.joham.json;

import lombok.Data;
import java.io.Serializable;

@Data
public class WeatherBean_Baidu_City_Index implements Serializable {
    private String title;//标题
    private String zs;//舒适度
    private String tipt;//指数简述
    private String des;//指数概述
}
