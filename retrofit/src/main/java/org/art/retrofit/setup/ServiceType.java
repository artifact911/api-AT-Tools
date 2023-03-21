package org.art.retrofit.setup;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static org.art.Hosts.LOCALHOST_8083;

@Getter
@AllArgsConstructor
public enum ServiceType {

    LOCALHOST(LOCALHOST_8083 + "v1/api/");

    private final String baseUrl;
}
