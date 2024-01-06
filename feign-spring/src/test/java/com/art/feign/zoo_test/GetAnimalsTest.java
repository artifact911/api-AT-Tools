package com.art.feign.zoo_test;

import com.art.feign.BaseTest;
import com.art.feign.client.SpaceportClient;
import com.art.feign.client.ZooClient;
import com.art.feign.dto.zoo.AnimalResp;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.art.Hosts.LOCALHOST_8084;
import static org.junit.jupiter.api.Assertions.*;

public class GetAnimalsTest extends BaseTest {

    private ZooClient zooClient;

    @BeforeAll
    public void setUp() {
        zooClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger(ZooClient.class))
                .logLevel(Logger.Level.FULL)
                .target(ZooClient.class, LOCALHOST_8084);
    }

    @Test
    public void getAllAnimals() {
        List<AnimalResp> allAnimals = zooClient.getAllAnimals();

        assertTrue(allAnimals.size() > 1);
    }

    @Test
    public void getAnimalById() {
        AnimalResp animalById = zooClient.getAnimalById(Map.of("id", 2,
                "test", "test"));

        assertEquals(2, animalById.id());
    }

    @Test
    public void getAnimalsByType() {
        List<AnimalResp> animalByType = zooClient.getAnimalByType(Map.of("TYPE", "Spider"));

        assertFalse(animalByType.isEmpty());
    }
}
