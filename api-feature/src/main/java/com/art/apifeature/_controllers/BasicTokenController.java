package com.art.apifeature._controllers;

import com.art.apifeature.auth.basic.BasicTokenService;
import com.art.apifeature.auth.basic.dto.GetBasicToken;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic/auth")
@RequiredArgsConstructor
public class BasicTokenController {

    private final BasicTokenService basicTokenService;

    @GetMapping
    public ResponseEntity<?> getToken() {
        return ResponseEntity.ok(new GetBasicToken(basicTokenService.getBasicToken()));
    }
}
