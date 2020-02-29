package com.example.sowl.challengeclicker.Repository.Network;

import com.example.sowl.challengeclicker.Repository.Utility.ClientConfigs;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebProvider {
    private static Retrofit retrofit;
    private static WebService webService;

    public static Retrofit getRetrofit() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.writeTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES);

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ClientConfigs.REST_API_BASE_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client.build())
                    .build();
        }
        return retrofit;
    }


    public static synchronized WebService getWebService() {
        if (webService == null) {
            webService = getRetrofit().create(WebService.class);
        }
        return webService;
    }


}