package org.art.tokens;

import lombok.Getter;
import org.art.CredentialsProvider;

@Getter
public class TokenStorage {

    private final String accessToken;
    private final String refreshToken;

    public TokenStorage(CredentialsProvider provider) {
        TokensResponse tokens = TokensHelper.getFullTokensByCred(provider);
        this.accessToken = tokens.getAccessToken();
        this.refreshToken = tokens.getRefreshToken();
    }
}
