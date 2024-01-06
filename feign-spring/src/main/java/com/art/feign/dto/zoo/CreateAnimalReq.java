package com.art.feign.dto.zoo;

public record CreateAnimalReq(String type,
                              Integer age,
                              String name) {
}
