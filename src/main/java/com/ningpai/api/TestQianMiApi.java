package com.ningpai.api;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * Created by joham on 2015/9/16.
 */
public class TestQianMiApi {
    private static final Logger LOGGER = Logger.getLogger(TestQianMiApi.class);
    public static void main(String[] args) {
        //login();
        addCustomer();
        //findCustomerDetail();
        //findCustomerList();
    }

    /**
     * 新增会员
     */
    private static void addCustomer(){
        //添加会员信息
        String url = "http://121.41.106.102:8000/open/customer/add.htm?" +
                "customerUsername=489620639&customerPassword=19920912&customerNickname=489620639&sign="+MD5Util.md5Hex("489620639" + "19920912" + "customer.add" + "KDJLDSJFLKJSDLKFJLSDFJ");
        System.out.println(url);
        String resultMessage = "";
        GetMethod getMethod = new GetMethod(url);
        HttpClient client = new HttpClient();
        Map<String, String> pmap = null;
        try {
            client.executeMethod(getMethod);
            resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据"+resultMessage);
            LOGGER.info("返回数据"+resultMessage);
        } catch (Exception e) {
            LOGGER.error("数据异常");
        }
    }

    /**
     * 查询会员列表
     */
    private static void findCustomerList(){
        //添加会员信息
        String url = "http://42.63.19.204:8081/open/customer/list.htm?" +
                "pageNo=1&pageSize=15&sign="+MD5Util.md5Hex("customer.list" + "KDJLDSJFLKJSDLKFJLSDFJ");
        System.out.println(url);
        String resultMessage = "";
        GetMethod getMethod = new GetMethod(url);
        HttpClient client = new HttpClient();
        Map<String, String> pmap = null;
        try {
            client.executeMethod(getMethod);
            resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据"+resultMessage);
        } catch (Exception e) {
        }
    }

    /**
     * 查询会员详情
     */
    private static void findCustomerDetail(){
        //添加会员信息
        String url = "http://127.0.0.1:8089/open/customer/get.htm?" +
                "customerUserName=ningpai&sign="+MD5Util.md5Hex("ningpai"+"customer.get" + "KDJLDSJFLKJSDLKFJLSDFJ");
        String resultMessage = "";
        GetMethod getMethod = new GetMethod(url);
        HttpClient client = new HttpClient();
        Map<String, String> pmap = null;
        try {
            client.executeMethod(getMethod);
            resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据"+resultMessage);
        } catch (Exception e) {
        }
    }

    private static void login(){
        //添加会员信息
        String url = "http://127.0.0.1:8089/site/thirdLogin.htm?" +
                "customerUsername=123&sign="+MD5Util.md5Hex("123"+"customer.login" + "KDJLDSJFLKJSDLKFJLSDFJ");
        System.out.println(url);
        String resultMessage = "";
        PostMethod getMethod = new PostMethod(url);
        HttpClient client = new HttpClient();
        Map<String, String> pmap = null;
        try {
            client.executeMethod(getMethod);
            resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据"+resultMessage);
        } catch (Exception e) {
        }
    }
}
