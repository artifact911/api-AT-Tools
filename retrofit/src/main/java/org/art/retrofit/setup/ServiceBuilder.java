package org.art.retrofit.setup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.art.retrofit.RequestBodyConverter;
import org.art.retrofit.interceptors.PrettyLoggingInterceptor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.art.retrofit.interceptors.PrettyLoggingInterceptor.Level.VERBOSE;

@Slf4j
@Component
@Scope("prototype")
@Getter
@NoArgsConstructor
public class ServiceBuilder {

    private List<Interceptor> interceptors = new ArrayList<>();
    private RequestBodyConverter converter;

    public static OkHttpClient.Builder getOkHttpClientBuilder() {
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
    }

    public <T> T build(Class<T> clazz) {
        Service service = clazz.isAnnotationPresent(Service.class) ? clazz.getAnnotation(Service.class) : null;
        OkHttpClient.Builder okHttpClientBuilder = getOkHttpClientBuilder();
        interceptors.forEach(okHttpClientBuilder::addInterceptor);
        assert service != null;
        return getRetrofit(okHttpClientBuilder, service).create(clazz);
    }

    private Retrofit getRetrofit(OkHttpClient.Builder okHttpClientBuilder, Service service) {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(service.type().getBaseUrl() + service.path())
                .client(okHttpClientBuilder.addInterceptor(new PrettyLoggingInterceptor(log::info).setLevel(VERBOSE)).build())
//                .client(okHttpClientBuilder.build())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        converter = new RequestBodyConverter(retrofit);

        return retrofit;
    }

    public ServiceBuilder addInterceptor(Interceptor interceptor) {
        this.interceptors.add(interceptor);
        return this;
    }

    public ServiceBuilder resetInterceptors() {
        this.interceptors = new ArrayList<>();
        return this;
    }
}
