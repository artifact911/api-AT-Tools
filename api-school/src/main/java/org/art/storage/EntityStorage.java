package org.art.storage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.art.model.City;
import org.art.util.RandomGeneratorUtil;

import java.util.List;

@NoArgsConstructor
public final class EntityStorage {

    @Getter
    private static List<City> cities;

    static
    {
      cities = RandomGeneratorUtil.getRandomCitiesList(12);
    }
}
