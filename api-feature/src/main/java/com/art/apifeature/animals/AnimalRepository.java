package com.art.apifeature.animals;

import com.art.apifeature.CrudFeatureRepository;
import com.art.apifeature.animals.dto.Animal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AnimalRepository implements CrudFeatureRepository<Integer, Animal> {

    private final AnimalStorage animalStorage;

    @Override
    public List<Animal> getAll() {
        return animalStorage.getZoo();
    }
}
