package com.joham.bigdecimal;

import java.math.BigDecimal;


public class Test {

    public static void main(String[] args) throws IllegalAccessException {

        BigDecimal b = new BigDecimal("2.345");

        //int 转 BigDecimal
        System.out.println(BigDecimal.valueOf(1000));

        //直接删除多余的小数位，如2.345会变成2.34
        System.out.println(b.setScale(2, BigDecimal.ROUND_DOWN));

        //进位处理，2.345变成2.35
        System.out.println(b.setScale(2, BigDecimal.ROUND_UP));

        //四舍五入，2.345变成2.35
        System.out.println(b.setScale(2, BigDecimal.ROUND_HALF_UP));

        //四舍五入，2.345变成2.34，如果是5则向下舍
        System.out.println(b.setScale(2, BigDecimal.ROUND_HALF_DOWN));

        System.out.println();

        Double value1 = 10.0;

        Double value2 = 5.0;

        //加法
        System.out.println(add(value1, value2));

        //减法
        System.out.println(sub(value1, value2));

        //乘法
        System.out.println(mul(value1, value2));

        //除法
        System.out.println(div(value1, value2, 2));
    }

    /**
     * 提供精确加法计算的add方法
     *
     * @param value1 被加数
     * @param value2 加数
     * @return 两个参数的和
     */
    public static double add(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确减法运算的sub方法
     *
     * @param value1 被减数
     * @param value2 减数
     * @return 两个参数的差
     */
    public static double sub(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确乘法运算的mul方法
     *
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static double mul(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供精确的除法运算方法div
     *
     * @param value1 被除数
     * @param value2 除数
     * @param scale  精确范围
     * @return 两个参数的商
     * @throws IllegalAccessException
     */
    public static double div(double value1, double value2, int scale) throws IllegalAccessException {
        //如果精确范围小于0，抛出异常信息
        if (scale < 0) {
            throw new IllegalAccessException("精确度不能小于0");
        }
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return b1.divide(b2, scale).doubleValue();
    }
}