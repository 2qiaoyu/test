package com.joham.api;

import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by joham on 2015/9/16.
 */
public class TestMyApi {
    private static final Logger LOGGER = Logger.getLogger(TestMyApi.class);

    public static void main(String[] args) throws Exception {
        login();
        //addCustomer();
        //findCustomerDetail();
        //findCustomerList();
        //test1();
    }

    /**
     * 新增会员
     */
    private static void addCustomer() {
        //添加会员信息
        String url = "http://121.41.106.102:8000/open/customer/add.htm?" +
                "customerUsername=489620639&customerPassword=19920912&customerNickname=489620639&sign=" + MD5Util.md5Hex("489620639" + "19920912" + "customer.add" + "KDJLDSJFLKJSDLKFJLSDFJ");
        System.out.println(url);
        String resultMessage = "";
        GetMethod getMethod = new GetMethod(url);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(getMethod);
            resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
            LOGGER.info("返回数据" + resultMessage);
        } catch (Exception e) {
            LOGGER.error("数据异常");
        }
    }

    /**
     * 查询会员列表
     */
    private static void findCustomerList() {
        SimpleDateFormat bartDateFormat =
                new SimpleDateFormat("YYYYMMddHHmm");
        String date = bartDateFormat.format(new Date());
        //添加会员信息
        String url = "http://127.0.0.1:8082/open/customer/list.htm?" +
                "pageNo=1&pageSize=15&sign=" + MD5Util.md5Hex("lie" + date + "PJHDZTGKVRTEARKEIFSWMFWYYMZRPW" + "ENGUQGRFPMISIIPHUSRB") + "&timestamp=" + date + "&token=PJHDZTGKVRTEARKEIFSWMFWYYMZRPW&userName=lie";
        System.out.println(url);
        String resultMessage = "";
        GetMethod getMethod = new GetMethod(url);
        HttpClient client = new HttpClient();
        Map<String, String> pmap = null;
        try {
            client.executeMethod(getMethod);
            resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    /**
     * 查询会员详情
     */
    private static void findCustomerDetail() {
        //添加会员信息
        String url = "http://127.0.0.1:8089/open/customer/get.htm?" +
                "customerUserName=joham&sign=" + MD5Util.md5Hex("joham" + "customer.get" + "KDJLDSJFLKJSDLKFJLSDFJ");
        String resultMessage = "";
        GetMethod getMethod = new GetMethod(url);
        HttpClient client = new HttpClient();
        Map<String, String> pmap = null;
        try {
            client.executeMethod(getMethod);
            resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    private static void login() {
        SimpleDateFormat bartDateFormat =
                new SimpleDateFormat("YYYYMMddHHmm");
        String date = bartDateFormat.format(new Date());
        String sign = MD5Util.md5Hex("lie" + date + "111" + "PJHDZTGKVRTEARKEIFSWMFWYYMZRPW" + "ENGUQGRFPMISIIPHUSRB");
        //添加会员信息
        String url = "http://127.0.0.1:8082/msite/thirdLogin.htm?customerUsername=test23" +
                "&sign=" + sign + "&timestamp=" + date + "&userName=lie&token=PJHDZTGKVRTEARKEIFSWMFWYYMZRPW";
        System.out.println(url);
        String resultMessage = "";
        PostMethod getMethod = new PostMethod(url);
        HttpClient client = new HttpClient();
        Map<String, String> pmap = null;
        try {
            client.executeMethod(getMethod);
            resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    private static void test() {
        SimpleDateFormat bartDateFormat =
                new SimpleDateFormat("YYYYMMddHHmm");
        String date = bartDateFormat.format(new Date());
        String sign = MD5Util.md5Hex("lie" + date + "PJHDZTGKVRTEARKEIFSWMFWYYMZRPW" + "ENGUQGRFPMISIIPHUSRB");
        //添加会员信息
        String url = "http://127.0.0.1:8082/open/storeInformation.htm?" +
                "timestamp=" + date + "&pageNo=1&pageSize=15&userName=lie" + "&customerUserName=ningpai&token=PJHDZTGKVRTEARKEIFSWMFWYYMZRPW&sign=" + sign;
        System.out.println(url);
        String resultMessage = "";
        PostMethod getMethod = new PostMethod(url);
        HttpClient client = new HttpClient();
        Map<String, String> pmap = null;
        try {
            client.executeMethod(getMethod);
            resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
            Map<String, Object> map = new HashMap<String, Object>();
            map = getMapFromJson(resultMessage.toString());
            System.out.println(map);
        } catch (Exception e) {
        }
    }

    private static void test1() throws Exception {
        SimpleDateFormat bartDateFormat =
                new SimpleDateFormat("YYYYMMddHHmm");
        String date = bartDateFormat.format(new Date());
        String sign = MD5Util.md5Hex("lie" + date + "PJHDZTGKVRTEARKEIFSWMFWYYMZRPW" + "ENGUQGRFPMISIIPHUSRB");
        String addressName = java.net.URLEncoder.encode("测试", "utf-8");
        //添加会员信息
        String url = "http://127.0.0.1:8082/open/receipt/modiCustAddress.htm?" +
                "timestamp=" + date + "&userName=lie&addressId=587&customerId=1718&addressName=" + addressName + "&token=PJHDZTGKVRTEARKEIFSWMFWYYMZRPW&sign=" + sign;
        System.out.println(url);
        String resultMessage = "";
        PostMethod getMethod = new PostMethod(url);
        HttpClient client = new HttpClient();
        Map<String, String> pmap = null;
        try {
            client.executeMethod(getMethod);
            resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
            Map<String, Object> map = new HashMap<String, Object>();
            map = getMapFromJson(resultMessage.toString());
            System.out.println(map);
        } catch (Exception e) {
        }
    }

    /**
     * json转换为Map
     *
     * @param jsonString
     * @return
     * @author qiaoyu
     * @since 2015-9-14 20:31
     */
    public static Map<String, Object> getMapFromJson(String jsonString) {
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        Map<String, Object> map = new HashMap<String, Object>();
        for (Iterator<?> iter = jsonObject.keys(); iter.hasNext(); ) {
            String key = (String) iter.next();
            map.put(key, jsonObject.get(key));
        }
        return map;
    }
}
