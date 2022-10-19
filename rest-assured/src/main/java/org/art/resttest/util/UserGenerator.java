package org.art.resttest.util;

import org.art.resttest.pojos.CreateUserRequest;

public class UserGenerator {

    public static CreateUserRequest getSimpleUser(){
        return CreateUserRequest.builder()
                .name("simple")
                .job("automation")
                .build();
    }
}
