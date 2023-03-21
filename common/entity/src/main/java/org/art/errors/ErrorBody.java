package org.art.errors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "errorId")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorBody {

    private String errorId;
    private String application;
    private String errorCode;
    private Messages messages;
    private String boldText;
    private String innerText;
    private String serviceId;
    private int responseCode;
    private String endpoint;

    public ErrorBody setResponseCode(int code) {
        responseCode = code;
        return this;
    }
}
