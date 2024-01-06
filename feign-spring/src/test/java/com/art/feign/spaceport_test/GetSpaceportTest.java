package com.art.feign.spaceport_test;

import com.art.feign.BaseTest;
import com.art.feign.client.SpaceportClient;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.SneakyThrows;
import org.art.spaceport.GetAllSpaceportResp;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.art.Hosts.LOCALHOST_8084;

public class GetSpaceportTest extends BaseTest {

    private SpaceportClient spaceportClient;

    @BeforeAll
    public void prepare() {
        spaceportClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger(SpaceportClient.class))
                .logLevel(Logger.Level.FULL)
                .target(SpaceportClient.class, LOCALHOST_8084);


    }

    @Test
    @SneakyThrows
    void getAllSpaceport() {
        GetAllSpaceportResp allSpaceportResp = spaceportClient.findAll();

//        GetAllSpaceportResp getAllSpaceportResp = objectMapper.readValue(objectMapper.writeValueAsString(allSpaceportResp), GetAllSpaceportResp.class);

        System.out.println();
    }

}
