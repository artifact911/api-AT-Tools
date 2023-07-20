package org.art.retrofit;

import lombok.NoArgsConstructor;

import java.util.Arrays;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class EndpointFormatterUtil {

    public static String createEndpoint(final String originalString, String... replacements) {
        String resultString = originalString;
        for (String replacement : replacements) {
            resultString = resultString.replaceFirst("\\{.*?\\}", replacement);
        }
        return resultString;
    }

    public static String assembleEndpoint(String... replacements) {
        StringBuilder resultString = new StringBuilder();

        Arrays.stream(replacements).forEach(pathPart -> resultString.append("/" + pathPart));
        return resultString.substring(1);
    }
}
