package com.art.apifeature.model.transport;

import java.time.LocalDate;

public record Car(TransportType type,
                  String id,
                  String cost,
                  String model,
                  LocalDate madeIn,
                  String madeBy) {
}
