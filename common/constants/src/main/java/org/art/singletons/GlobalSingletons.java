package org.art.singletons;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GlobalSingletons {

    private static Random random;
    private static ObjectMapper objectMapper;
    private static Gson gson;

    public static Random getInstanceRandom() {
        return random == null ? random = new Random() : random;
    }

    public static ObjectMapper getInstanceObjectMapper() {
        return objectMapper == null ? objectMapper = new ObjectMapper().registerModule(new JavaTimeModule()) : objectMapper;
    }

    public static Gson getInstanceGson() {
        return gson == null ? gson = new Gson() : gson;
    }
}
