package org.art.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class ReflectionApiUtil {

    @SneakyThrows
    public static Object getValueByField(Field field, Object o) {
        return field.get(o);
    }

    @SneakyThrows
    public static Field getFieldByFieldName(Object o, String fieldName) {
        return o.getClass().getDeclaredField(fieldName);
    }

    @SneakyThrows
    public static void setNewValueToField(Field field, Object objToPatch, Object value) {
        field.set(objToPatch, value);
    }

//    public static void checkFieldValuesNotNull(@NonNull Object o) {

//        assertAll(
//                Stream.of(o.getClass().getDeclaredFields())
//                        .peek(f -> f.setAccessible(true))
//                        .map(f -> () -> {
//                            assertNotNull(getValueByFieldName(f, o), String.format("Поле \"%s\" null", f.getName()));
//                        }));
//    }

//    public static List<Object> getFieldValues(Object e) {
//        List<Object> values = new ArrayList<>();
//        Arrays.stream(e.getClass().getDeclaredFields())
//                .peek(f -> f.setAccessible(true))
//                .forEach(f -> values.add(getValueByFieldName(f, e))); ;
//
//        return values;
//    }

//    @SneakyThrows
//    private static Object getValueByFieldName(@NonNull Field field, Object o) {
//        return field.get(o);
//    }
}
