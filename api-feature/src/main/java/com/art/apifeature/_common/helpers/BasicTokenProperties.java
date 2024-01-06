package com.art.apifeature._common.helpers;

import lombok.Setter;

import java.util.Base64;

@Setter
public abstract class BasicTokenProperties {

    public static final String BASIC_PREFIX = "Basic ";

    protected String login;

    protected String password;

    public String getBasicToken() {
        return BASIC_PREFIX + Base64.getEncoder().encodeToString((login + ":" + password).getBytes());
    }
}
