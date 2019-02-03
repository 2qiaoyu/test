package com.joham.okhttp;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

/**
 * @author joham
 * <p>
 * 1.OkhttpClient为网络请求的一个中心，它会管理连接池、缓存、SocketFactory、代理
 * 、各种超时时间、DNS、请求执行结果的分发等许多内容。
 * 2.Request：Request是一个HTTP请求体，比如请求方法GET/POST、URL、Header、Body
 * 请求的换粗策略等。
 * 3.Call：通过OkhttpClient和Request来创建Call，Call是一个Task，它会执行网络请求
 * 并且获得响应。这个Task可以通过execute()同步执行，阻塞至请求成功。也可以通过
 * enqueue()异步执行，会将Call放入一个异步执行队列，由ExecutorService后台执行。
 */

@Slf4j
public class OkHttpUtil {

    private static OkHttpClient mOkHttpClient = new OkHttpClient();

    /**
     * GET同步请求
     *
     * @param url
     * @return
     */
    public static String getSync(String url, Map<String, String> headersMap) {
        Headers headers;
        okhttp3.Headers.Builder headersBuilder = new okhttp3.Headers.Builder();
        if (headersMap != null) {
            for (Map.Entry<String, String> header : headersMap.entrySet()) {
                headersBuilder.add(header.getKey(), header.getValue());
            }
        }
        headers = headersBuilder.build();
        Request request = new Request.Builder().headers(headers)
                .get()
                .url(url)
                .build();
        Call call = mOkHttpClient.newCall(request);
        try {
            Response response = call.execute();
            if (response.isSuccessful()) {
                log.info("GET同步请求成功");
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * GET异步请求
     *
     * @param url
     * @param callback
     */
    public static void getAsync(String url, final OkHttpCallback callback) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                log.info("GET异步请求失败");
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                log.info("GET异步请求成功");
            }
        });
    }

    /**
     * POST同步JSON
     *
     * @param url
     * @param json
     * @return
     */
    public static String postSyncJSON(String url, String json, Map<String, String> headersMap) {
        Headers headers;
        okhttp3.Headers.Builder headersBuilder = new okhttp3.Headers.Builder();
        if (headersMap != null) {
            for (Map.Entry<String, String> header : headersMap.entrySet()) {
                headersBuilder.add(header.getKey(), header.getValue());
            }
        }
        headers = headersBuilder.build();
        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, json);
        Request request = new Request.Builder().headers(headers)
                .url(url)
                .post(body)
                .build();
        Call call = mOkHttpClient.newCall(request);
        try {
            Response response = call.execute();
            if (response.isSuccessful()) {
                log.info("POST同步JSON成功");
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * POST同步FORM
     *
     * @param url
     * @param params
     * @return
     */
    public String postSyncForm(String url, Map<String, String> params) {

        RequestBody body = buildParams(params);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = mOkHttpClient.newCall(request);
        try {
            Response response = call.execute();
            if (response.isSuccessful()) {
                log.info("POST同步FORM成功");
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * POST异步JSON
     *
     * @param url
     * @param json
     * @param callback
     */
    public void postAsyncJSON(String url, String json, final OkHttpCallback callback) {

        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, json);

        final Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                log.info("POST异步JSON失败");
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                log.info("POST异步JSON成功");
            }
        });
    }

    /**
     * POST异步FORM
     *
     * @param url
     * @param params
     * @param callback
     */
    public void postAsyncForm(String url, Map<String, String> params, final OkHttpCallback callback) {

        RequestBody body = buildParams(params);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                log.info("POST异步FORM成功");
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                log.info("POST异步FORM失败");
            }
        });
    }


    /**
     * 异步文件参数混合上传
     *
     * @param url
     * @param params
     * @param file
     * @param callback         响应回调
     * @param progressListener 进度回调
     */
    public void asyncUploadFileAndParams(String url, Map<String, String> params, File file,
                                         final OkHttpCallback callback, ProgressRequestBody.ProgressListener progressListener) {
        //表示任意二进制流
        RequestBody requestBody = RequestBody.
                create(MediaType.parse("application/octet-stream"), file);
        //因为是文件参数混合上传，所以要分开构建
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.addFormDataPart(entry.getKey(), entry.getValue());
            }
        }
        RequestBody multipartBody = builder
                //key需要服务器提供，相当于键值对的键
                .addFormDataPart("image", file.getName(), requestBody)
                .build();
        ProgressRequestBody countingRequestBody
                = new ProgressRequestBody(multipartBody, progressListener);
        Request request = new Request.Builder()
                .url(url)
                .post(countingRequestBody)
                .build();
        Call call = mOkHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                System.out.println("9");
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                System.out.println("10");
            }
        });

    }

    /**
     * 参数添加到表单中
     *
     * @param params
     * @return
     */
    public RequestBody buildParams(Map<String, String> params) {
        if (params == null) {
            params = new HashMap<>();
        }
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            builder.add(key, value);
        }
        return builder.build();
    }

    //根据tag取消单个请求
    //最终的取消时通过拦截器RetryAndFollowUpInterceptor进行的
    public void cancel(Call call) {
        //queuedCalls()代表所有准备运行的异步任务
        for (Call dispatcherCal1 : mOkHttpClient.dispatcher().queuedCalls()) {
            if (call.request().tag().equals(call.request().tag())) {
                call.cancel();
            }
        }
        //runningCalls()代表所有正在运行的任务(包括同步和异步)
        for (Call dispatcherCal1 : mOkHttpClient.dispatcher().runningCalls()) {
            if (call.request().tag().equals(call.request().tag())) {
                call.cancel();
            }
        }
    }

    /**
     * 取消全部请求
     */
    public void cancelAll() {
        mOkHttpClient.dispatcher().cancelAll();
    }

    public interface OkHttpCallback {
        void onResponse(Response response);

        void onError(IOException e);
    }

}
