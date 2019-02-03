package com.joham.ordercode;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.FastDateFormat;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CodeGenUtil {

    public static String genOrderCode() {
        return FastDateFormat.getInstance("yyMMddHHmmssSSS").format(System.currentTimeMillis()).concat(StringUtils.leftPad(String.valueOf(ThreadLocalRandom.current().nextInt(0, 999999)), 6, "0"));
    }

    public static String genOrderCode1() {
        return FastDateFormat.getInstance("yyMMddHHmmss").format(System.currentTimeMillis())
                .concat(String.valueOf(randomByLen(6)));
    }

    /**
     * 生成随机码
     *
     * @param len 长度
     * @return 随机码
     */
    private static long randomByLen(int len) {
        if (len < 1 || len > 18) {
            return 0;
        }
        long min = (long) Math.pow(10, len - 1);
        long max = min * 10 - 1;

        Random random = new Random();
        long tmp = Math.abs(random.nextLong());
        return tmp % (max - min + 1) + min;
    }
}
