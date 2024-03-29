package com.art.apifeature.spaceport.transport;

import java.time.LocalDate;

public record Bus(TransportType type,
                  String id,
                  Integer passengerAmount,
                  String model,
                  String district,
                  LocalDate madeIn,
                  String madeBy) {
}
