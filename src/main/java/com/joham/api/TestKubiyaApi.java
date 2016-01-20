package com.joham.api;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by joham on 2015/9/17.
 */
public class TestKubiyaApi {
    /**
     * 记录日志对象
     */
    public static void main(String[] args) throws Exception {
        //sendMessage();
        //addCustomer();
        test();
        //send();
    }

    /**
     * 新增会员
     */
    private static void addCustomer() {
        //注册成功，将信息同步到对方网站
        String url = "http://www.yczhsq.com/serviceReg/businessPlaformUserAction?" +
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
            map.put("message", "您的验证码为" + code);
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

    /**
     * ems短信接口
     *
     * @throws UnsupportedEncodingException
     */
    private static void test() throws UnsupportedEncodingException {
        //注册成功，将信息同步到对方网站
        String content = URLEncoder.encode("您的短信验证码123456", "utf-8");
        String password = MD5Util.md5Hex("qzds0102");
        String url = "http://119.145.9.12/sendSMS.action?" +
                "enterpriseID=16717&loginName=admin&password=" + password + "&content=" + content + "&mobiles=13952012650";
        String resultMessage = "";
        PostMethod postMethod = new PostMethod(url);
        HttpClient client = new HttpClient();
        postMethod.getParams().setParameter (HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        postMethod.addRequestHeader("Content-Type","text/html;charset=UTF-8");
        postMethod.setRequestHeader("Content-Type", "text/html;charset=UTF-8");
        try {
            client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
            client.executeMethod(postMethod);
            resultMessage = postMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
            Map<String, Object> map = new HashMap<String, Object>();
            map = getMapFromJson(resultMessage.toString());
            //返回结果
            String result = (String) map.get("result");
            System.out.println("返回结果" + result);
        } catch (Exception e) {
        }
    }

    private static void send() throws Exception {
        String content = URLEncoder.encode("您的短信验证码123456", "utf-8");
        String password = MD5Util.md5Hex("qzds0102");
        URL url = new URL("http://119.145.9.12/sendSMS.action");
        URLConnection connection = url.openConnection();
        /**
         * 然后把连接设为输出模式。URLConnection通常作为输入来使用，比如下载一个Web页。 通过把URLConnection设为输出，你可以把数据向你个Web页传送。下面是如何做：
         */
        connection.setDoOutput(true);
        /**
         * 最后，为了得到OutputStream，简单起见，把它约束在Writer并且放入POST信息中，例如： ...
         */
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
        String param = "";
        param += "enterpriseID=16717";
        param += "&loginName=admin";
        param += "&password=" + password;
        param += "&content=" + content;
        param += "&mobiles=13952012650";
        // post的关键所在！
        out.write(param);
        // remember to clean up
        out.flush();
        out.close();
        // 一旦发送成功，用以下方法就可以得到服务器的回应：
        String sCurrentLine = "";
        StringBuffer sTotalString = new StringBuffer();
        InputStream l_urlStream;
        l_urlStream = connection.getInputStream();
        BufferedReader l_reader = new BufferedReader(new InputStreamReader(l_urlStream));
        while ((sCurrentLine = l_reader.readLine()) != null) {
            sTotalString.append(sCurrentLine);
        }
        System.out.println(sTotalString);
    }
}
