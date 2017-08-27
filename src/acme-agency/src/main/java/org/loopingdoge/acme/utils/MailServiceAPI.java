package org.loopingdoge.acme.utils;

import retrofit2.Call;
import retrofit2.http.*;

public interface MailServiceAPI {
    @GET("/{user}")
    Call<MailGetResponse> read(@Path("user") String user, @Query("unread") boolean unread);

    @FormUrlEncoded
    @POST("/{user}")
    Call<MailPostResponse> send(@Path("user") String user, @Field("from") String from, @Field("text") String text);
}
