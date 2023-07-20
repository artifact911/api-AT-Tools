package com.art.apifeature.model.transport;

import java.util.List;

public record Spaceport(String name,
                        String id,
                        List<Object> content) {
}
