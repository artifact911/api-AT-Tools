package org.art.retrofit.interceptors;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.art.tokens.TokenStorage;
import org.jetbrains.annotations.NotNull;

import static org.apache.hc.core5.http.HttpHeaders.AUTHORIZATION;
import static org.art.Headers.PREFIX_BEARER;

@AllArgsConstructor
public class AuthInterceptor implements Interceptor {

    private TokenStorage tokenStorage;

    @NotNull
    @SneakyThrows
    @Override
    public Response intercept(@NotNull Chain chain) {
        Request.Builder builder = chain.request().newBuilder();
        if(tokenStorage.getAccessToken() != null) {
            builder = chain.request()
                           .newBuilder()
                           .addHeader(AUTHORIZATION, PREFIX_BEARER + tokenStorage.getAccessToken());
            return chain.proceed(builder.build());
        }
        return chain.proceed(builder.build());
    }
}
