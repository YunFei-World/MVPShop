package com.mvp.mvpshop.network;

import java.net.URI;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author ：yunfeihu
 * @description：TODO
 * @date ：2022/4/19 15:43
 */
public class RetrofitClient {
    private static volatile RetrofitClient mInstance;
    private static final String BASE_URL = "https://raw.githubusercontent.com/";
    private Retrofit retrofit;

    public RetrofitClient() {
    }

    public static RetrofitClient getInstance(){
        if (mInstance == null){
            synchronized (RetrofitClient.class){
                if (mInstance == null){
                    mInstance = new RetrofitClient();
                }
            }
        }
        return mInstance;
    }

    public <T> T getService(Class<T> cls){
        return getRetrofit().create(cls);
    }

    private synchronized Retrofit getRetrofit() {
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }
}