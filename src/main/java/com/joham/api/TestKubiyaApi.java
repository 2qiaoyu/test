package com.joham.api;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.util.*;

/**
 * Created by joham on 2015/9/17.
 */
public class TestKubiyaApi {
    /**
     * 记录日志对象
     */
    public static void main(String[] args) {
        sendMessage();
    }

    /**
     * 新增会员
     */
    private static void addCustomer() {
        //注册成功，将信息同步到对方网站
        String url = "http://122.96.155.202:18070/ccs_web/serviceReg/businessPlaformUserAction?" +
                "userCode=joham&mobileNo=13952012650&newPwd=000000&action=1";
        String resultMessage = "";
        PostMethod postMethod = new PostMethod(url);
        HttpClient client = new HttpClient();
        Map<String, String> pmap = null;
        try {
            client.executeMethod(postMethod);
            resultMessage = postMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
            Map<String, Object> map = new HashMap<String, Object>();
            map = getMapFromJson(resultMessage.toString());
            //返回结果
            String result = (String) map.get("result");
            //0:成功 ， 100：重复注册
            //101：主机没有访问接口权限
            //102：传入参数信息不完整
            //103：根据userCode查询不到该用户
            //104：用户手机号错误
            //105：action参数传入有误(非1,2,3任意一个)
            System.out.println("返回结果" + result);
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

    /**
     * 发送短信
     */
    public static void sendMessage() {
        Map<String, String> resMap = new HashMap<String, String>();
        String url = "http://abhuashan.vicp.cc/ccs_web/noticeMsg/sendMsgOnly";
        PostMethod postMethod = new PostMethod(url);
        postMethod.setRequestHeader("Content-Type",
                "application/json;charset=UTF-8");
        try {
            String code = "1234";
            Map<Object, Object> map = new HashMap<Object, Object>();
            map.put("mobileNo", "13952012650");
            map.put("message", "您的验证码为"+code);
            map.put("channel", "2");
            JSONArray jsonArray = JSONArray.fromObject(map);
            postMethod.setRequestBody(jsonArray.toString().replace("[", "").replace("]", ""));
            HttpClient client = new HttpClient();
            client.executeMethod(postMethod);
            resMap = getWxSendResponse(postMethod.getResponseBodyAsString());
            System.out.println(resMap.get("state"));
            System.out.println(resMap.get("message"));
        } catch (Exception e) {
        }
    }

    public static Map<String, String> getWxSendResponse(String res) {
        Map<String, String> userData = new HashMap<String, String>();
        JSONObject jsonData = JSONObject.fromObject(res);
        userData.put("state", jsonData.getString("state").toString());
        userData.put("message", jsonData.getString("message").toString());
        return userData;
    }
}
