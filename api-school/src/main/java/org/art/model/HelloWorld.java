package org.art.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HelloWorld {

    @Builder.Default
    private final String hello = "Hello World!";
}
