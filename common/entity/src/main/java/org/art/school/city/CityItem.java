package org.art.school.city;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import org.art.school.school.SchoolItem;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityItem {

    private int cityId;
    private String name;
    private List<SchoolItem> schools;
}
