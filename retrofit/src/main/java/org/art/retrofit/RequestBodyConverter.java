package org.art.retrofit;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import okhttp3.RequestBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;

@AllArgsConstructor
public final class RequestBodyConverter {

    private Retrofit retrofit;

    @SneakyThrows
    public RequestBody createRequest(final Object request) {

        Converter<Object, RequestBody> converter =
                retrofit.requestBodyConverter(request.getClass(), new Annotation[0], new Annotation[0]);

        if (converter != null) {
            return converter.convert(request);
        } else {
            throw new NullPointerException("Не создано тело запроса");
        }
    }
}
