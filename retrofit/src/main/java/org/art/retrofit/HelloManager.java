package org.art.retrofit;

import lombok.SneakyThrows;
import org.art.RetrofitClientFactory;

public class HelloManager {

    HelloService helloService = RetrofitClientFactory.initService(HelloService.class);

    @SneakyThrows
    public String getHello() {
        System.out.println();
        return helloService.getHello().execute().body();
    }
}
