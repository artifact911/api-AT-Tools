package com.art.apifeature._common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FeaturesApi {

    VALUE_FIELD_API("value-field-api"),
    HEADER_API("header-api"),
    FEIGN_API("feign-api");

    private final String name;
}
