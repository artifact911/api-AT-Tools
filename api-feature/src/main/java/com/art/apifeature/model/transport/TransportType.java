package com.art.apifeature.model.transport;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TransportType {
    CAR("#CAR"),
    BUS("#BUS"),
    SHIP("#SHIP"),
    PLANE("#PLANE"),
    SPACE_SHIP("#SPACE_SHIP");

    private final String id;
}
