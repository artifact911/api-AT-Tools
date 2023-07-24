package org.art;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class ExpectedResultUtils {

    public static final String PATH_TO_EXPECTED_FOLDER = "exp_result/";

    @SneakyThrows
    public static <T> T getObjectFromResource(String filePath, Class<T> clazz) {
        return new Gson().fromJson(FileReadUtils.readContent(filePath), clazz);
    }

    @SneakyThrows
    public static <T> List<T> getListFromResource(String filePath, Class<T> clazz) {
        return new Gson().fromJson(FileReadUtils.readContent(filePath), new ListOf<>(clazz));
    }

    @SneakyThrows
    public static <T> T getObjectFromResourceWithMapper(String filePath, Class<T> clazz) {
        var mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(new File(filePath), clazz);
    }

    //TODO че-то с чтением файла по пути: без абсолютного не находит файл
    @SneakyThrows
    public static <T> T getObjectFromResourceWithMapper1(String filePath, Class<T> clazz) {
        var mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(new ClassPathResource(filePath).getFile(), clazz);
    }

    private static class ListOf<T> implements ParameterizedType {

        private final Class<T> type;

        ListOf(Class<T> type) {
            this.type = type;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return new Type[]{type};
        }

        @Override
        public Type getRawType() {
            return List.class;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }
    }
}
