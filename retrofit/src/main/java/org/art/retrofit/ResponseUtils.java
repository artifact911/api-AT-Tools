package org.art.retrofit;

import lombok.SneakyThrows;
import org.art.retrofit.exceptions.ResponseException;
import retrofit2.Call;
import retrofit2.Response;

public class ResponseUtils {

    private static final String REQUEST_ERROR_MESSAGE = "Request error. Expected response code: %d, actual: %d\nBody:%s";

    public static <T> Response<T> validateResponse(Call<T> call, int expectedCode, String... errorMessage) {
        Response<T> response = executeRequest(call);
        assertCode(response, expectedCode, errorMessage);
        return response;
    }

    @SneakyThrows
    public static <T> Response<T> executeRequest(Call<T> call) {
        return call.execute();
    }

    @SneakyThrows
    private static <T> void assertCode(Response<T> response, int expectedCode, String... errorMessage) {
        int actualCode = response.raw().code();
        if (actualCode != expectedCode) {
            String exceptionMessage = errorMessage.length == 0
                                      ? REQUEST_ERROR_MESSAGE
                                      : errorMessage[0];
            String body = response.errorBody() != null
                          ? response.errorBody().source().readUtf8()
                          : "empty body";
            throw new ResponseException(String.format(exceptionMessage, expectedCode, actualCode, body));
        }
    }
}
