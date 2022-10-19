package org.art.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface HelloService {

    @GET("people/")
    @Headers("Content-Type: application/json")
    Call<String> getHello();
}
