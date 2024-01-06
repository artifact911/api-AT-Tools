package com.art.apifeature.animals;

import com.art.apifeature.CrudFeatureService;
import com.art.apifeature.animals.dto.CreateAnimalReqBody;
import com.art.apifeature.animals.entity.Animal;
import com.art.apifeature.animals.entity.AnimalType;
import com.art.apifeature.animals.exception.ZooException;
import com.art.apifeature.animals.mapper.CreateAnimalMapper;
import com.art.apifeature.animals.util.AnimalsGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.art.apifeature.animals.mapper.CreateAnimalMapper.isAnimalTypePresent;

@Component
@RequiredArgsConstructor
public class AnimalService implements CrudFeatureService<Long, Animal> {

    private final AnimalRepository animalRepository;

    @Override
    public List<Animal> getAll() {
        return animalRepository.getAll();
    }

    @Override
    public Animal findById(Long id) {
        return getAll().stream()
                .filter(animal -> id.equals(animal.id()))
                .findFirst()
                .orElseThrow(() -> new ZooException(String.format("Animal with id %s not found", id)));
    }

    public List<Animal> findByType(String type) {
        return getAll().stream()
                .filter(animal -> animal.type().equals(isAnimalTypePresent(type)))
                .toList();
    }

    @Override
    public Animal create() {
        return isCreateAnimalSuccess(AnimalsGenerator.createAnimal());
    }

    public Animal create(String type) {
        AnimalType animalType = isAnimalTypePresent(type);
        return isCreateAnimalSuccess(AnimalsGenerator.createAnimal(animalType));
    }

    public Animal create(CreateAnimalReqBody reqBody) {
        return isCreateAnimalSuccess(CreateAnimalMapper.map(reqBody));
    }

    private Animal isCreateAnimalSuccess(Animal animal) {
        if (!animalRepository.create(animal)) {
            throw new ZooException("Failed to create");
        }
        return animal;
    }
}
