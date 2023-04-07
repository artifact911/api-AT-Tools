package org.art.model;

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
public class City {

    private static int id = 1;
    private final int cityId = id;
    private String name;
    @Builder.Default
    private List<School> schools = new ArrayList<>();

    public City(String name, List<School> schools) {
        this.name = name;
        this.schools = schools;
        id++;
    }
}
