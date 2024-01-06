package com.art.apifeature.animals.entity;

public record Animal(long id,
                     AnimalType type,
                     int age,
                     String name) {
}
