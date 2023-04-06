package org.art.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.art.dto.city.CreateCityReqBody;
import org.art.model.City;

import static java.util.Objects.nonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CreateNewCityUtil {

    public static City createNewCity(CreateCityReqBody body) {
        City.CityBuilder builder = City.builder();

        if (nonNull(body.getName())) builder.name(body.getName());
        if (nonNull(body.getSchools())) builder.schools(body.getSchools());

        return builder.build();
    }
}
