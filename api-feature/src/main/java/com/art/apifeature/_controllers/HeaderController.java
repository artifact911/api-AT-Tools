package com.art.apifeature._controllers;

import com.art.apifeature._common.FeaturesApi;
import com.art.apifeature._common.dto.HelloWorld;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.net.InetSocketAddress;
import java.util.Map;

import static com.art.apifeature._common.helpers.RespEntityHelper.getErrorResp;

@RestController
@RequestMapping("/header")
public class HeaderController {

    /**
     * <a href="https://www.baeldung.com/spring-rest-http-headers">...</a>
     */

    @GetMapping
    public ResponseEntity<?> hi() {
//        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body("Hello World!");
        HelloWorld helloWorld = new HelloWorld(FeaturesApi.HEADER_API);
        return ResponseEntity.ok(helloWorld);
    }


    // Обязательный 1 хедер
    // 400 - если хедера нет
    @GetMapping("required/one/string")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> reqOneHeaderString(
            // равнозначные записи
//            @RequestHeader(name = HttpHeaders.ACCEPT_LANGUAGE) String language
//            @RequestHeader(value = HttpHeaders.ACCEPT_LANGUAGE) String language
            @RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("Header Accept-Language is: " + language);
        } catch (RuntimeException e) {
            return getErrorResp(HttpMethod.GET, FeaturesApi.HEADER_API, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    // НЕобязательный 1 хедер
    // Обязательно проверяем на null, т.к. может не быть хедера
    @GetMapping("optional/one/string")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> optionalOneHeaderString(
            @RequestHeader(value = "optional-header", required = false) String optionalHeader) {

        String header = "Was the optional header present? %s!";

        try {
            return new ResponseEntity<String>(String.format(header,
                    (optionalHeader == null
                            ? "No"
                            : "Yes: " + optionalHeader)), HttpStatus.OK);
        } catch (RuntimeException e) {
            return getErrorResp(HttpMethod.GET, FeaturesApi.HEADER_API, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }


    // Много хедеров
    // использование Map
    // если один из заголовков имеет более одного значения, мы получим только первое значение.
    // Это эквивалент использования метода getFirst в MultiValueMap
    @GetMapping("/map")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> mapHeader(@RequestHeader Map<String, String> headersMap) {

        String headers = "Header '%s' = %s" + "\n";

        StringBuilder stringBuilder = new StringBuilder();

        try {
            headersMap.forEach((key, value) -> {
                stringBuilder.append(String.format(headers, key, value));
            });
            return new ResponseEntity<>(stringBuilder, HttpStatus.OK);
        } catch (RuntimeException e) {
            return getErrorResp(HttpMethod.GET, FeaturesApi.HEADER_API, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    // Много хедеров
    // использование MultiValueMap
    // Если наши заголовки могут иметь несколько значений, мы можем получить их как MultiValueMap
    @GetMapping("/multivaluemap")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> multiValueMapHeader(@RequestHeader MultiValueMap<String, String> headersMap) {

        String headers = "Header '%s' = %s" + "\n";

        StringBuilder stringBuilder = new StringBuilder();

        try {
            headersMap.forEach((key, value) -> {
                stringBuilder.append(String.format(headers, key, String.join("|", value)));
            });
            return new ResponseEntity<>(stringBuilder, HttpStatus.OK);
        } catch (RuntimeException e) {
            return getErrorResp(HttpMethod.GET, FeaturesApi.HEADER_API, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    // Мы также можем получить наши заголовки как объект HttpHeaders
    // Объект HttpHeaders имеет методы доступа для общих заголовков приложений
    @GetMapping("/httpheaders")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> httpHeaders(@RequestHeader HttpHeaders headers) {

        StringBuilder stringBuilder = new StringBuilder();
        InetSocketAddress host = headers.getHost();
        String url = "http://" + host.getHostName() + ":" + host.getPort();
        String accessControlRequestMethod = headers.getAccept().toString();
        stringBuilder.append(url).append("\n").append(accessControlRequestMethod);

        try {
            return new ResponseEntity<>(stringBuilder, HttpStatus.OK);
        } catch (RuntimeException e) {
            return getErrorResp(HttpMethod.GET, FeaturesApi.HEADER_API, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

}
