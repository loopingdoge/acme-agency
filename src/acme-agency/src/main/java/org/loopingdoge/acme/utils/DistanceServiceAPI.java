package org.loopingdoge.acme.utils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DistanceServiceAPI {
    @GET("/")
    Call<DistanceResponse> distance(@Query("from") String from, @Query("to") String to);
}
