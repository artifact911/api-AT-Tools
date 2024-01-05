package com.art.apifeature.spaceport.transport;

import java.time.LocalDate;

public record SpaceShip(TransportType type,
                        String id,
                        Integer crewAmount,
                        LocalDate madeIn,
                        String madeBy) {
}
