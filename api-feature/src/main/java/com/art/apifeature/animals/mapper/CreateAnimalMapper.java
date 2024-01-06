package com.art.apifeature.animals.mapper;

import com.art.apifeature.animals.dto.CreateAnimalReqBody;
import com.art.apifeature.animals.entity.Animal;
import com.art.apifeature.animals.entity.AnimalType;
import com.art.apifeature.animals.exception.ZooException;
import com.art.apifeature.animals.util.AnimalsGenerator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CreateAnimalMapper {

    public static Animal map(CreateAnimalReqBody reqBody) {
        return AnimalsGenerator.createAnimal(
                isAnimalTypePresent(reqBody.getType()),
                reqBody.getAge(),
                reqBody.getName());
    }

    public static AnimalType isAnimalTypePresent(String type) {
        AnimalType animalType;
        try {
            animalType = AnimalType.valueOf(type.toUpperCase());
        } catch (RuntimeException e) {
            throw new ZooException(String.format("Type %s is not present", type));
        }

        return animalType;
    }
}
