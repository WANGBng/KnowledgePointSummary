package com.bwie.my.utils;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * date:2018/12/10.
 * Created by 王丙均
 */

public class HttpUtils {
    private static final String TAG = "HttpUtils";
    public final Api api;
    private HttpUtils(){
        OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(new Logging()).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Contest.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
        api = retrofit.create(Api.class);
    }


    private class Logging implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();
            Request.Builder builder = chain.request().newBuilder().addHeader("source", "android");

            Log.e(TAG, "request: "+request);
            Response proceed = chain.proceed(request);
            return proceed;
        }
    }


    public static class GetNetData{
        private static HttpUtils httpUtils = new HttpUtils();
    }
    public static HttpUtils getdatanet(){
        return GetNetData.httpUtils;
    }



}
