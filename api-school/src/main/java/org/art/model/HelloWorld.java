package org.art.model;

import lombok.Getter;
import org.art.common.Api;

public class HelloWorld {

    private static final String HELLO = "Hello from %s!";

    @Getter
    private String from;

    public HelloWorld(Api api) {
        this.from = String.format(HELLO, api.getName());
    }
}
