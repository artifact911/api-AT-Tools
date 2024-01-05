package com.art.apifeature.animals;

import com.art.apifeature.animals.dto.Animal;
import com.art.apifeature.animals.util.AnimalsGenerator;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AnimalStorage {

    private List<Animal> zoo;

    @PostConstruct
    private void initZooList() {
        zoo = AnimalsGenerator.generateRandomAnimalList(15);
    }

    public List<Animal> getZoo() {
        return new ArrayList<>(zoo);
    }

    public boolean addAnimal(Animal animal) {
        return zoo.add(animal);
    }

    public boolean deleteAnimal(Animal animal) {
        return zoo.remove(animal);
    }
}
