package org.art.dynamic_fields;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.art.dynamic_fields.pojos.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        // Тут указываем во что пасить, если тип пришел неизвестный. В данной реализации скастуется в null
        // Закооментил, чтоб падало при парсинге, если тип поля неизвестен
        //        defaultImpl = Void.class,
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BusField.class, name = "BUS"),
        @JsonSubTypes.Type(value = CarField.class, name = "CAR"),
        @JsonSubTypes.Type(value = PlaneField.class, name = "PLANE"),
        @JsonSubTypes.Type(value = ShipField.class, name = "SHIP"),
        @JsonSubTypes.Type(value = SpaceShipField.class, name = "SPACE_SHIP")
})
public interface ValueField {

    ValueFieldType getType();
    String getId();

    static ValueField findValueFieldByPredicate(List<ValueField> fields, Predicate<ValueField> predicate) {
        return fields.stream()
                .filter(predicate)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("There is no field with predicate"));
    }
}
