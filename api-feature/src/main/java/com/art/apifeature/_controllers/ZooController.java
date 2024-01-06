package com.art.apifeature._controllers;

import com.art.apifeature._common.FeaturesApi;
import com.art.apifeature._common.dto.HelloWorld;
import com.art.apifeature.animals.AnimalService;
import com.art.apifeature.animals.dto.CreateAnimalReqBody;
import com.art.apifeature.animals.exception.ZooException;
import com.art.apifeature.auth.basic.BasicTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.art.apifeature._common.helpers.RespEntityHelper.getErrorResp;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping("/zoo")
@RequiredArgsConstructor
public class ZooController {

    private final AnimalService animalService;
    private final BasicTokenService basicTokenService;

    @GetMapping
    public ResponseEntity<?> hi() {
        return ResponseEntity.ok(new HelloWorld(FeaturesApi.ZOO_API));
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok(animalService.getAll());
        } catch (RuntimeException e) {
            return getErrorResp(HttpMethod.GET, FeaturesApi.ZOO_API, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("/id")
    public ResponseEntity<?> findId(@RequestParam("id") Long id,
                                    @RequestParam("test") String test) {
        try {
            return ResponseEntity.ok(animalService.findById(id));
        } catch (ZooException e) {
            return getErrorResp(HttpMethod.GET, FeaturesApi.ZOO_API, HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/type")
    public ResponseEntity<?> findByType(@RequestHeader("TYPE") String type) {
        try {
            return ResponseEntity.ok(animalService.findByType(type));
        } catch (ZooException e) {
            return getErrorResp(HttpMethod.GET, FeaturesApi.ZOO_API, HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAnimalByType(@RequestHeader(AUTHORIZATION) String token,
                                             @RequestBody CreateAnimalReqBody body) {
        if (!basicTokenService.checkToken(token)) {
            return getErrorResp(HttpMethod.POST, FeaturesApi.ZOO_API, HttpStatus.FORBIDDEN, "Not authorized");
        }

        try {
            return ResponseEntity.ok(animalService.create(body));
        } catch (ZooException e) {
            return getErrorResp(HttpMethod.POST, FeaturesApi.ZOO_API, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping("/add/type")
    public ResponseEntity<?> addAnimalByType(@RequestHeader(AUTHORIZATION) String token,
                                             @RequestParam("type") String type) {
        if (!basicTokenService.checkToken(token)) {
            return getErrorResp(HttpMethod.POST, FeaturesApi.ZOO_API, HttpStatus.FORBIDDEN, "Not authorized");
        }

        try {
            return ResponseEntity.ok(animalService.create(type));
        } catch (ZooException e) {
            return getErrorResp(HttpMethod.POST, FeaturesApi.ZOO_API, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping("/add/random")
    public ResponseEntity<?> addRandomAnimal(@RequestHeader(AUTHORIZATION) String token) {
        if (!basicTokenService.checkToken(token)) {
            return getErrorResp(HttpMethod.POST, FeaturesApi.ZOO_API, HttpStatus.FORBIDDEN, "Not authorized");
        }

        try {
            return ResponseEntity.ok(animalService.create());
        } catch (ZooException e) {
            return getErrorResp(HttpMethod.POST, FeaturesApi.ZOO_API, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
