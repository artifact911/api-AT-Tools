package org.art.dto.city;

import lombok.Getter;
import org.art.model.School;

import java.util.List;

@Getter
public class CreateUpdateCityReqBody {

    private String name;
    private List<School> schools;
}
