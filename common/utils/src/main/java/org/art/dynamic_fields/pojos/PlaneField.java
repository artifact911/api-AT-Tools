package org.art.dynamic_fields.pojos;

import lombok.Getter;
import org.art.dynamic_fields.ValueField;
import org.art.dynamic_fields.ValueFieldType;

public record PlaneField(@Getter ValueFieldType type,
                         @Getter String id,
                         Integer passengerAmount,
                         String model,
                         String district,
                         String madeIn,
                         String madeBy) implements ValueField {

}
