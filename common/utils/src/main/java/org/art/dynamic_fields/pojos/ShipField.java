package org.art.dynamic_fields.pojos;

import lombok.Getter;
import org.art.dynamic_fields.ValueField;
import org.art.dynamic_fields.ValueFieldType;

public record ShipField(@Getter ValueFieldType type,
                        @Getter String id,
                        Integer crewAmount,
                        Boolean weapon,
                        String displacement,
                        String madeIn,
                        String madeBy) implements ValueField {

}
