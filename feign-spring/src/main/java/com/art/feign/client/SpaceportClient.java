package com.art.feign.client;

import feign.RequestLine;
import org.art.spaceport.GetAllSpaceportResp;

public interface SpaceportClient {

    @RequestLine("GET")
    GetAllSpaceportResp findAll();
}
