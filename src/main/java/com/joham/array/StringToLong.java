package com.joham.array;

import org.apache.commons.beanutils.ConvertUtils;

/**
 * Created by joham on 2016/3/21.
 */
public class StringToLong {

    public static void main(String[] args) {
        String[] array = new String[]{"1", "2"};
        System.out.println(stringToLong(array));
    }

    /**
     * String数组转Long数组
     */
    public static Long[] stringToLong(String[] array) {
        return (Long[]) ConvertUtils.convert(array, Long.class);
    }
}
