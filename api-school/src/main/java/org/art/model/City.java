package org.art.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
public class City {

    private static int id = 1;
    private final int cityId = id;
    private String name;
    private List<School> schools;

    public City(String name, List<School> schools) {
        this.name = name;
        this.schools = schools;
        id++;
    }
}
