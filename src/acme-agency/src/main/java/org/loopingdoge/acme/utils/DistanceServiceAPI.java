package org.loopingdoge.acme.utils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DistanceServiceAPI {
    @GET("{from}/{to}")
    Call<DistanceResponse> distance(@Path("from") String from, @Path("to") String to);
}
