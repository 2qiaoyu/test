package com.joham.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则验证
 *
 * @author qiaoyu
 */
public class TestRegex {

    /**
     * 国内手机号(13,14,15,16,17,18,19段)
     */
    private static Pattern mobile = Pattern.compile("^(13|14|15|16|17|18|19)[0-9]{9}$");

    /**
     * 国内电话号码
     */
    private static Pattern telephone = Pattern.compile("0\\d{2,3}-\\d{7,8}");

    /**
     * 金额保留两位小数,可以为0
     */
    private static Pattern amount = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$");

    /**
     * 0.01-0.99，eg:折扣率
     */
    private static Pattern zeroOne = Pattern.compile("^0\\.[1-9][0-9]{0,1}|0\\.0[1-9]{1}$");

    /**
     * 10位正整数(1-9999999999)
     */
    private static Pattern mun = Pattern.compile("^[1-9]\\d{0,9}$");

    /**
     * 邮箱
     */
    private static Pattern mail = Pattern.compile("^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$");

    /**
     * 网址
     */
    private static Pattern url = Pattern.compile("^([hH][tT]{2}[pP]:\\/\\/|[hH][tT]{2}[pP][sS]:\\/\\/)(([A-Za-z0-9-~]+)\\.)+([A-Za-z0-9-~\\/])+$");

    /**
     * 销售价(0-99999999.99)
     */
    private static Pattern salePrice = Pattern.compile("^(0|[1-9][0-9]{0,7})(\\.[0-9]{1,2})?$");

    /**
     * 销售价(0.01-99999999.99)
     */
    private static Pattern salePrice1 = Pattern.compile("^([1-9](\\d{1,7})?(\\.\\d{1,2})?|0\\.(?!0+$)\\d{1,2})$");

    public static void main(String[] args) {
        String test = "0.01";
        System.out.println(zeroOne.matcher(test).find());
//        System.out.println(isValidDate("2018-02-28"));
    }

    /**
     * 判断日期格式:YYYY-MM-dd
     *
     * @param sDate
     * @return
     */
    public static boolean isValidDate(String sDate) {
        String datePattern1 = "\\d{4}-\\d{2}-\\d{2}";
        String datePattern2 = "^((\\d{2}(([02468][048])|([13579][26]))"
                + "[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|"
                + "(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?"
                + "((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?("
                + "(((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?"
                + "((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
        if ((sDate != null)) {
            Pattern pattern = Pattern.compile(datePattern1);
            Matcher match = pattern.matcher(sDate);
            if (match.matches()) {
                pattern = Pattern.compile(datePattern2);
                match = pattern.matcher(sDate);
                return match.matches();
            } else {
                return false;
            }
        }
        return false;
    }
}