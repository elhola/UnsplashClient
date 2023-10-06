// com.yarmcfly.listjpg/PhotoApi java interface -->
package com.yarmcfly.listjpg;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PhotoApi {
    @GET("photos")
    Call<List<UnsplashPhoto>> getPhotos(@Query("client_id") String clientId);
}