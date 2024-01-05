package com.art.apifeature._common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FeaturesApi {

    VALUE_FIELD_API("value-field-api"),
    HEADER_API("header-api"),
    ZOO_API("zoo-api");

    private final String name;
}
