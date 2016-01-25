package com.joham.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.joham.base64.TestBase64;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by joham on 2015/9/16.
 */
public class TestMyApi {
    private static final Logger LOGGER = Logger.getLogger(TestMyApi.class);

    public static void main(String[] args) throws Exception {
        //login();
        //addCustomer();
        //findCustomerDetail();
        //findCustomerList();
        test();
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
        PostMethod postMethod = new PostMethod(url);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(postMethod);
            resultMessage = postMethod.getResponseBodyAsString();
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
        SimpleDateFormat bartDateFormat =
                new SimpleDateFormat("YYYYMMddHHmm");
        String date = bartDateFormat.format(new Date());
        String url = "http://127.0.0.1:8082/open/customer/get.htm?" +
                "customerUserName=ningpai&sign=" + MD5Util.md5Hex("lie" + date + "PJHDZTGKVRTEARKEIFSWMFWYYMZRPW" + "ENGUQGRFPMISIIPHUSRB") + "&timestamp=" + date + "&token=PJHDZTGKVRTEARKEIFSWMFWYYMZRPW&userName=lie";
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
     * 第三方登陆
     */
    private static void login() {
        SimpleDateFormat bartDateFormat =
                new SimpleDateFormat("YYYYMMddHHmm");
        String date = bartDateFormat.format(new Date());
        String username = "test28";
        String sign = MD5Util.md5Hex("lie" + date + username + "PJHDZTGKVRTEARKEIFSWMFWYYMZRPW" + "ENGUQGRFPMISIIPHUSRB");
        //添加会员信息
        String url = "http://127.0.0.1:8082/msite/thirdLogin.htm?customerUsername=" + username +
                "&sign=" + sign + "&timestamp=" + date + "&userName=lie&token=PJHDZTGKVRTEARKEIFSWMFWYYMZRPW";
        System.out.println(url);
        String resultMessage = "";
        PostMethod postMethod = new PostMethod(url);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(postMethod);
            resultMessage = postMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
            String key = "MIICdwIBADANBgkq";
            System.out.println("加密密钥和解密密钥：" + key);
            String decrypt = TestBase64.aesDecrypt(resultMessage, key);
            decrypt = decrypt.replace("+", "＋");
            System.out.println("解密后：" + decrypt);
        } catch (Exception e) {
        }
    }

    /**
     * 收藏的店铺信息
     */
    private static void test() {
        SimpleDateFormat bartDateFormat =
                new SimpleDateFormat("YYYYMMddHHmm");
        String date = bartDateFormat.format(new Date());
        String sign = MD5Util.md5Hex("lie" + date + "PJHDZTGKVRTEARKEIFSWMFWYYMZRPW" + "ENGUQGRFPMISIIPHUSRB");
        //添加会员信息
        String url = "http://127.0.0.1:8082/open/storeInformation.htm?" +
                "timestamp=" + date + "&pageNo=1&pageSize=15&userName=lie" + "&customerId=1735&token=PJHDZTGKVRTEARKEIFSWMFWYYMZRPW&sign=" + sign;
        System.out.println(url);
        /*String resultMessage = "";
        PostMethod getMethod = new PostMethod(url);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(getMethod);
            resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
            Map<String, Object> map = new HashMap<String, Object>();
            map = getMapFromJson(resultMessage.toString());
        } catch (Exception e) {
        }*/
    }

    /**
     * 会员的收货地址
     */
    private static void test1() {
        SimpleDateFormat bartDateFormat =
                new SimpleDateFormat("YYYYMMddHHmm");
        String date = bartDateFormat.format(new Date());
        String sign = MD5Util.md5Hex("lie" + date + "PJHDZTGKVRTEARKEIFSWMFWYYMZRPW" + "ENGUQGRFPMISIIPHUSRB");
        //添加会员信息
        String url = "http://172.19.1.5:8080/open/receipt/receiptAddress.htm?" +
                "timestamp=" + date + "&userName=lie" + "&customerId=1735&token=PJHDZTGKVRTEARKEIFSWMFWYYMZRPW&sign=" + sign;
        System.out.println(url);
        String resultMessage = "";
        PostMethod getMethod = new PostMethod(url);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(getMethod);
            resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
            Map<String, Object> map = new HashMap<String, Object>();
            List<Object> list = (List<Object>) JSON.parse(resultMessage.toString());
            System.out.println(list);
        } catch (Exception e) {
        }
    }

    /**
     * 修改收货地址
     *
     * @throws Exception
     */
    private static void test2() throws Exception {
        SimpleDateFormat bartDateFormat =
                new SimpleDateFormat("YYYYMMddHHmm");
        String date = bartDateFormat.format(new Date());
        String sign = MD5Util.md5Hex("lie" + date + "PJHDZTGKVRTEARKEIFSWMFWYYMZRPW" + "ENGUQGRFPMISIIPHUSRB");
        String addressName = URLEncoder.encode("测试111", "utf-8");
        String provinceName = URLEncoder.encode("江苏", "utf-8");
        String cityName = URLEncoder.encode("南京市", "utf-8");
        String districtName = URLEncoder.encode("a", "utf-8");
        String addressDetail = URLEncoder.encode("千米网", "utf-8");
        //添加会员信息
        String url = "http://127.0.0.1:8082/open/receipt/modiCustAddress.htm?" +
                "timestamp=" + date + "&userName=lie&addressId=608&customerId=1735&addressName=" + addressName + "&provinceName=" + provinceName + "&cityName=" + cityName+ "&districtName="+ districtName+ "&addressDetail=" + addressDetail+"&addressMobile=13952012650&token=PJHDZTGKVRTEARKEIFSWMFWYYMZRPW&sign=" + sign;
        System.out.println(url);
        String resultMessage = "";
        PostMethod getMethod = new PostMethod(url);
        HttpClient client = new HttpClient();
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
     * 查询会员购物车
     *
     * @throws Exception
     */
    private static void test3() throws Exception {
        SimpleDateFormat bartDateFormat =
                new SimpleDateFormat("YYYYMMddHHmm");
        String date = bartDateFormat.format(new Date());
        String sign = MD5Util.md5Hex("lie" + date + "PJHDZTGKVRTEARKEIFSWMFWYYMZRPW" + "ENGUQGRFPMISIIPHUSRB");
        //添加会员信息
        String url = "http://127.0.0.1:8082/open/ShoppingCart.htm?" +
                "timestamp=" + date + "&userName=lie&customerId=1735&token=PJHDZTGKVRTEARKEIFSWMFWYYMZRPW&sign=" + sign;
        System.out.println(url);
        PostMethod getMethod = new PostMethod(url);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(getMethod);
            String resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
            List<Object> list = (List<Object>) JSON.parse(resultMessage.toString());
            System.out.println(list);
        } catch (Exception e) {

        }
    }

    /**
     * 订单列表
     *
     * @throws Exception
     */
    private static void test4() throws Exception {
        SimpleDateFormat bartDateFormat =
                new SimpleDateFormat("YYYYMMddHHmm");
        String date = bartDateFormat.format(new Date());
        String sign = MD5Util.md5Hex("lie" + date + "PJHDZTGKVRTEARKEIFSWMFWYYMZRPW" + "ENGUQGRFPMISIIPHUSRB");
        //添加会员信息
        String url = "http://127.0.0.1:8082/open/order/list.htm?" +
                "timestamp=" + date + "&userName=lie&token=PJHDZTGKVRTEARKEIFSWMFWYYMZRPW&sign=" + sign;
        System.out.println(url);
        PostMethod getMethod = new PostMethod(url);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(getMethod);
            String resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
            Map<String, Object> map = new HashMap<String, Object>();
            map = (Map<String, Object>) JSON.parse(resultMessage.toString());
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
