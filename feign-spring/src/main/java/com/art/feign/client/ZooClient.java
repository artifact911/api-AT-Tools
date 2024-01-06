package com.art.feign.client;

import com.art.feign.dto.zoo.AnimalResp;
import com.art.feign.dto.zoo.CreateAnimalReq;
import feign.*;

import java.util.List;
import java.util.Map;

public interface ZooClient {

    @RequestLine("GET /v1/api/zoo/all")
    List<AnimalResp> getAllAnimals();

    @RequestLine("GET /v1/api/zoo/id")
    AnimalResp getAnimalById(@QueryMap Map<String, Object> queries);

    @RequestLine("GET /v1/api/zoo/type")
    List<AnimalResp> getAnimalByType(@HeaderMap Map<String, String> headers);

    // Response если хотим универсалить методы
    @RequestLine("POST /v1/api/zoo/add/random")
    Response postRandomAnimal(@HeaderMap Map<String, String> headers);

    @RequestLine("POST /v1/api/zoo/add/type")
    AnimalResp postAnimalByType(@HeaderMap Map<String, String> headers,
                                @QueryMap Map<String, Object> queries);

    @RequestLine("POST /v1/api/zoo/add")
    // без явного application/json не принимало тело запроса
    @Headers("Content-Type: application/json")
    AnimalResp postAnimal(@HeaderMap Map<String, String> headers,
                          CreateAnimalReq request);
}
