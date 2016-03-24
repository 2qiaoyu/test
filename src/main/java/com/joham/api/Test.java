package com.joham.api;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static final String API_SIGN_KEY = "qwer550016adu78584c47f81e1lkmt55";

    public static void main(String[] args) throws Exception {
        String session_id = "F5B7F378753A0338A6D0246ECAEFA91B";
        String client_id = "8a37cb3a-11d0-43b9-9be3-7026ca3bb2a7";
        String redirect_url = "oauth://test?";
        String return_param = "12";
        String scope = "1002";
        checkLogin(session_id, client_id, redirect_url, return_param, scope);
    }

    private static void checkLogin(String session_id, String client_id, String redirect_url, String return_param, String scope) throws Exception {
        String url = "http://220.248.45.125:8080/oauth-server/oauth/authorize";
        String secret = "4be2961e-aa50-431e-ae2e-61b280ed8a55";
        //获取XML格式数据
        String requestXml = getRequestXml(API_SIGN_KEY,"15021854946","111111");
        //拼接的authTokenValues
        String authTokenValues = values(secret, client_id, scope, redirect_url, return_param);
        String sign = SHA1Util.sortSHA1(authTokenValues);

        PostMethod postMethod = new PostMethod(url);
        postMethod.addParameter("session_id", session_id);
        postMethod.addParameter("client_id", client_id);
        postMethod.addParameter("redirect_url", redirect_url);
        postMethod.addParameter("return_param", return_param);
        postMethod.addParameter("sign", sign);
        postMethod.addParameter("scope", scope);
        postMethod.addParameter("scene", "ioioio");
        postMethod.addParameter("requestXml", requestXml);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(postMethod);
            String resultMessage = postMethod.getResponseBodyAsString();
            System.out.println("返回数据" + resultMessage);
        } catch (Exception e) {
        }
    }

    public static String values(String secret, String client_id, String scope, String redirect_url, String return_param) {
        StringBuffer sb = new StringBuffer();
        sb.append(client_id);
        sb.append(scope);
        sb.append(secret);
        sb.append(redirect_url);
        sb.append(return_param);
        return sb.toString();
    }

    public static String getRequestXml(String apiSignKey,String mobile,String pass) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss");
        String transTime = simpleDateFormat.format(new Date());
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMMdd");
        String transDate = simpleDateFormat1.format(new Date());
        String sign1 = apiSignKey;//qwer550016adu78584c47f81e1lkmt55   mobile:15021854946 password:111111
        String enpwd = new RSAHelper().getPwdEncipher(pass, mobile);
        String writer = "<JFPay appUser=\"jfpal_ccb\" application=\"UserLogin.Req\" clientType=\"02\" mobileSerialNum=\"A454AE7D0CDD42E30115D50E5BD625C7E00000000\" osType=\"android4.4.2\" phone=\"";
        writer += mobile + "\" token=\"0000\" userIP=\"localhost/127.0.0.1\" version=\"3.5.0\"><mobileNo>";
        writer += mobile + "</mobileNo><password>";
        writer += enpwd + "</password><transDate>";
        writer += transDate + "</transDate><transTime>";
        writer += transTime + "</transTime><transLogNo>000007</transLogNo><sign>";
        writer += sign1 + "</sign></JFPay>";
        String sign = URLDecoder.decode(writer.toString(), "UTF-8");
        sign = URLEncoder.encode(sign, "UTF-8");
        sign = EncodeDigest(sign.getBytes());
        String result = writer.toString().replaceAll(apiSignKey, sign);
        return result;
    }

    public static String EncodeDigest(byte[] buf) {
        String sResult = "";
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(buf);
            sResult = toHexString(algorithm.digest(), "").toUpperCase();
            return sResult;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String toHexString(byte[] bytes, String separator) {
        String s1 = "", s2 = "";
        for (int i = 0; i < bytes.length; i++) {
            s1 = Integer.toHexString(0xFF & bytes[i]);
            if (s1.length() == 1) {
                s2 += "0";
            }
            s2 += s1;
            s2 += separator;
        }
        return s2;
    }
}
