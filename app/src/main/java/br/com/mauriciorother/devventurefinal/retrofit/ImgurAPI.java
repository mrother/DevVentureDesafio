package br.com.mauriciorother.devventurefinal.retrofit;

import br.com.mauriciorother.devventurefinal.model.Picture;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ImgurAPI {

    @Headers("Authorization: Client-ID 1ceddedc03a5d71")
    @GET("gallery/search")
    Call<Picture> getPictures(@Query("q") String queryString, @Query("q_type") String imageType);

}