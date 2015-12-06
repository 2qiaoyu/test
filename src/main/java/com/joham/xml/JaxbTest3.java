package com.joham.xml;

import java.util.ArrayList;
import java.util.List;


/**
 * @author		zhuc
 * @create		2013-3-29 下午2:56:11
 */
public class JaxbTest3 {
    public static void main(String[] args) {
        Country country = new Country();
        country.setName("中国");

        List<Province> list = new ArrayList<Province>();
        Province province = new Province();
        province.setName("江苏省");
        province.setProvCity("南京市");
        Province province2 = new Province();
        province2.setName("浙江省");
        province2.setProvCity("杭州市");
        list.add(province);
        list.add(province2);
        country.setProvinceList(list);
        String str = JaxbUtil.convertToXml(country);
        System.out.println(str);
        System.out.println("-----------------------------------------");
        Country country1 = JaxbUtil.converyToJavaBean(str, Country.class);
        System.out.println(country1);
    }
}