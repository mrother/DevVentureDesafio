package br.com.mauriciorother.devventurefinal.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;
    private static final String baseUrl = "https://api.imgur.com/3/";

    public RetrofitConfig() {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public ImgurAPI getFetchPhotosAPI() {
        return retrofit.create(ImgurAPI.class);
    }
}
