package com.art.apifeature.animals.dto;

public record Animal(long id,
                     AnimalType type,
                     int age,
                     String name) {
}
