package com.art.apifeature.animals.util;

import com.art.apifeature.animals.dto.Animal;
import com.art.apifeature.animals.dto.AnimalType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AnimalsGenerator {

    private static long id = 1;
    private static final Random RN = new Random();

    public static List<Animal> generateRandomAnimalList(int amount) {
        List<Animal> list = new ArrayList<>();

        IntStream.range(0, amount).forEach(n -> list.add(createAnimal(
                getRandomAnimalType(),
                RN.nextInt(1, 15),
                getRandomName())));

        return list;
    }

    public static Animal createAnimal(AnimalType type, int age, String name) {
        Animal animal = new Animal(id, type, age, name);
        id++;
        return animal;
    }

    public static Animal createAnimal(AnimalType type) {
        Animal animal = new Animal(id, type, RN.nextInt(1, 15), getRandomName());
        id++;
        return animal;
    }

    private static AnimalType getRandomAnimalType() {
        return AnimalType.values()[RN.nextInt(0, AnimalType.values().length)];
    }

    private static String getRandomName() {
        List<String> names = List.of(
                "ЕжВТумане",
                "Карлсон",
                "Чебурашка",
                "ГенаКрокодил",
                "Трубадур",
                "КотМатроскин",
                "ВинниПух",
                "Пятачок",
                "ОсликИА",
                "Бонифаций",
                "Боба",
                "Теминатор",
                "Рембо",
                "Робокоп",
                "Бетмен",
                "СудьяДредд",
                "Буратино",
                "ФрекенБок",
                "Донателло",
                "Микеланджело",
                "Леонардо",
                "Рафаэль",
                "Сплинтер",
                "Вий",
                "ИванДурак");

        return names.get(RN.nextInt(0, names.size()));
    }
}
