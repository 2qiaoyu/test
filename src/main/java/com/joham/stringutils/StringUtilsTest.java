package com.joham.stringutils;


import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

/**
 * StringUtils工具类的常用方法
 *
 * @author joham
 */
public class StringUtilsTest {

    public static void main(String[] args) throws ParseException{
        date();
    }

    /**
     * 判断某字符串是否为空，为空的标准是 str==null 或 str.length()==0
     */
    private static void testIsEmpty() {
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
    private static void testIsBlank() {
        System.out.println("----------------------isBlank---------------------");
        System.out.println(StringUtils.isBlank(null));
        System.out.println(StringUtils.isBlank(""));
        System.out.println(StringUtils.isBlank(" "));
        System.out.println(StringUtils.isBlank("        "));
        System.out.println(StringUtils.isBlank("\t \n \f \r"));
        //"\b"为单词边界符
        System.out.println(StringUtils.isBlank("\b"));
        System.out.println(StringUtils.isBlank("bob"));
        System.out.println(StringUtils.isBlank(" bob "));
    }

    /**
     * 去掉字符串两端的控制符(control characters, char <= 32) , 如果输入为 null 则返回null
     */
    private static void trim() {
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

    /**
     * 字符串的分割
     */
    private static void split() {
        //默认半角空格分割
        String str1 = "aaa bbb ccc";
        String[] dim1 = StringUtils.split(str1);

        System.out.println(dim1.length);
        System.out.println(dim1[0]);
        System.out.println(dim1[1]);
        System.out.println(dim1[2]);

        //指定分隔符
        String str2 = "aaa,bbb,ccc";
        String[] dim2 = StringUtils.split(str2, ",");

        System.out.println(dim2.length);
        System.out.println(dim2[0]);
        System.out.println(dim2[1]);
        System.out.println(dim2[2]);

        //去除空字符串
        String str3 = "aaa,,bbb";
        String[] dim3 = StringUtils.split(str3, ",");

        System.out.println(dim3.length);
        System.out.println(dim3[0]);
        System.out.println(dim3[1]);

        //包含空字符串
        String str4 = "aaa,,bbb";
        String[] dim4 = StringUtils.splitPreserveAllTokens(str4, ",");

        System.out.println(dim4.length);
        System.out.println(dim4[0]);
        System.out.println(dim4[1]);
        System.out.println(dim4[2]);

        //指定分割的最大次数（超过后不分割）
        String str5 = "aaa,bbb,ccc";
        String[] dim5 = StringUtils.split(str5, ",", 2);

        System.out.println(dim5.length);
        System.out.println(dim5[0]);
        System.out.println(dim5[1]);
    }

    /**
     * 字符串转义
     */
    private static void escape() {
        System.out.println(StringEscapeUtils.escapeCsv("测试测试哦"));
        System.out.println(StringEscapeUtils.escapeCsv("测试,测试哦"));
        System.out.println(StringEscapeUtils.escapeCsv("测试\n测试哦"));

        System.out.println(StringEscapeUtils.escapeHtml4("测试测试哦 "));
        System.out.println(StringEscapeUtils.escapeJava("\"rensaninng\"，欢迎您！"));

        System.out.println(StringEscapeUtils.escapeEcmaScript("测试'测试哦"));
        System.out.println(StringEscapeUtils.escapeXml10("<tt>\"bread\" & \"butter\"</tt>"));
    }

    /**
     * 随机数
     */
    private static void random() {
        // 10位英字
        System.out.println(RandomStringUtils.randomAlphabetic(10));

        // 10位数字
        System.out.println(RandomStringUtils.randomNumeric(10));

        // 10位英数
        System.out.println(RandomStringUtils.randomAlphanumeric(10));

        // 10位ASCII码
        System.out.println(RandomStringUtils.randomAscii(10));

        // 指定文字10位
        System.out.println(RandomStringUtils.random(10, "abcde"));
    }

    /**
     * 数组
     */
    private static void array() {
        // 追加元素到数组尾部
        int[] array1 = {1, 2};
        array1 = ArrayUtils.add(array1, 3);

        System.out.println(array1.length);
        System.out.println(array1[2]);

        // 删除指定位置的元素
        int[] array2 = {1, 2, 3};
        array2 = ArrayUtils.remove(array2, 2);

        System.out.println(array2.length);

        // 截取部分元素
        int[] array3 = {1, 2, 3, 4};
        array3 = ArrayUtils.subarray(array3, 1, 3);

        System.out.println(array3.length);

        // 数组拷贝
        String[] array4 = {"aaa", "bbb", "ccc"};
        String[] copied = (String[]) ArrayUtils.clone(array4);

        System.out.println(copied.length);

        // 判断是否包含某元素
        String[] array5 = {"aaa", "bbb", "ccc", "bbb"};
        boolean result1 = ArrayUtils.contains(array5, "bbb");
        System.out.println(result1);

        // 判断某元素在数组中出现的位置（从前往后，没有返回-1）
        int result2 = ArrayUtils.indexOf(array5, "bbb");
        System.out.println(result2);

        // 判断某元素在数组中出现的位置（从后往前，没有返回-1）
        int result3 = ArrayUtils.lastIndexOf(array5, "bbb");
        System.out.println(result3);

        // 数组转Map
        Map<Object, Object> map = ArrayUtils.toMap(new String[][]{
                {"key1", "value1"},
                {"key2", "value2"}
        });
        System.out.println(map.get("key1"));
        System.out.println(map.get("key2"));

        // 判断数组是否为空
        Object[] array61 = new Object[0];
        Object[] array62 = null;
        Object[] array63 = new Object[]{"aaa"};

        System.out.println(ArrayUtils.isEmpty(array61));
        System.out.println(ArrayUtils.isEmpty(array62));
        System.out.println(ArrayUtils.isNotEmpty(array63));

        // 判断数组长度是否相等
        Object[] array71 = new Object[]{"aa", "bb", "cc"};
        Object[] array72 = new Object[]{"dd", "ee", "ff"};

        System.out.println(ArrayUtils.isSameLength(array71, array72));

        // 判断数组元素内容是否相等
        Object[] array81 = new Object[]{"aa", "bb", "cc"};
        Object[] array82 = new Object[]{"aa", "bb", "cc"};

        System.out.println(ArrayUtils.isEquals(array81, array82));

        // Integer[] 转化为 int[]
        Integer[] array9 = new Integer[]{1, 2};
        int[] result = ArrayUtils.toPrimitive(array9);

        System.out.println(result.length);
        System.out.println(result[0]);

        // int[] 转化为 Integer[]
        int[] array10 = new int[]{1, 2};
        Integer[] result10 = ArrayUtils.toObject(array10);

        System.out.println(result.length);
        System.out.println(result10[0].intValue());
    }

    /**
     * 日期
     */
    private static void date() throws ParseException {
        // 生成Date对象
        Date date = DateUtils.parseDate("2010/01/01 11:22:33", new String[]{"yyyy/MM/dd HH:mm:ss"});

        // 10天后
        Date tenDaysAfter = DateUtils.addDays(date, 10);
        System.out.println(DateFormatUtils.format(tenDaysAfter, "yyyy/MM/dd HH:mm:ss"));

        // 前一个月
        Date prevMonth = DateUtils.addMonths(date, -1);
        System.out.println(DateFormatUtils.format(prevMonth, "yyyy/MM/dd HH:mm:ss"));

        // 判断是否是同一天
        Date date1 = DateUtils.parseDate("2010/01/01 11:22:33", new String[]{"yyyy/MM/dd HH:mm:ss"});
        Date date2 = DateUtils.parseDate("2010/01/01 22:33:44", new String[]{"yyyy/MM/dd HH:mm:ss"});
        System.out.println(DateUtils.isSameDay(date1, date2));

        // 日期格式化
        System.out.println(DateFormatUtils.format(new Date(), "yyyy/MM/dd HH:mm:ss"));
    }
}
