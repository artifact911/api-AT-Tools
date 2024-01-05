package com.art.apifeature.spaceport.transport;

import java.time.LocalDate;

public record Ship(TransportType type,
                   String id,
                   Integer crewAmount,
                   Boolean weapon,
                   LocalDate madeIn,
                   String madeBy,
                   String displacement) {
}
