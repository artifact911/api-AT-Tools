package org.art.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class City {

    private static int id = 1;
    private int cityId;
    private String name;
    private List<School> schools;

    public City(String name, List<School> schools) {
        this.name = name;
        this.schools = schools;
        this.cityId = id;
        id++;
    }
}
