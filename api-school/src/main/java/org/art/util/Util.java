package org.art.util;

import org.art.model.Pupil;
import org.art.model.School;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {

    private final static Random random = new Random();

    public static List<School> getRandomSchools(int amount) {
        List<School> list = new ArrayList<>();
        int flag = 0;

        while (flag <= amount) {
            list.add(new School(getPupils()));
            flag++;
        }
        return list;
    }

    public static List<Pupil> getPupils() {
        int a = 0;
        List<Pupil> pupils = new ArrayList<>();
        String[] firstName = {"Дормидонт", "Евлампий", "Проня", "Дульсинея", "Исаак", "Иосиф", "Брюс", "Асидора", "Клавдия"};
        String[] secondName = {"Ельцин", "Ли", "Алкаш", "Шварцнегер", "Рэмбо", "Непомню", "Шарик", "Зараза", "Боженька"};
        String[] clazz = {"A", "B", "C", "D"};

        while (a < 11) {
            pupils.add(new Pupil(firstName[random.nextInt(firstName.length)], secondName[random.nextInt(secondName.length)],
                                 random.nextInt(9), clazz[random.nextInt(clazz.length)]));
            a++;
        }
        return pupils;
    }
}
