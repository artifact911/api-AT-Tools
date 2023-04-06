package org.art.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
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
