package com.art.apifeature.model.transport;

import java.time.LocalDate;

public record Ship(TransportType type,
                   String id,
                   Integer crewAmount,
                   Boolean weapon,
                   LocalDate madeIn,
                   String madeBy,
                   String displacement) {
}
