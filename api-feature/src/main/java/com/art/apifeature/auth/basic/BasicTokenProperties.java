package com.art.apifeature.auth.basic;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "basic-auth")
public class BasicTokenProperties extends com.art.apifeature._common.helpers.BasicTokenProperties {
}
