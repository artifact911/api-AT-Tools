package org.art.dynamic_fields.pojos;

import lombok.Getter;
import org.art.dynamic_fields.ValueField;
import org.art.dynamic_fields.ValueFieldType;

public record SpaceShipField(@Getter ValueFieldType type,
                             @Getter String id,
                             Integer crewAmount,
                             String madeIn,
                             String madeBy) implements ValueField {

}
