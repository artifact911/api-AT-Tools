package org.art.school.city;

import lombok.Getter;
import org.art.school.school.SchoolItem;

import java.util.List;

@Getter
public class CityItem {

    private int cityId;
    private String name;
    private List<SchoolItem> schools;
}
