package org.art;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileReadUtils {

    public static String readContent(String filePath) throws IOException {
        File expectedResult = new ClassPathResource(filePath).getFile();
        return new String(Files.readAllBytes(expectedResult.toPath()));
    }

    @SneakyThrows
    public static String getFileContent(String path) {
        File file = new File(path);
        return FileUtils.readFileToString(file, "UTF-8").replace("\r\n", "\n");
    }
}
