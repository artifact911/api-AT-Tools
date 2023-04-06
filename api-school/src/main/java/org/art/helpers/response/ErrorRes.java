package org.art.helpers.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.art.common.Status;

@Getter
public class ErrorRes extends SuccessRes {


    private final String errorType;
    private final Message message;

    public ErrorRes(int statusCode, Status status, String errorType, Message message) {
        super(statusCode, status);
        this.errorType = errorType;
        this.message = message;
    }

    @Getter
    @AllArgsConstructor
    public static class Message {

        private String ru;
        private String en;
        private String cause;
    }
}
