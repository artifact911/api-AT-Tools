package com.art.apifeature._common.helpers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CheckBasicToken {

    public static boolean decodeBasicToken(String basicToken, String original) {
        byte[] decoded = Base64.getDecoder().decode(basicToken);
        return original.equals(new String(decoded, StandardCharsets.UTF_8));
    }
}
