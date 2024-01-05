package com.art.apifeature.spaceport.transport;

import java.time.LocalDate;

public record Plane(TransportType type,
                    String id,
                    Integer passengerAmount,
                    String model,
                    String district,
                    LocalDate madeIn,
                    String madeBy) {
}
