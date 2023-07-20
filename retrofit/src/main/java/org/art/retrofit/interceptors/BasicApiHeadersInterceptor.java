package org.art.retrofit.interceptors;

import lombok.SneakyThrows;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class BasicApiHeadersInterceptor implements Interceptor {

    @NotNull
    @SneakyThrows
    @Override
    public Response intercept(@NotNull Chain chain) {
        Request originalReq = chain.request();
        Request.Builder builder = originalReq.newBuilder().addHeader("Content-Type", "application/json");
        Request newReq = builder.build();
        return chain.proceed(newReq);
    }
}
