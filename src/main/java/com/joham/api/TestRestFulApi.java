package com.joham.api;

import com.alibaba.fastjson.JSON;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestRestFulApi {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestRestFulApi.class);

    public static void main(String[] args) throws Exception {
//        test();
        test6();
    }

    public static void test() {
        LOGGER.info("开始执行test");
        String url = "http://127.0.0.1:8080/goods/1/3906/detail";
        System.out.println(url);
        GetMethod getMethod = new GetMethod(url);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(getMethod);
            String resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    public static void test1() {
        LOGGER.info("开始执行test1");
        String parameter = "汪洋";
        String url = "http://127.0.0.1:8080/store/search?parameter=" + URLEncoder.encode(parameter);
        System.out.println(url);
        PostMethod postMethod = new PostMethod(url);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(postMethod);
            String resultMessage = postMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    public static void test2() throws Exception {
        LOGGER.info("开始执行test2");
        String url = "http://127.0.0.1:8080/store/1033/3/goodsInfos";
        System.out.println(url);
        PostMethod postMethod = new PostMethod(url);
        String param = "{ \"pageNum\":0,\"pageSize\":10}";
        RequestEntity requestEntity = new StringRequestEntity(param, "application/json", "UTF-8");
        postMethod.setRequestEntity(requestEntity);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(postMethod);
            String resultMessage = postMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    public static void test3() throws Exception {
        LOGGER.info("开始执行test3");
        String url = "http://127.0.0.1:8080/collection/addAtte?storeId=1019";
        System.out.println(url);
        PostMethod postMethod = new PostMethod(url);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(postMethod);
            String resultMessage = postMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    public static void test4() throws Exception {
        LOGGER.info("开始执行test4");
        String url = "http://127.0.0.1:8080/collection/delAtte?collectionSellerId=73";
        System.out.println(url);
        DeleteMethod deleteMethod = new DeleteMethod(url);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(deleteMethod);
            String resultMessage = deleteMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    /**
     * 修改店铺
     *
     * @throws Exception
     */
    public static void test5() throws Exception {
        LOGGER.info("开始执行test5");
        String url = "http://127.0.0.1:8080/store/storeUpdate";
        PutMethod putMethod = new PutMethod(url);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("storeId", 1006);
        map.put("storeName", "test1");
        map.put("companyAddress", "test");
        map.put("companyAddressId", "1,1,2");
        map.put("companyAdderssDel", "test");
        map.put("companyName", "test");
        map.put("logoUrl", "test");
        map.put("mobile", "13952012650");
        map.put("bossName", "test");
        String param = JSON.toJSONString(map);
        System.out.println(param);
        RequestEntity requestEntity = new StringRequestEntity(param, "application/json", "UTF-8");
        putMethod.setRequestEntity(requestEntity);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(putMethod);
            String resultMessage = putMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    public static void test6() throws Exception {
        LOGGER.info("开始执行test3");
        Map<Object, Object> map = new HashMap<Object, Object>();
//        map.put("queryString", "联想");
        map.put("cateName","手机");
        map.put("pageSize",44);
        map.put("pageNum",1);
        String param = JSON.toJSONString(map);
        System.out.println(param);
        RequestEntity requestEntity = new StringRequestEntity(param, "application/json", "UTF-8");
        String url = "http://app-test.kstore.qianmi.com/search/goods";
        PostMethod postMethod = new PostMethod(url);
        postMethod.setRequestEntity(requestEntity);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(postMethod);
            String resultMessage = postMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }
}
