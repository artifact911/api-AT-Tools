package com.art.feign.zoo_test;

import com.art.feign.BaseTest;
import com.art.feign.client.BasicAuthClient;
import com.art.feign.client.ZooClient;
import com.art.feign.dto.zoo.AnimalResp;
import com.art.feign.dto.zoo.CreateAnimalReq;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.art.Hosts.LOCALHOST_8084;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateAnimalTest extends BaseTest {

    private ZooClient zooClient;

    private String basicToken;

    @BeforeAll
    public void setUp() {
        zooClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger(ZooClient.class))
                .logLevel(Logger.Level.FULL)
                .target(ZooClient.class, LOCALHOST_8084);

        BasicAuthClient basicAuthClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger(BasicAuthClient.class))
                .logLevel(Logger.Level.FULL)
                .target(BasicAuthClient.class, LOCALHOST_8084);

        basicToken = basicAuthClient.getBasicToken().token().split(" ")[1];
    }

    @Test
    public void createRandomAnimal() {
        AnimalResp randomAnimal = zooClient.postRandomAnimal(Map.of("Authorization", basicToken));

        assertTrue(randomAnimal.id() > 15);
    }

    @Test
    public void createAnimalByType() {
        AnimalResp animalByType = zooClient.postAnimalByType(Map.of("Authorization", basicToken),
                Map.of("type", "wolf"));

        assertEquals("WOLF", animalByType.type());
    }

    @Test
    public void createAnimal() {
        Map<String, String> map = Map.of("Authorization", basicToken);
        CreateAnimalReq req = new CreateAnimalReq("TIGER", 5, "KorbenDallas");
        AnimalResp postAnimal = zooClient.postAnimal(map, req);

        assertEquals("KorbenDallas", postAnimal.name());
    }
}
