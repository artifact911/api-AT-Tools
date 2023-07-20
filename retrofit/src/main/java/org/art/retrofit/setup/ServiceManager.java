package org.art.retrofit.setup;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.art.errors.ErrorBody;
import org.art.retrofit.interceptors.BasicApiHeadersInterceptor;
import org.art.singletons.GlobalSingletons;
import org.springframework.beans.factory.annotation.Autowired;
import retrofit2.Response;

import javax.annotation.PostConstruct;
import java.util.List;

@RequiredArgsConstructor
public abstract class ServiceManager {


    @Autowired
    protected ServiceBuilder serviceBuilder;

    @Autowired
    private BasicApiHeadersInterceptor basicApiHeadersInterceptor;
    private final ObjectMapper objectMapper = GlobalSingletons.getInstanceObjectMapper();

    @PostConstruct
    private void init() {
        serviceBuilder.addInterceptor(basicApiHeadersInterceptor);
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

    @SneakyThrows
    protected final RequestBody createRequest(final Object request) {
        return serviceBuilder.getConverter().createRequest(request);
    }
}
