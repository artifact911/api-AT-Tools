package org.art.dynamic_fields;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.art.singletons.GlobalSingletons;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ValueFieldParserUtil {

    @SneakyThrows
    public static <T extends DynamicFieldGetter> T getResponseWithDeclaredDynamicField(String response, Class<T> clazz) {
        T t = GlobalSingletons.getInstanceObjectMapper().readValue(response, clazz);
        checkParsedDynamicFieldsTypes(t);
        return t;
    }

    private static void checkParsedDynamicFieldsTypes(DynamicFieldGetter content) {
        if (content.getValueField().stream().anyMatch(Objects::isNull)) {
            throw new NullPointerException("Неопознанный к парсингу тип динамополя");
        }
    }
}
