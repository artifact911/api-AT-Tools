package org.art.helpers.response;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.art.common.SchoolApi;
import org.art.common.Status;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RespEntityHelper {

    public static ResponseEntity<?> getErrorResp(HttpMethod method, SchoolApi api, HttpStatus httpStatus, String info) {
        return ResponseEntity.status(httpStatus)
                .contentType(MediaType.APPLICATION_JSON).body(getErrorRespEntity(method, api, httpStatus, info));
    }
    public static ResponseEntity<?> getErrorResp(HttpMethod method, SchoolApi api, HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus)
                .contentType(MediaType.APPLICATION_JSON).body(getErrorRespEntity(method, api, httpStatus, "-"));
    }

    public static ResponseEntity<?> getSuccessResp(HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus)
                .contentType(MediaType.APPLICATION_JSON).body(getSuccessRespEntity(httpStatus, "-"));
    }

    public static ResponseEntity<?> getSuccessResp(HttpStatus httpStatus, String info) {
        return ResponseEntity.status(httpStatus)
                .contentType(MediaType.APPLICATION_JSON).body(getSuccessRespEntity(httpStatus, info));
    }

    private static ErrorRes getErrorRespEntity(HttpMethod method, SchoolApi api, HttpStatus httpStatus, String info) {
        return new ErrorRes(httpStatus.value(),
                Status.FAILED,
                info,
                api.name() + "_ERROR",
                new ErrorRes.Message("Ошибка запроса " + method.name() + " к " + api.getName(),
                        "Failed request " + method.name() + " to " + api.getName()));
    }

    private static SuccessRes getSuccessRespEntity(HttpStatus httpStatus, String info) {
        return new SuccessRes(httpStatus.value(), Status.SUCCESS, info);
    }
}
