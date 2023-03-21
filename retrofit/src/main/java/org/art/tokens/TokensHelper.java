package org.art.tokens;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.art.CredentialsProvider;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TokensHelper {

    public static TokensResponse getFullTokensByCred(CredentialsProvider provider) {
      return new TokensResponse("access", "refresh");
    }
}
