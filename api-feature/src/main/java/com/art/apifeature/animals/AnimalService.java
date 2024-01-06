package com.art.apifeature.animals;

import com.art.apifeature.CrudFeatureService;
import com.art.apifeature.animals.dto.Animal;
import com.art.apifeature.animals.dto.AnimalType;
import com.art.apifeature.animals.exception.ZooException;
import com.art.apifeature.animals.util.AnimalsGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

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
        AnimalType animalType;
        try {
            animalType = AnimalType.valueOf(type.toUpperCase());
        } catch (RuntimeException e) {
            throw new ZooException(String.format("Type %s is not present", type));
        }

        return getAll().stream()
                .filter(animal -> animal.type().equals(animalType))
                .toList();
    }

    @Override
    public Animal create() {
        Animal animal = AnimalsGenerator.createAnimal();
        if (!animalRepository.create(animal)) {
            throw new ZooException("Failed to create");
        }
        return animal;
    }
}
