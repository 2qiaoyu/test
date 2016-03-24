package com.joham.abc;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AuthTokenTest {
	
	public static final String API_SIGN_KEY = "qwer550016adu78584c47f81e1lkmt55";
	
	public static void main(String[] args) throws Exception {
		String result = getRquestToken();
        Map<String, Object> map = getMapFromJson(result);
        if (map.get("resp_code").equals("0000")) {
            Map<String, Object> map1 = getMapFromJson(map.get("data").toString());
            String requestToken = map1.get("request_token").toString();
            //请求参数
            String sign = values("5faebc61-2566-4024-8e35-88e490fda7c0", "fa4a54c2-9e73-43ab-8a94-8654b553d422", requestToken);
            sign = SHA1Util.sortSHA1(sign);
            String param = "client_id=fa4a54c2-9e73-43ab-8a94-8654b553d422&request_token="+requestToken+"&sign="+sign;
            //授权验证
            GetMethod getMethod = new GetMethod("http://220.248.45.125:8080/oauth-server/oauth/accessToken?"+param);
            System.out.println("client_id:"+"fa4a54c2-9e73-43ab-8a94-8654b553d422");
            System.out.println("request_token:" + requestToken);
            System.out.println("sign:" + sign);
            HttpClient client = new HttpClient();
            //发送请求
            try {
                client.executeMethod(getMethod);
                //获取请求信息
                String accessTokenResponse = getMethod.getResponseBodyAsString();
                System.out.println(accessTokenResponse);
                Map<String, Object> map2 = getMapFromJson(accessTokenResponse);
                //成功
                if (map2.get("resp_code").equals("0000")) {
                    Map<String, Object> map3 = getMapFromJson(map2.get("data").toString());
                    String openId = map3.get("open_id").toString();
                    String token = map3.get("access_token").toString();
                    String url = "http://220.248.45.125:8080/oauth-server/user/accountInfo/"+openId+"?access_token="+token;
                    System.out.println(url);
                    PostMethod postMethodUser = new PostMethod(url);
                    //提交请求
                    client.executeMethod(postMethodUser);
                    String returnUserString = postMethodUser.getResponseBodyAsString();
                    System.out.println(returnUserString);
                    Map<String, Object> userMap = getMapFromJson(returnUserString);
                    if (userMap.get("resp_code").equals("0000")) {
                        String data = userMap.get("data").toString();
                        //获取用户手机号
                        String useMobile = getMapFromJson(data).get("mobile_no").toString();
                        System.out.println(useMobile);
                    }
                }
            }catch (Exception e){
            }
        }
	}
	public static String getRquestToken() throws Exception{
		String url="http://220.248.45.125:8080/oauth-server/oauth/authorize";
		
		AuthToken authToken=new AuthToken();
		authToken.setClient_id("fa4a54c2-9e73-43ab-8a94-8654b553d422");
		authToken.setRedirect_url("redirect_url");
		authToken.setReturn_param("return_param");
		authToken.setUser_scope("1001,1002");
		String token="7AD0F15A986E6A194D1B819A2C8EA3B7";
		
//		authToken.setRequestXml("<JFPay appUser=\"jfpal\" application=\"CheckToken.Req\" clientType=\"02\" mobileSerialNum=\"860954029542260\" osType=\"android4.1.1\" phone=\"13816443721\" token=\"C907FFC92ADF8B4C27DA39DE84EC64A0\" userIP=\"localhost/127.0.0.1\" version=\"3.3.2\"><mobilNo>13816443721</mobilNo><transDate>20150803</transDate><transTime>181344</transTime><transLogNo>000109</transLogNo><sign>B03A626730ED14586A872BD24EA1A355</sign></JFPay>");
		authToken.setRequestXml(getRequestXml(token));
		authToken.setScope("1001,1002,1003");
		String sign=authToken.values("5faebc61-2566-4024-8e35-88e490fda7c0");
		String resultSign=SHA1Util.sortSHA1(sign);
		authToken.setSign(resultSign);
        String result = "";
		try {
			System.out.println("url=="+url);
            result = HttpURLRequestUtil.sendPost(url,authToken);
			System.out.println("result:"+result);
		} catch (IOException e) {
			e.printStackTrace();
		}
        return result;
	}
	
	
	public static String getRequestXml(String token) throws Exception {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss");
		String transTime = simpleDateFormat.format(new Date());
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMMdd");
		String transDate = simpleDateFormat1.format(new Date());
		String sign1 = API_SIGN_KEY;
		
		String writer="<JFPay appUser=\"jfpal_ccb\" application=\"CheckToken.Req\" clientType=\"02\" mobileSerialNum=\"A43CAD57CC1EE9D2A43C124FCD634CBB600000000\" osType=\"android5.0\" phone=\"15618303123\" token=\""+token+"\" userIP=\"localhost/127.0.0.1\" version=\"3.5.0\">"+
				"<mobilNo>15618303123</mobilNo>"+
				"<transDate>"+transDate+"</transDate>"+
				"<transTime>"+transTime+"</transTime>"+
				"<transLogNo>"+transTime+"</transLogNo>"+
				"<sign>"+sign1+"</sign>"+
				"</JFPay>";
		
		
		String sign = URLDecoder.decode(writer.toString(), "UTF-8");
		sign = URLEncoder.encode(sign, "UTF-8");
		sign = EncodeDigest(sign.getBytes());
		String result = writer.toString().replaceAll(API_SIGN_KEY, sign);
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


    public static Map<String, Object> getMapFromJson(String jsonString) {
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        Map<String, Object> map = new HashMap<String, Object>();
        for (Iterator<?> iter = jsonObject.keys(); iter.hasNext(); ) {
            String key = (String) iter.next();
            map.put(key, jsonObject.get(key));
        }
        return map;
    }

    public static String values(String secret, String client_id, String request_token) {
        StringBuffer sb = new StringBuffer();
        sb.append(client_id);
        sb.append(request_token);
        sb.append(secret);
        return sb.toString();
    }
}
