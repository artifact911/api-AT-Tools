package org.art.resttest.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.art.resttest.util.DateDeserializer;

import java.time.LocalDateTime;

@Data
public class CreateUserResponse {

    private String name;

    private String job;

    private int id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ss.SSSZ")
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;
}
