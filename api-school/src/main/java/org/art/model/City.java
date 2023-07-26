package org.art.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
@Schema(name = "city_model", description = "City model", implementation = City.class)
public class City {

    private static int id = 1;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "City Id", example = "1")
    private final int cityId = id;

    @Schema(accessMode = Schema.AccessMode.READ_WRITE, description = "The City name", example = "Родина Цыган")
    private String name;

    @Builder.Default
    @Schema(accessMode = Schema.AccessMode.READ_WRITE, description = "City schools list")
    private List<School> schools = new ArrayList<>();

    public City(String name, List<School> schools) {
        this.name = name;
        this.schools = schools;
        id++;
    }
}
