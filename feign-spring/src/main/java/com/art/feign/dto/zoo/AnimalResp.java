package com.art.feign.dto.zoo;

public record AnimalResp(Long id,
                         String type,
                         Integer age,
                         String name) {
}
