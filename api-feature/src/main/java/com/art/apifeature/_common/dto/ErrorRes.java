package com.art.apifeature._common.dto;

import com.art.apifeature._common.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ErrorRes extends SuccessRes {

    private final String errorType;
    private final Message message;

    public ErrorRes(int statusCode, Status status, String info, String errorType, Message message) {
        super(statusCode, status, info);
        this.errorType = errorType;
        this.message = message;
    }

    @Getter
    @AllArgsConstructor
    public static class Message {

        private String ru;
        private String en;
    }
}
