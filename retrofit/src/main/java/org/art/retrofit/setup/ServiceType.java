package org.art.retrofit.setup;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static org.art.Hosts.LOCALHOST_8083;
import static org.art.Hosts.LOCALHOST_8084;

@Getter
@AllArgsConstructor
public enum ServiceType {

    LOCALHOST_83(LOCALHOST_8083 + "v1/api/"),
    LOCALHOST_84(LOCALHOST_8084 + "v1/api/");

    private final String baseUrl;
}
