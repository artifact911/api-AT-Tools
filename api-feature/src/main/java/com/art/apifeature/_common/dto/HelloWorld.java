package com.art.apifeature._common.dto;

import com.art.apifeature._common.FeaturesApi;
import lombok.Getter;

public class HelloWorld {

    private static final String HELLO = "Hello from %s!";

    @Getter
    private String from;

    public HelloWorld(FeaturesApi api) {
        this.from = String.format(HELLO, api.getName());
    }
}
