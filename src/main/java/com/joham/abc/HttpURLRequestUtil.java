package com.joham.abc;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;


/**
 * @author herion
 *
 */
public class HttpURLRequestUtil {
	
	public static String sendPost(String url,Object object) throws IOException   {

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("Accept-Charset", "UTF-8");  
		con.setRequestProperty("contentType", "UTF-8");
		
		String urlParameters = "";
		
        if(object == null){  
            return null;  
        }          
        BeanInfo beanInfo;
        StringBuffer response = new StringBuffer();
		try {
			beanInfo = Introspector.getBeanInfo(object.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
			for (PropertyDescriptor property : propertyDescriptors) {  
				String key = property.getName();  
				
				// 过滤class属性  
				if (!key.equals("class")) {  
					// 得到property对应的getter方法  
					Method getter = property.getReadMethod();
					Object value = getter.invoke(object);
					if(null!=value){
						String tmpParam = key + "=" + URLEncoder.encode(value.toString(), "UTF-8") + "&";
						urlParameters += tmpParam;
					}
				}  
			}  
		
		
			urlParameters = urlParameters.substring(0, (urlParameters.length() - 1));
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
	 
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream(), "UTF-8"));
			String inputLine;
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} 
 
		return response.toString();
	}
	
	
	public static String sendGet(String url,Object object) throws IOException   {
		String req = url + "?";
		String urlParameters = "";
		BeanInfo beanInfo;
	    StringBuffer response = new StringBuffer();
		try {
			beanInfo = Introspector.getBeanInfo(object.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
			for (PropertyDescriptor property : propertyDescriptors) {  
				String key = property.getName();  
				
				// 过滤class属性  
				if (!key.equals("class")) {  
					// 得到property对应的getter方法  
					Method getter = property.getReadMethod();
					Object value = getter.invoke(object);
					if(null!=value){
						String tmpParam = key + "=" + URLEncoder.encode(value.toString(), "UTF-8") + "&";
						urlParameters += tmpParam;
					}
				}  
			}
			
			urlParameters = urlParameters.substring(0, (urlParameters.length() - 1));
			URL obj = new URL(req + urlParameters);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept-Charset", "UTF-8");  
			con.setRequestProperty("contentType", "UTF-8");  
	 
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream(), "UTF-8"));
			String inputLine;
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return response.toString();
	}
	
	
	
}
