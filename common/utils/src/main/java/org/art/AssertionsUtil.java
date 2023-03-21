package org.art;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.stream.Stream;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@NoArgsConstructor(access = PRIVATE)
public final class AssertionsUtil {

    public static void checkFieldValuesNotNull(@NonNull Object o) {

        assertAll(
                Stream.of(o.getClass().getDeclaredFields())
                      .peek(f -> f.setAccessible(true))
                      .map(f -> () -> {
                          assertNotNull(getValueByFieldName(f, o), String.format("Поле \"%s\" null", f.getName()));
                      }));
    }

    @SneakyThrows
    private static Object getValueByFieldName(@NonNull Field field, Object o) {
        return field.get(o);
    }
}
