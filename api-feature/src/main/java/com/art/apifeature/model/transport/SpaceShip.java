package com.art.apifeature.model.transport;

import java.time.LocalDate;

public record SpaceShip(TransportType type,
                        String id,
                        Integer crewAmount,
                        LocalDate madeIn,
                        String madeBy) {
}
