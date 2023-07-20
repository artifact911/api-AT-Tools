package org.art.school_api.services.hello;

import lombok.SneakyThrows;
import org.art.retrofit.RetrofitClientFactory;

public class HelloManager {

    HelloService helloService = RetrofitClientFactory.initService(HelloService.class);

    @SneakyThrows
    public String getHello() {
        System.out.println();
        return helloService.getHello().execute().body();
    }
}
