package com.example.onlinestore;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    public static final String base_url = "http://restapi.adequateshop.com";
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
