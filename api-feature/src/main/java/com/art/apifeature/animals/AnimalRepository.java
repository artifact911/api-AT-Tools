package com.art.apifeature.animals;

import com.art.apifeature.CrudFeatureRepository;
import com.art.apifeature.animals.entity.Animal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AnimalRepository implements CrudFeatureRepository<Long, Animal> {

    private final AnimalStorage animalStorage;

    @Override
    public List<Animal> getAll() {
        return animalStorage.getZoo();
    }

    @Override
    public boolean create(Animal animal) {
        return animalStorage.addAnimal(animal);
    }
}
