package org.art.retrofit.setup;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.art.errors.ErrorBody;
import org.art.retrofit.interceptors.BasicApiHeadersInterceptor;
import org.art.singletons.GlobalSingletons;
import retrofit2.Response;

import java.util.List;

public abstract class ServiceManager {

    protected ServiceBuilder serviceBuilder;
    private final ObjectMapper objectMapper;

    {
        serviceBuilder = new ServiceBuilder();
        objectMapper = GlobalSingletons.getInstanceObjectMapper();
    }

    public ServiceManager() {
        init();
    }

    private void init() {
        serviceBuilder.addInterceptor(new BasicApiHeadersInterceptor());
    }

    @SneakyThrows
    public ErrorBody getErrorBody(Response response) {
        assert response.errorBody() != null;
        return objectMapper.readValue(response.errorBody().string(), ErrorBody.class).setResponseCode(response.code());
    }

    @SneakyThrows
    public <T> T getBody(Response<ResponseBody> response, Class<T> clazz) {

        ResponseBody responseBody = response.body() != null ? response.body() : response.errorBody();
        assert responseBody != null;

        return objectMapper.readValue(responseBody.string(), clazz);
    }

    @SneakyThrows
    public <T> List<T> getBodyList(Response<ResponseBody> response, Class<T> clazz) {
        assert response.body() != null;
        return objectMapper.readerForListOf(clazz).readValue(response.body().string());
    }

    @SneakyThrows
    public <T> T getResponseClass(Response<ResponseBody> response, Class<T> clazz) {
        return clazz.isAssignableFrom(ErrorBody.class) ? clazz.cast(getErrorBody(response)) : getBody(response, clazz);
    }
}
