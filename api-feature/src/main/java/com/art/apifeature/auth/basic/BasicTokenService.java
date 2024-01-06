package com.art.apifeature.auth.basic;

import com.art.apifeature._common.helpers.CheckBasicToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BasicTokenService {

    private final BasicTokenProperties basicTokenProperties;

    public String getBasicToken() {
        return basicTokenProperties.getBasicToken();
    }

    public boolean checkToken(String basicToken) {
        return CheckBasicToken.decodeBasicToken(basicToken, "art:123");
    }
}
