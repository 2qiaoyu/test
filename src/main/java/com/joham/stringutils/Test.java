package com.joham.stringutils;

import org.apache.commons.lang.StringUtils;

/**
 * StringUtils工具类的常用方法
 */
public class Test {

    public static void main(String[] args) {
        testIsEmpty();
        testIsBlank();
        trim();
    }

    /**
     * 判断某字符串是否为空，为空的标准是 str==null 或 str.length()==0
     */
    public static void testIsEmpty() {
        System.out.println("----------------------isEmpty---------------------");
        System.out.println(StringUtils.isEmpty(null));
        System.out.println(StringUtils.isEmpty(""));
        System.out.println(StringUtils.isEmpty(" "));
        System.out.println(StringUtils.isEmpty("   "));
        System.out.println(StringUtils.isEmpty("bob"));
        System.out.println(StringUtils.isEmpty(" bob "));
    }

    /**
     * 判断某字符串是否为空或长度为0或由空白符(whitespace) 构成
     */
    public static void testIsBlank() {
        System.out.println("----------------------isBlank---------------------");
        System.out.println(StringUtils.isBlank(null));
        System.out.println(StringUtils.isBlank(""));
        System.out.println(StringUtils.isBlank(" "));
        System.out.println(StringUtils.isBlank("        "));
        System.out.println(StringUtils.isBlank("\t \n \f \r"));
        System.out.println(StringUtils.isBlank("\b")); //"\b"为单词边界符
        System.out.println(StringUtils.isBlank("bob"));
        System.out.println(StringUtils.isBlank(" bob "));
    }

    /**
     * 去掉字符串两端的控制符(control characters, char <= 32) , 如果输入为 null 则返回null
     */
    public static void trim() {
        System.out.println("----------------------trim---------------------");
        System.out.println(StringUtils.trim(null));
        System.out.println(StringUtils.trim(""));
        System.out.println(StringUtils.trim(" "));
        System.out.println(StringUtils.trim("  \b \t \n \f \r    "));
        System.out.println(StringUtils.trim("     \n\tss   \b"));
        System.out.println(StringUtils.trim(" d   d dd     "));
        System.out.println(StringUtils.trim("dd     "));
        System.out.println(StringUtils.trim("     dd       "));
    }

}
