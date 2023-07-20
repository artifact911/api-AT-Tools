package com.art.apifeature.model.transport;

import java.time.LocalDate;

public record Plane(TransportType type,
                    String id,
                    Integer passengerAmount,
                    String model,
                    String district,
                    LocalDate madeIn,
                    String madeBy) {
}