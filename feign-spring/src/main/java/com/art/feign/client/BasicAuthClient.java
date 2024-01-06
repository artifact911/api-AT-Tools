package com.art.feign.client;

import feign.RequestLine;
import org.art.basic_auth.BasicToken;

public interface BasicAuthClient {

    @RequestLine("GET /v1/api/basic/auth")
    BasicToken getBasicToken();
}
