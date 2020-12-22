package com.example.mostratodasbebidas.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InitRetrofit  {

    public static String URL_PADRAO = "https://api.punkapi.com/v2/";
    public static String END_POINT = "beers";
    private static Retrofit retrofit = null;

    public static Retrofit init(){
        retrofit = new Retrofit.Builder()
                .baseUrl(URL_PADRAO)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
