package org.art.retrofit;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface BaseHttpMethodsService {

    String ROOT_EMPTY_PATH_EP = "";
    String PATH_ENDPOINT = "{path}";

    @GET(PATH_ENDPOINT)
    Call<ResponseBody> getRequestWithBooleanQuery(
            @Path(value = "path", encoded = true) String endpoint, @QueryMap Map<String, Boolean> booleanQuery);

    @GET(PATH_ENDPOINT)
    Call<ResponseBody> getRequestWithStringQuery(
            @Path(value = "path", encoded = true) String endpoint, @QueryMap Map<String, String> stringQuery);

    @GET(PATH_ENDPOINT)
    Call<Void> getVoidRequest(@Path(value = "path", encoded = true) String endpoint);

    @GET(PATH_ENDPOINT)
    Call<Void> getVoidRequest(
            @Path(value = "path", encoded = true) String endpoint, @QueryMap Map<String, String> stringQuery);

    @GET(PATH_ENDPOINT)
    Call<ResponseBody> getRequest(@Path(value = "path", encoded = true) String endpoint);

    @GET(PATH_ENDPOINT)
    Call<ResponseBody> getRequest(
            @Path(value = "path", encoded = true) String endpoint, @HeaderMap Map<String, String> headers);

    @GET(PATH_ENDPOINT)
    Call<ResponseBody> getRequest(
            @Path(value = "path", encoded = true) String endpoint,
            @QueryMap Map<String, Boolean> booleanQuery,
            @QueryMap Map<String, String> stringQuery,
            @HeaderMap Map<String, String> headers);

    @GET(PATH_ENDPOINT)
    Call<ResponseBody> getRequest(
            @Path(value = "path", encoded = true) String endpoint,
            @QueryMap Map<String, Object> queries,
            @HeaderMap Map<String, String> headers);

    /*
     * GET метод для использования в ru.alfabank.testing.api_middle.retrofit.services.common.commonretrofitmanager.HttpRequestFactory
     * Использовать на свой страх и риск =)
     * */
    @GET(PATH_ENDPOINT)
    Call<ResponseBody> get(
            @Path(value = "path", encoded = true) String endpoint,
            @QueryMap Map<String, Object> queries,
            @HeaderMap Map<String, Object> headers);

    @POST(PATH_ENDPOINT)
    Call<ResponseBody> postRequest(
            @Path(value = "path", encoded = true) String endpoint, @Body RequestBody requestBody);

    @POST(PATH_ENDPOINT)
    Call<ResponseBody> postRequest(
            @Path(value = "path", encoded = true) String endpoint,
            @Body RequestBody requestBody,
            @HeaderMap Map<String, String> headerMap);

    @POST(PATH_ENDPOINT)
    Call<ResponseBody> postRequest(
            @Path(value = "path", encoded = true) String endpoint, @HeaderMap Map<String, String> headerMap);

    @POST(PATH_ENDPOINT)
    Call<ResponseBody> postRequest(@Path(value = "path", encoded = true) String endpoint);

    @POST(PATH_ENDPOINT)
    Call<ResponseBody> postRequest(
            @Path(value = "path", encoded = true) String endpoint,
            @HeaderMap Map<String, String> headerMap,
            @QueryMap Map<String, String> stringQuery);

    @POST(PATH_ENDPOINT)
    Call<ResponseBody> postRequest(
            @Path(value = "path", encoded = true) String endpoint,
            @Body RequestBody requestBody,
            @QueryMap Map<String, Object> queries,
            @HeaderMap Map<String, Object> headerMap);

    @PATCH(PATH_ENDPOINT)
    Call<ResponseBody> patchRequest(
            @Path(value = "path", encoded = true) String endpoint,
            @Body RequestBody requestBody,
            @HeaderMap Map<String, String> headerMap);

    @PATCH(PATH_ENDPOINT)
    Call<ResponseBody> patchRequest(
            @Path(value = "path", encoded = true) String endpoint, @HeaderMap Map<String, String> headerMap);

    @PUT(PATH_ENDPOINT)
    Call<ResponseBody> putRequest(
            @Path(value = "path", encoded = true) String endpoint, @HeaderMap Map<String, String> headerMap);

    @PUT(PATH_ENDPOINT)
    Call<ResponseBody> putRequest(@Path(value = "path", encoded = true) String endpoint, @Body RequestBody requestBody);

    @PUT(PATH_ENDPOINT)
    Call<ResponseBody> putRequest(
            @Path(value = "path", encoded = true) String endpoint,
            @Body RequestBody requestBody,
            @HeaderMap Map<String, String> headerMap);

    /*
     * PUT метод для использования в ru.alfabank.testing.api_middle.retrofit.services.common.commonretrofitmanager.HttpRequestFactory
     * Использовать на свой страх и риск =)
     * */
    @PUT(PATH_ENDPOINT)
    Call<ResponseBody> put(
            @Path(value = "path", encoded = true) String endpoint,
            @Body RequestBody requestBody,
            @HeaderMap Map<String, Object> headerMap,
            @QueryMap Map<String, Object> queryMap);

    @DELETE(PATH_ENDPOINT)
    Call<ResponseBody> deleteRequest(@Path(value = "path", encoded = true) String endpoint);

    @DELETE(PATH_ENDPOINT)
    Call<ResponseBody> deleteRequest(
            @Path(value = "path", encoded = true) String endpoint, @HeaderMap Map<String, String> headerMap);

    @DELETE(PATH_ENDPOINT)
    Call<ResponseBody> deleteRequest(
            @Path(value = "path", encoded = true) String endpoint,
            @QueryMap Map<String, String> queries,
            @HeaderMap Map<String, String> headers);
}
