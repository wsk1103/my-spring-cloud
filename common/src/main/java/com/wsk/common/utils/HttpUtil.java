package com.wsk.common.utils;

import okhttp3.*;

import java.io.IOException;

/**
 * @author WuShukai
 * @version V1.0
 * @description
 * @date 2018/11/30  16:05
 */
public class HttpUtil {

    private static OkHttpClient client = new OkHttpClient();

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * get请求
     *
     * @param url 请求地址
     * @return String
     * @throws IOException IO
     */
    public static String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        assert response.body() != null;
        return response.body().string();
    }


    /**
     * post请求
     *
     * @param url  请求地址
     * @param json 请求参数
     * @return String
     * @throws IOException IO
     */
    public static String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        assert response.body() != null;
        return response.body().string();
    }
}
