package org.art.model;

import lombok.Getter;
import org.art.common.SchoolApi;

public class HelloWorld {

    private static final String HELLO = "Hello from %s!";

    @Getter
    private String from;

    public HelloWorld(SchoolApi api) {
        this.from = String.format(HELLO, api.getName());
    }
}
