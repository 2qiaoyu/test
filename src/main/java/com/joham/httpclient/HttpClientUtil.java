package com.joham.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * http请求封装
 *
 * @author qiaoyu
 */
public class HttpClientUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtil.class);

    /**
     * get 方法
     *
     * @param url        请求url
     * @param headersMap 头部信息封装
     * @return 接口返回
     */
    public static String get(String url, Map<String, String> headersMap) {
        String strResult = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet request = new HttpGet(url);
            //设置连接超时时间
            RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(2000).setConnectTimeout(2000).setSocketTimeout(2000).build();
            PoolingHttpClientConnectionManager conMgr = new PoolingHttpClientConnectionManager();
            //设置整个连接池最大连接数 根据自己的场景决定
            conMgr.setMaxTotal(200);
            //是路由的默认最大连接（该值默认为2），限制数量实际使用DefaultMaxPerRoute并非MaxTotal。
            //设置过小无法支持大并发(ConnectionPoolTimeoutException: Timeout waiting for connection from pool)，路由是对maxTotal的细分。
            //（目前只有一个路由，因此让他等于最大值）
            conMgr.setDefaultMaxPerRoute(conMgr.getMaxTotal());
            if (headersMap != null) {
                for (Map.Entry<String, String> header : headersMap.entrySet()
                        ) {
                    request.setHeader(header.getKey(), header.getValue());
                }
            }
            request.setConfig(requestConfig);
            HttpResponse response = httpClient.execute(request);
            //请求发送成功，并得到响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                strResult = EntityUtils.toString(response.getEntity(), "utf-8");
                LOGGER.info("请求成功返回：{}", strResult);
                url = URLDecoder.decode(url, "UTF-8");
            } else {
                LOGGER.info("get请求提交失败:" + url + "状态码:" + response.getStatusLine().getStatusCode() + "错误信息：" + response.getEntity().toString());
            }
        } catch (Exception e) {
            LOGGER.info("get请求提交失败,异常信息:" + url + e.getMessage());
        } finally {
            try {
                // 关闭HTTP连接
                httpClient.close();
            } catch (IOException e) {
                // ignore
            }
        }
        return strResult;
    }

    /**
     * post方法
     *
     * @param url        请求url
     * @param headersMap 头部信息封装
     * @param paramsMap  参数封装
     * @return 接口返回
     */
    public static String post(String url, Map<String, String> headersMap, Map<String, String> paramsMap) {
        String strResult = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpPost request = new HttpPost(url);
            if (paramsMap != null) {
                // 用于存放请求参数
                List<NameValuePair> formparams = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
                    formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "utf-8");
                request.setEntity(entity);
            }
            //设置连接超时时间
            RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(2000).setConnectTimeout(2000).setSocketTimeout(2000).build();
            PoolingHttpClientConnectionManager conMgr = new PoolingHttpClientConnectionManager();
            //设置整个连接池最大连接数 根据自己的场景决定
            conMgr.setMaxTotal(200);
            //是路由的默认最大连接（该值默认为2），限制数量实际使用DefaultMaxPerRoute并非MaxTotal。
            //设置过小无法支持大并发(ConnectionPoolTimeoutException: Timeout waiting for connection from pool)，路由是对maxTotal的细分。
            //（目前只有一个路由，因此让他等于最大值）
            conMgr.setDefaultMaxPerRoute(conMgr.getMaxTotal());
            if (headersMap != null) {
                for (Map.Entry<String, String> header : headersMap.entrySet()
                        ) {
                    request.setHeader(header.getKey(), header.getValue());
                }
            }
            request.setConfig(requestConfig);
            HttpResponse response = httpClient.execute(request);
            //请求发送成功，并得到响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                strResult = EntityUtils.toString(response.getEntity(), "utf-8");
                LOGGER.info("请求成功返回：{}", strResult);
                url = URLDecoder.decode(url, "UTF-8");
            } else {
                LOGGER.info("post请求提交失败:" + url + "状态码:" + response.getStatusLine().getStatusCode() + "错误信息：" + response.getEntity().toString());
            }
        } catch (Exception e) {
            LOGGER.info("post请求提交失败,异常信息:" + url + e.getMessage());
        } finally {
            try {
                // 关闭HTTP连接
                httpClient.close();
            } catch (IOException e) {
                // ignore
            }
        }
        return strResult;
    }

    public static String jsonPost(String url, Map<String, String> headersMap, String jsonParam) {
        String strResult = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpPost request = new HttpPost(url);
            if (jsonParam != null) {
                LOGGER.info("postJson参数:{}", jsonParam);
                StringEntity entity = new StringEntity(jsonParam, "utf-8");//解决中文乱码问题
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                request.setEntity(entity);
            }
            //设置连接超时时间
            RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(2000).setConnectTimeout(2000).setSocketTimeout(2000).build();
            PoolingHttpClientConnectionManager conMgr = new PoolingHttpClientConnectionManager();
            //设置整个连接池最大连接数 根据自己的场景决定
            conMgr.setMaxTotal(200);
            //是路由的默认最大连接（该值默认为2），限制数量实际使用DefaultMaxPerRoute并非MaxTotal。
            //设置过小无法支持大并发(ConnectionPoolTimeoutException: Timeout waiting for connection from pool)，路由是对maxTotal的细分。
            //（目前只有一个路由，因此让他等于最大值）
            conMgr.setDefaultMaxPerRoute(conMgr.getMaxTotal());
            if (headersMap != null) {
                for (Map.Entry<String, String> header : headersMap.entrySet()
                        ) {
                    request.setHeader(header.getKey(), header.getValue());
                }
            }
            request.setConfig(requestConfig);
            HttpResponse response = httpClient.execute(request);
            //请求发送成功，并得到响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                strResult = EntityUtils.toString(response.getEntity(), "utf-8");
                LOGGER.info(url + "请求成功，返回：" + strResult);
                url = URLDecoder.decode(url, "UTF-8");
            } else {
                //写入日志
                String errorMessage = "请求提交失败,状态码:" + response.getStatusLine().getStatusCode() + "错误信息：" + EntityUtils.toString(response.getEntity(), "utf-8");
                LOGGER.info(url + errorMessage);
            }
        } catch (Exception e) {
            String errorMessage = "请求提交失败,异常信息:" + url + e.getMessage();
            LOGGER.info(url + errorMessage);
        } finally {
            try {
                // 关闭HTTP连接
                httpClient.close();
            } catch (IOException e) {
            }
        }
        return strResult;
    }

    /**
     * put方法
     *
     * @param url        请求url
     * @param headersMap 头部信息封装
     * @param paramsMap  参数封装
     * @return 接口返回
     */
    public static String put(String url, Map<String, String> headersMap, Map<String, String> paramsMap) {
        String strResult = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpPut request = new HttpPut(url);
            if (paramsMap != null) {
                // 用于存放请求参数
                List<NameValuePair> formparams = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
                    formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "utf-8");
                request.setEntity(entity);
            }
            //设置连接超时时间
            RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(2000).setConnectTimeout(2000).setSocketTimeout(2000).build();
            PoolingHttpClientConnectionManager conMgr = new PoolingHttpClientConnectionManager();
            //设置整个连接池最大连接数 根据自己的场景决定
            conMgr.setMaxTotal(200);
            //是路由的默认最大连接（该值默认为2），限制数量实际使用DefaultMaxPerRoute并非MaxTotal。
            //设置过小无法支持大并发(ConnectionPoolTimeoutException: Timeout waiting for connection from pool)，路由是对maxTotal的细分。
            //（目前只有一个路由，因此让他等于最大值）
            conMgr.setDefaultMaxPerRoute(conMgr.getMaxTotal());
            if (headersMap != null) {
                for (Map.Entry<String, String> header : headersMap.entrySet()
                        ) {
                    request.setHeader(header.getKey(), header.getValue());
                }
            }
            request.setConfig(requestConfig);
            HttpResponse response = httpClient.execute(request);
            //请求发送成功，并得到响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                strResult = EntityUtils.toString(response.getEntity(), "utf-8");
                LOGGER.info("请求成功返回：{}", strResult);
                url = URLDecoder.decode(url, "UTF-8");
            } else {
                LOGGER.info("put请求提交失败:" + url + "状态码:" + response.getStatusLine().getStatusCode() + "错误信息：" + response.getEntity().toString());
            }
        } catch (Exception e) {
            LOGGER.info("put请求提交失败,异常信息:" + url + e.getMessage());
        } finally {
            try {
                // 关闭HTTP连接
                httpClient.close();
            } catch (IOException e) {
                // ignore
            }
        }
        return strResult;
    }

    /**
     * delete 方法
     *
     * @param url        请求url
     * @param headersMap 头部信息封装
     * @return 接口返回
     */
    public static String delete(String url, Map<String, String> headersMap) {
        String strResult = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpDelete request = new HttpDelete(url);
            //设置连接超时时间
            RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(2000).setConnectTimeout(2000).setSocketTimeout(2000).build();
            PoolingHttpClientConnectionManager conMgr = new PoolingHttpClientConnectionManager();
            //设置整个连接池最大连接数 根据自己的场景决定
            conMgr.setMaxTotal(200);
            //是路由的默认最大连接（该值默认为2），限制数量实际使用DefaultMaxPerRoute并非MaxTotal。
            //设置过小无法支持大并发(ConnectionPoolTimeoutException: Timeout waiting for connection from pool)，路由是对maxTotal的细分。
            //（目前只有一个路由，因此让他等于最大值）
            conMgr.setDefaultMaxPerRoute(conMgr.getMaxTotal());
            if (headersMap != null) {
                for (Map.Entry<String, String> header : headersMap.entrySet()
                        ) {
                    request.setHeader(header.getKey(), header.getValue());
                }
            }
            request.setConfig(requestConfig);
            HttpResponse response = httpClient.execute(request);
            //请求发送成功，并得到响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                strResult = EntityUtils.toString(response.getEntity(), "utf-8");
                LOGGER.info("请求成功返回：{}", strResult);
                url = URLDecoder.decode(url, "UTF-8");
            } else {
                LOGGER.info("delete请求提交失败:" + url + "状态码:" + response.getStatusLine().getStatusCode() + "错误信息：" + response.getEntity().toString());
            }
        } catch (Exception e) {
            LOGGER.info("delete请求提交失败,异常信息:" + url + e.getMessage());
        } finally {
            try {
                // 关闭HTTP连接
                httpClient.close();
            } catch (IOException e) {
                // ignore
            }
        }
        return strResult;
    }
}
