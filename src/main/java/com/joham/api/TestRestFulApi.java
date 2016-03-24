package com.joham.api;

import com.alibaba.fastjson.JSON;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLEncoder;
import java.util.*;

public class TestRestFulApi {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestRestFulApi.class);

    private static final String QM_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1UUkTxVDImkgCUp/vAz0ylEaf662oYeLieOcbQODRWidlBSlOJjWmBPF/DsqCBQvObuK/Rww9o3MVhIx00BAFeRaZu0vNhOQTJqFMGJiwuVSgTDPo03heD3Kzg1Dzm2PPWV9u/7CbxKoNK5UB5oTCYw3GATSre3phjPs5sYdXLQIDAQAB";

    private static final String JF_PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALVRSRPFUMiaSAJSn+8DPTKURp/rrahh4uJ45xtA4NFaJ2UFKU4mNaYE8X8OyoIFC85u4r9HDD2jcxWEjHTQEAV5Fpm7S82E5BMmoUwYmLC5VKBMM+jTeF4PcrODUPObY89ZX27/sJvEqg0rlQHmhMJjDcYBNKt7emGM+zmxh1ctAgMBAAECgYEAijA1XdgYRYswLnUCZ4s0bQQM/30DkT1pSemTWXYM4gGv3JIedO0yHiHOXGPNe2KVKPPh5J4leiTEZTXsRmr8iaaNbTDVcPK8LiA1UYC2t/9k525GDps4kAb1cHTOD30+CHh31YhyX6OOkYg9Tebppt2bXyTajKednMOGzJEvO5ECQQDhectCEVV7dixukoPe9945agqSNdXnPjPdamcOn1iIlcZ6kdIPEONH7YuWaeghVnfv7qVx3ZJIBmPWUs3iI9FrAkEAzd0e2P9Af3MaqtZVTgag0GugTzbGq/r2jhipZbcEP7Hl5xrKTtP1JAlMbcqRyKsX/+8G+R5NUyLyiNG11yjnxwJAXW6PuHfgWUG11bfm5z0FG/uCF+YxFhqjeUu/GsMS975Auce1KMMRu1uG7TRDmZTwLD9S1WVAWZI0SrqTT/MRswJAC6z/4+TOPqxDle7kFbHQiyGfjP6ZVAW+2B5T9T3lEsu/M1VUphXlcG7Kk+uKSyxRByYCajyqvA1eXh4uxw493wJBAKZfw2SEqnE2Hi+QjZOBeUm3YyTFyY4N3folffCRaqdUyXe66eUk++pfRK6XidyvU92jDieDkqStJO6IgKkNf1s=";

    public static void main(String[] args) throws Exception {
        test10();
    }

    public static void test() {
        LOGGER.info("开始执行test");
        String url = "http://127.0.0.1:8080/goods/1/5528/detail";
        System.out.println(url);
        GetMethod getMethod = new GetMethod(url);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(getMethod);
            String resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
            Map<String, Object> map = (Map<String, Object>) JSON.parse(resultMessage);
            System.out.println(map.get("id"));
            System.out.println(map.get("specItemList"));
        } catch (Exception e) {
        }
    }

    public static void test1() throws Exception {
        String parameter = "汪洋";
        String url = "http://127.0.0.1:8080/store/search?parameter=" + URLEncoder.encode(parameter, "utf-8");
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

    /**
     * 店铺商品列表排序
     *
     * @throws Exception
     */
    public static void test2() throws Exception {
        String url = "http://127.0.0.1:8080/store/1081/3/goodsInfos";
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

    public static void test14() throws Exception {
        String url = "http://127.0.0.1:8080/goods/1081/list";
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
        Hashtable<String, String> ht = new Hashtable<String, String>();
        ht.put("storeId", "1006");
        ht.put("storeName", "test");
        ht.put("companyAddress", "test");
        ht.put("companyAddressId", "1,1,2");
        ht.put("companyAdderssDel", "test");
        ht.put("companyName", "test");
        ht.put("logoUrl", "test");
        ht.put("mobile", "13952012650");
        ht.put("bossName", "test");
        ht.put("isDisable", "2");
        String inputStr = com.jfpal.common.util.StringUtil.getKeyValueString(ht);
        System.out.println("请求明文:\n" + inputStr);
        byte[] data = inputStr.getBytes("utf-8");// UTF-8可忽略
        byte[] encode = com.jfpal.common.crypt.RSACoder.encryptByPrivateKey(data, JF_PRIVATE_KEY);
        // 将密文字节数组转换为16进制字符串
        String encodeStr = com.jfpal.common.util.StringUtil.bytesToHexString(encode, false);
        System.out.println("请求密文data:\n" + encodeStr);
        // 2.2 使用私钥对加密后的数据签名 singStr
        String signStr = com.jfpal.common.crypt.RSACoder.sign(encode, JF_PRIVATE_KEY);
        System.out.println("签名sign:\n" + signStr);
        String url = "http://127.0.0.1:8080/store/storeUpdate";
        PostMethod postMethod = new PostMethod(url);
        postMethod.setParameter("data", encodeStr);
        postMethod.setParameter("sign", signStr);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(postMethod);
            String resultMessage = postMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    /**
     * 商品分类
     *
     * @throws Exception
     */
    public static void test6() throws Exception {
        Map<Object, Object> map = new HashMap<Object, Object>();
//        map.put("queryString", "联想");
        map.put("cateName", "手机");
        map.put("pageSize", 44);
        map.put("pageNum", 1);
        String param = JSON.toJSONString(map);
        System.out.println(param);
        RequestEntity requestEntity = new StringRequestEntity(param, "application/json", "UTF-8");
        String url = "http://127.0.0.1:8080/search/goods";
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

    /**
     * 加入购物车
     *
     * @throws Exception
     */
    public static void test7() throws Exception {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("goodsInfoId", 3938);
        map.put("goodsNum", 1);
        map.put("districtId", 1);
        String param = JSON.toJSONString(map);
        System.out.println(param);
        RequestEntity requestEntity = new StringRequestEntity(param, "application/json", "UTF-8");
        String url = "http://127.0.0.1:8080/cart/goods";
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

    /**
     * 单个删除购物车
     *
     * @throws Exception
     */
    public static void test8() throws Exception {
        String url = "http://127.0.0.1:8080/cart/goods?shoppingCartId=7920";
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
     * 批量删除购物车
     *
     * @throws Exception
     */
    public static void test9() throws Exception {
        Long[] shoppingCartIds = {7978L};
        String param = "";
        for (int i = 0; i < shoppingCartIds.length; i++) {
            param += "&shoppingCartIds=" + shoppingCartIds[i];
        }
        String url = "http://120.55.188.11:8080/cart/batch?1=1" + param;
        DeleteMethod deleteMethod = new DeleteMethod(url);
        deleteMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUipJLS4xMlbSUcpMLFGyMjQxtbAwMDe2sAAKpChZGRkZmOso5SXmpiIrTa0oACu1NDE0MrSwqAUAAAD__w.wfHuWWyNVmdRx54z4Th5h-vaBh-whWhtR089hMXWb-Y");
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(deleteMethod);
            String resultMessage = deleteMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    /**
     * 登陆
     *
     * @throws Exception
     */
    public static void test10() throws Exception {
        String url = "http://120.55.188.11:8080/customer/checkLogin?user=test23&password=1234qwer";
        PostMethod postMethod = new PostMethod(url);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(postMethod);
            String resultMessage = postMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    /**
     * 新增店铺
     *
     * @throws Exception
     */
    public static void test11() throws Exception {
        String url = "http://120.55.188.11:8080/store/register";
        PostMethod postMethod = new PostMethod(url);
        Hashtable<String, String> ht = new Hashtable<String, String>();
        ht.put("username", "test29");
        ht.put("storeName", "测试");
        ht.put("companyAddress", "测试");
        ht.put("companyAddressId", "1,1,1");
        ht.put("companyAdderssDel", "测试");
        ht.put("companyName", "测试");
        ht.put("logoUrl", "测试");
        ht.put("mobile", "13952012661");
        ht.put("bossName", "测试");
        ht.put("expiryTime", "2019-12-31 23:59:59");
        ht.put("im", "1");
        ht.put("groupId", "1");
        ht.put("jfCode", "15665");
        List<Long> cids = new ArrayList<Long>();
        cids.add(4529L);
        cids.add(4018L);
        List<Long> bids = new ArrayList<Long>();
        bids.add(1L);
        bids.add(2L);
        ht.put("cids", cids.toString());
        ht.put("bids", bids.toString());
        String inputStr = com.jfpal.common.util.StringUtil.getKeyValueString(ht);
        System.out.println("请求明文:\n" + inputStr);
        byte[] data = inputStr.getBytes("utf-8");// UTF-8可忽略
        byte[] encode = com.jfpal.common.crypt.RSACoder.encryptByPrivateKey(data, JF_PRIVATE_KEY);
        // 将密文字节数组转换为16进制字符串
        String encodeStr = com.jfpal.common.util.StringUtil.bytesToHexString(encode, false);
        System.out.println("请求密文data:\n" + encodeStr);
        // 2.2 使用私钥对加密后的数据签名 singStr
        String signStr = com.jfpal.common.crypt.RSACoder.sign(encode, JF_PRIVATE_KEY);
        System.out.println("签名sign:\n" + signStr);
        postMethod.setParameter("data", encodeStr);
        postMethod.setParameter("sign", signStr);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(postMethod);
            String resultMessage = postMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
            byte[] recvCryptedData = com.jfpal.common.util.StringUtil.hexStringToBytes(resultMessage);
            byte[] decryptData = com.jfpal.common.crypt.RSACoder.decryptByPrivateKey(recvCryptedData, JF_PRIVATE_KEY);
            String recvStr = new String(decryptData);
            System.out.println("应答明文:\n" + recvStr);
        } catch (Exception e) {
        }
    }

    /**
     * 上传商品
     *
     * @throws Exception
     */
    public static void test12() throws Exception {
        String url = "http://127.0.0.1:8080/goods/upload";
        PostMethod postMethod = new PostMethod(url);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("catId", 4018L);
        map.put("name", "测试搜索15");
        map.put("no", "20160317015");
        map.put("brandId", 783L);
        map.put("price", "100.00");
        map.put("thirdCateId", 511L);
        map.put("goodsDetail", "<p><br></p>");
        List<String> images = new ArrayList<String>();
        images.add("http://1433126974075.jpg");
        images.add("http://1433126947370.jpg");
        map.put("images", images);
        map.put("specId", 240L);
        map.put("specDetailId", 1025L);
        map.put("stock", 999L);
        map.put("weight", "1000");
        String param = JSON.toJSONString(map);
        System.out.println(param);
        RequestEntity requestEntity = new StringRequestEntity(param, "application/json", "UTF-8");
        postMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MbUwNDIyMrQECqQA-ebGpjpKeYm5qShqUysKIGrNjcwNDC1rAQAAAP__.96vpdv3JDLzGMpkq4O5Z3zjpYMwtqtIFyprxGVqAThw");
        postMethod.setRequestEntity(requestEntity);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(postMethod);
            String resultMessage = postMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    /**
     * 去结算
     *
     * @throws Exception
     */
    public static void test13() throws Exception {
        Long[] shoppCartIds = {7920L, 8085L};
        String param = "";
        for (int i = 0; i < shoppCartIds.length; i++) {
            param += "&shoppCartIds=" + shoppCartIds[i];
        }
        String url = "http://127.0.0.1:8080/cart/pay?addressId=608&districtId=1" + param;
        System.out.println(url);
        PostMethod postMethod = new PostMethod(url);
        postMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MTUzMjA1MLIECqQA-ebGpjpKeYm5qShqUysKIGotDCwtjCxrAQAAAP__.el6xeYbhkgGQoNyIN6vPW3vMbgbfaM9TeZk2rUQ_k8o");
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(postMethod);
            String resultMessage = postMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    public static void test15() throws Exception {
        Long[] goodsInfoIds = {5552L};
        String param = "";
        for (int i = 0; i < goodsInfoIds.length; i++) {
            param += "&goodsInfoIds=" + goodsInfoIds[i];
        }
        String url = "http://127.0.0.1:8080/goods/del?1=1" + param;
        DeleteMethod deleteMethod = new DeleteMethod(url);
        deleteMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MbUwNDIyMrQECqQA-ebGpjpKeYm5qShqUysKIGrNjcwNDC1rAQAAAP__.96vpdv3JDLzGMpkq4O5Z3zjpYMwtqtIFyprxGVqAThw");
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(deleteMethod);
            String resultMessage = deleteMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    /**
     * 修改商品
     *
     * @throws Exception
     */
    public static void test16() throws Exception {
        String url = "http://127.0.0.1:8080/goods/update";
        PutMethod putMethod = new PutMethod(url);
        putMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MbUwNDIyMrQECqQA-ebGpjpKeYm5qShqUysKIGrNjcwNDC1rAQAAAP__.96vpdv3JDLzGMpkq4O5Z3zjpYMwtqtIFyprxGVqAThw");
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("id", 2049L);
        map.put("name", "测试修改224");
        map.put("no", "2012124156211");
        map.put("price", "100.00");
        /*map.put("goodsDetail", "<p><br></p>");*/
        List<String> images = new ArrayList<String>();
        map.put("stock", 999L);
        map.put("weight", "1000");
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

    public static void test17() throws Exception {
        Long[] goodsImageIds = {10023L, 10024L};
        String param = "";
        for (int i = 0; i < goodsImageIds.length; i++) {
            param += "&goodsImageIds=" + goodsImageIds[i];
        }
        String url = "http://127.0.0.1:8080/goods/delPic?1=1" + param;
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
     * 商品上下架
     *
     * @throws Exception
     */
    public static void test18() throws Exception {
        String url = "http://127.0.0.1:8080/goods/goodsAdd?goodsId=2049&type=0";
        PutMethod putMethod = new PutMethod(url);
        putMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MbUwNDIyMrQECqQA-ebGpjpKeYm5qShqUysKIGrNjcwNDC1rAQAAAP__.96vpdv3JDLzGMpkq4O5Z3zjpYMwtqtIFyprxGVqAThw");
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(putMethod);
            String resultMessage = putMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    /**
     * 新增收货地址
     *
     * @throws Exception
     */
    public static void test19() throws Exception {
        String url = "http://127.0.0.1:8080/customers/addresses";
        PostMethod postMethod = new PostMethod(url);
        postMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MTUzMjA1MLIECqQA-ebGpjpKeYm5qShqUysKIGotDCwtjCxrAQAAAP__.el6xeYbhkgGQoNyIN6vPW3vMbgbfaM9TeZk2rUQ_k8o");
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("name", "测试修改");
        map.put("province", "1");
        map.put("city", "1");
        map.put("country", "1");
        map.put("detail", "测试");
        map.put("mobile", "13952012650");
        String param = JSON.toJSONString(map);
        System.out.println(param);
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

    /**
     * 修改收货地址
     *
     * @throws Exception
     */
    public static void test20() throws Exception {
        String url = "http://127.0.0.1:8080/customers/addresses";
        PutMethod putMethod = new PutMethod(url);
        putMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MTUzMjA1MLIECqQA-ebGpjpKeYm5qShqUysKIGotDCwtjCxrAQAAAP__.el6xeYbhkgGQoNyIN6vPW3vMbgbfaM9TeZk2rUQ_k8o");
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("id", 770L);
        map.put("name", "测试");
        map.put("province", "1");
        map.put("city", "1");
        map.put("country", "1");
        map.put("detail", "测试");
        map.put("mobile", "13952012650");
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

    /**
     * 删除收货地址
     *
     * @throws Exception
     */
    public static void test21() throws Exception {
        String url = "http://127.0.0.1:8080/customers/addresses/770";
        DeleteMethod deleteMethod = new DeleteMethod(url);
        deleteMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MTUzMjA1MLIECqQA-ebGpjpKeYm5qShqUysKIGotDCwtjCxrAQAAAP__.el6xeYbhkgGQoNyIN6vPW3vMbgbfaM9TeZk2rUQ_k8o");
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(deleteMethod);
            String resultMessage = deleteMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    /**
     * 收获地址列表
     *
     * @throws Exception
     */
    public static void test22() throws Exception {
        String url = "http://127.0.0.1:8080/customers/addresses";
        GetMethod getMethod = new GetMethod(url);
        getMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MTUzMjA1MLIECqQA-ebGpjpKeYm5qShqUysKIGotDCwtjCxrAQAAAP__.el6xeYbhkgGQoNyIN6vPW3vMbgbfaM9TeZk2rUQ_k8o");
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(getMethod);
            String resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    /**
     * 设为默认地址
     */
    public static void test23() throws Exception {
        String url = "http://127.0.0.1:8080/customers/addresses/default/770";
        PutMethod putMethod = new PutMethod(url);
        putMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MTUzMjA1MLIECqQA-ebGpjpKeYm5qShqUysKIGotDCwtjCxrAQAAAP__.el6xeYbhkgGQoNyIN6vPW3vMbgbfaM9TeZk2rUQ_k8o");
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(putMethod);
            String resultMessage = putMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    /**
     * 商户禁用
     */
    public static void test24() throws Exception {
        String url = "http://127.0.0.1:8080/store/1086/0/status";
        PostMethod postMethod = new PostMethod(url);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(postMethod);
            String resultMessage = postMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    /**
     * 提交订单
     */
    public static void test25() throws Exception {
        String url = "http://127.0.0.1:8080/order/submit";
        PostMethod postMethod = new PostMethod(url);
        postMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MTUzMjA1MLIECqQA-ebGpjpKeYm5qShqUysKIGotDCwtjCxrAQAAAP__.el6xeYbhkgGQoNyIN6vPW3vMbgbfaM9TeZk2rUQ_k8o");
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("addressId", 770L);
        map.put("message", "测试");
        List<Integer> shoppingCartId = new ArrayList<Integer>();
        shoppingCartId.add(8085);
        shoppingCartId.add(8086);
        map.put("shoppingCartId", shoppingCartId);
        String param = JSON.toJSONString(map);
        System.out.println(param);
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

    /**
     * 订单详情
     *
     * @throws Exception
     */
    public static void test26() throws Exception {
        String url = "http://127.0.0.1:8080/orders/2980/order";
        GetMethod getMethod = new GetMethod(url);
        getMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MTUzMjA1MLIECqQA-ebGpjpKeYm5qShqUysKIGotDCwtjCxrAQAAAP__.el6xeYbhkgGQoNyIN6vPW3vMbgbfaM9TeZk2rUQ_k8o");
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(getMethod);
            String resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    /**
     * 个人中心详情
     *
     * @throws Exception
     */
    public static void test27() throws Exception {
        String url = "http://127.0.0.1:8080/customers";
        GetMethod getMethod = new GetMethod(url);
        getMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MTUzMjA1MLIECqQA-ebGpjpKeYm5qShqUysKIGotDCwtjCxrAQAAAP__.el6xeYbhkgGQoNyIN6vPW3vMbgbfaM9TeZk2rUQ_k8o");
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(getMethod);
            String resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    /**
     * 营业额
     *
     * @throws Exception
     */
    public static void test28() throws Exception {
        String url = "http://127.0.0.1:8080/orders/turnover";
        GetMethod getMethod = new GetMethod(url);
        getMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MTW3NDYyMDICCqQA-ebGpjpKeYm5qShqUysKwGotTI3NLIyMagEAAAD__w.Y-ryNOtnuqkVqUYsts0euATJOvyZpRHRtV_ROzS8YBQ");
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(getMethod);
            String resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    /**
     * 销售采购订单数
     *
     * @throws Exception
     */
    public static void test29() throws Exception {
        String url = "http://127.0.0.1:8080/order/orderStatistics";
        GetMethod getMethod = new GetMethod(url);
        getMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUirMTMzLzVTSUcpMLFGyMjQxNbMwNDMzMAcKpAD55oYWOkp5ibmpyEpTKwrASs1NjAxNDMxrAQAAAP__.kYrS8AMlt2c7uZJEmoc9W20KB1hWsTcEs0zOXJ0Hd4k");
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(getMethod);
            String resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    public static void test30() throws Exception {
        String url = "http://127.0.0.1:8080/orders?pageNum=1&pageSize=1";
        GetMethod getMethod = new GetMethod(url);
        getMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MTWzNDAzMLIACqQA-ebGpjpKeYm5qShqUysKwGrNTQ0NLIwsagEAAAD__w.P9pvUoscDCOVFK8fsXW0WZAN2_aVSQbZNXzoETEOslo");
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(getMethod);
            String resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    public static void test31() throws Exception {
        String url = "http://127.0.0.1:8080/order/salesorderlist?status=3&pageNum=1&pageSize=1";
        GetMethod getMethod = new GetMethod(url);
        getMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MTWzNDAzMLIACqQA-ebGpjpKeYm5qShqUysKwGrNTQ0NLIwsagEAAAD__w.P9pvUoscDCOVFK8fsXW0WZAN2_aVSQbZNXzoETEOslo");
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(getMethod);
            String resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    public static void test32() throws Exception {
        String url = "http://127.0.0.1:8080/orders/updateOrderPrice?orderId=2977&price=103";
        PutMethod putMethod = new PutMethod(url);
        putMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MTWzNDAzMLIACqQA-ebGpjpKeYm5qShqUysKwGrNTQ0NLIwsagEAAAD__w.P9pvUoscDCOVFK8fsXW0WZAN2_aVSQbZNXzoETEOslo");
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(putMethod);
            String resultMessage = putMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    public static void test33() throws Exception {
        String url = "http://127.0.0.1:8080/orders/2983";
        DeleteMethod deleteMethod = new DeleteMethod(url);
        deleteMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MTU3MDW3MDYBCqQA-ebGpjpKeYm5qShqUysKIGrNzIzMjE1qAQAAAP__.Xfk1B1tTcJwdE9iosMyJV4B7fCS4u5HdDhym72rguLM");
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(deleteMethod);
            String resultMessage = deleteMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    public static void test34() throws Exception {
        String url = "http://127.0.0.1:8080/thirdorders/2983";
        DeleteMethod deleteMethod = new DeleteMethod(url);
        deleteMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MTU3MDW3MDYBCqQA-ebGpjpKeYm5qShqUysKIGrNzIzMjE1qAQAAAP__.Xfk1B1tTcJwdE9iosMyJV4B7fCS4u5HdDhym72rguLM");
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(deleteMethod);
            String resultMessage = deleteMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    public static void test35() throws Exception {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("queryString", "测试修改222");
        String param = JSON.toJSONString(map);
        System.out.println(param);
        RequestEntity requestEntity = new StringRequestEntity(param, "application/json", "UTF-8");
        String url = "http://127.0.0.1:8080/search/goods";
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

    public static void test36() throws Exception {
        String remark = URLEncoder.encode("测试一下", "UTF-8");
        String url = "http://127.0.0.1:8080/payment/receive?amount=1000&remark=" + remark;
        PostMethod postMethod = new PostMethod(url);
        postMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MTU3MDW3MDYBCqQA-ebGpjpKeYm5qShqUysKIGrNzIzMjE1qAQAAAP__.Xfk1B1tTcJwdE9iosMyJV4B7fCS4u5HdDhym72rguLM");
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(postMethod);
            String resultMessage = postMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    /**
     * 新登陆接口
     *
     * @throws Exception
     */
    public static void test37() throws Exception {
        String url = "http://127.0.0.1:8080/customer/login?mobile=15618303123&sessionId=7AD0F15A986E6A194D1B819A2C8EA3B7";
        PostMethod postMethod = new PostMethod(url);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(postMethod);
            String resultMessage = postMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    public static void test38() throws Exception {
        String remark = URLEncoder.encode("测试", "UTF-8");
        String url = "http://127.0.0.1:8080/payment/pay?amount=1000&mobile=13952012658&remark=" + remark;
        PostMethod postMethod = new PostMethod(url);
        postMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MTU3MDW3MDYBCqQA-ebGpjpKeYm5qShqUysKIGrNzIzMjE1qAQAAAP__.Xfk1B1tTcJwdE9iosMyJV4B7fCS4u5HdDhym72rguLM");
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(postMethod);
            String resultMessage = postMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    public static void test39() throws Exception {
        String url = "http://127.0.0.1:8080/payment/update?payMentId=2";
        PutMethod putMethod = new PutMethod(url);
        putMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MTU3MDW3MDYBCqQA-ebGpjpKeYm5qShqUysKIGrNzIzMjE1qAQAAAP__.Xfk1B1tTcJwdE9iosMyJV4B7fCS4u5HdDhym72rguLM");
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(putMethod);
            String resultMessage = putMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    public static void test40() throws Exception {
        String url = "http://127.0.0.1:8080/store/register";
        PostMethod postMethod = new PostMethod(url);
        postMethod.setParameter("data", "4c21719a9c91de94ca903e98721de8b322395bd46b0b0025087943ca05e49ea3669a3632637e1cac51bd90a14d27c6fdfd6989e8583e6c0b1235775ae2498d9fbdb60768453a1d8b32c6eaeba98f6ecf837d12d565bfde98b20c7f28180ce29d5852ca23edc4b94b20040c5a51bc23c6298be607849de7027e5c70349858ae01b2834fde081f9df6d4ad6eb337d536bd2032ff1df6843110434ab125c18ca77ce6c2843fe103c8a1efae57be08bdf5949918a811a3bc59ee299f636cad7f42e5dc37a3b92c48f89cab92ae00e4864e740023b4985490949d71c691e62df89922d10124a9b1a734246d670d95ed0b2b76ee63ebbfea573ca5fb267a7834ca8c340429687f7f6e7184854918b70def790583253c64bca8c1a731e3f92e0d47ff9f77b9e07ee3112ff5ab40ca6d6f51ea0975c092bdad6ef1365432761543f26d1a2104fa507a97e880653c663eebc12685bd6940118e1b86b7617ea5b2772c9b33ea03baec2806203d67f799f5f8c508cfb321c92627e777bd13d2c380b5c99ba7");
        postMethod.setParameter("sign", "IbttaDPBu/COF7DbcYjgpkKvxqiT2NfStxAZccUo4JuMTEg8eAsdMziVKb2OhQhcs2X3MtgttSsH");
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(postMethod);
            String resultMessage = postMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    public static void test41() throws Exception {
        String url = "http://127.0.0.1:8080/orders/delay";
        PostMethod postMethod = new PostMethod(url);
        postMethod.setParameter("orderId", "2977");
        postMethod.setParameter("delayTime", "2019-12-31 23:59:59");
        postMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MTW3NDYyMDICCqQA-ebGpjpKeYm5qShqUysKwGotTI3NLIyMagEAAAD__w.Y-ryNOtnuqkVqUYsts0euATJOvyZpRHRtV_ROzS8YBQ");
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(postMethod);
            String resultMessage = postMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    public static void test42() throws Exception {
        String url = "http://127.0.0.1:8080/orders/delayOrderList?day=1";
        GetMethod getMethod = new GetMethod(url);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(getMethod);
            String resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    /**
     * 营业额列表
     *
     * @throws Exception
     */
    public static void test43() throws Exception {
        String url = "http://120.55.188.11:8080/orders/turnoverlist?year=2016&month=3&day=14&payType=1";
        GetMethod getMethod = new GetMethod(url);
        getMethod.setRequestHeader("Authorization", "Bearerey JhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MTW3NDYyMDICCqQA-ebGpjpKeYm5qShqUysKwGotTI3NLIyMagEAAAD__w.Y-ryNOtnuqkVqUYsts0euATJOvyZpRHRtV_ROzS8YBQ");
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(getMethod);
            String resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    public static void test44() throws Exception {
        String url = "http://120.55.188.11:8080/collection/store";
        GetMethod getMethod = new GetMethod(url);
        getMethod.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNqqViouTVKyUsrLzEsvSMxU0lHKTCxRsjI0MbUwNTIxMbEACqQA-ebGpjpKeYm5qShqUysKwGotDY0sjUwsagEAAAD__w.ktbce0Qk4uH27kvXfNMXRPhyvaQa2nUCYOz6PboacAM");
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(getMethod);
            String resultMessage = getMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }
}