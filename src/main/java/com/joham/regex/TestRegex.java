package com.joham.regex;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则验证
 *
 * @author joham
 */
public class TestRegex {

    /**
     * 国内手机号(13,14,15,16,17,18,19段)
     */
    private static Pattern mobile = Pattern.compile("^(13|14|15|16|17|18|19)[0-9]{9}$");

    /**
     * 手机号1开头11位
     */
    private static Pattern mobile1 = Pattern.compile("^(1)[0-9]{10}$");

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
     * 正整数
     */
    private static Pattern numberZ = Pattern.compile("^[1-9]\\d*$");

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

    /**
     * 日期(YYYY/MM/DD)
     */
    private static Pattern date = Pattern.compile("^\\d{4}(\\-|\\/|\\.)\\d{1,2}\\1\\d{1,2}$\n");

    private static Pattern aqwe = Pattern.compile("(?<province>[^省]+省|.+自治区|北京市|上海)" +
            "(?<city>[^自治州]+自治州|[^市]+市|[^盟]+盟|[^地区]+地区|.+区划)(?<county>[^市]+市|[^县]+县|[^旗]+旗|.+区)?(?<town>[^区]+区|.+镇)?" +
            "(?<village>.*)");

    public static void main(String[] args) {
        String test = "9999";
        System.out.println(numberZ.matcher(test).find());
//        System.out.println(isValidDate("2018-02-28"));
//        String a = "江苏省南京市江宁区测试地址1";
//        String a = "江苏江苏省苏州市昆山市福建省路xx号";
        String a = "北京市昌平区二拔子工业园区西路";
//        List<String> list = new ArrayList<>();
//        list.add("18911111111");
//        list.add("aaaa");
//        boolean c = list.stream().allMatch(b -> {
//            return mobile1.matcher(b).find();
//        });
//        Matcher m = aqwe.matcher(a);
//        String province = null, city = null, county = null, town = null, village = null;
//        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
//        Map<String, String> row = null;
//        while (m.find()) {
//            row = new LinkedHashMap<String, String>();
//            province = m.group("province");
//            row.put("province", province == null ? "" : province.trim());
//            city = m.group("city");
//            row.put("city", city == null ? "" : city.trim());
//            county = m.group("county");
//            row.put("county", county == null ? "" : county.trim());
//            village = m.group("village");
//            row.put("village", village == null ? "" : village.trim());
//            list.add(row);
//        }
//        System.out.println(list);
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