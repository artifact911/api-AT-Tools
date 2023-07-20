package org.art.dynamic_fields.pojos;

import lombok.Getter;
import org.art.dynamic_fields.ValueField;
import org.art.dynamic_fields.ValueFieldType;

import java.time.LocalDate;

public record SpaceShipField(@Getter ValueFieldType type,
                             @Getter String id,
                             Integer crewAmount,
                             LocalDate madeIn,
                             String madeBy) implements ValueField {

}
