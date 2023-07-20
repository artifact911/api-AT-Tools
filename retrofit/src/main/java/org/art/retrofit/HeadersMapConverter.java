package org.art.retrofit;

import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public final class HeadersMapConverter {

    public static Map<String, Object> convertMapAnyToObject(final Map<String, ?> map) {
        return map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
