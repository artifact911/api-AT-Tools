package org.art.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.art.model.City;
import org.art.model.Gender;
import org.art.model.LessonClass;
import org.art.model.MainObject;
import org.art.model.Pupil;
import org.art.model.School;
import org.art.model.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RandomGeneratorUtil {

    private final static Random RN = new Random();
    private static final List<String> FIRST_NAME_LIST = initFirstNameList();
    private static final List<String> LAST_NAME_LIST = initLastNameList();
    private static final List<String> CITY_NAME_LIST = initCityNameList();
    private static final List<String> SCHOOL_NAME_LIST = initSchoolNameList();
    private static final List<String> POSTFIX_CLAZZ_LIST = List.of("A", "B", "C", "D", "E");


    public static List<City> getRandomCitiesList(int amount) {
        List<City> cities = new ArrayList<>();
        IntStream.range(0, amount).forEach(n -> cities.add(getCity(n)));

        return cities;
    }

    private static City getCity(int nameIndex) {
        return new City(CITY_NAME_LIST.get(nameIndex), getRandomSchoolsList());
    }

    private static List<School> getRandomSchoolsList() {
        List<School> list = new ArrayList<>();
        IntStream.range(0, RN.nextInt(5)).forEach(n -> list.add(getSchool()));

        return list;
    }

    private static School getSchool() {
        School school = School.builder()
                              .name(SCHOOL_NAME_LIST.get(RN.nextInt(SCHOOL_NAME_LIST.size() - 1)))
                              .lessonClassList(getRandomLessonClassList())
                              .build();

        school.setTeacherList(getTeacherList(school.getLessonClassList()));

        return school;
    }

    private static List<Teacher> getTeacherList(List<LessonClass> classList) {
        return classList.stream()
                        .map(LessonClass::getMainTeacher)
                        .collect(Collectors.toList());
    }

    private static List<LessonClass> getRandomLessonClassList() {
        List<LessonClass> list = new ArrayList<>();
        IntStream.range(1, 12).forEach(n -> {
            IntStream.range(1, RN.nextInt(4) + 1).forEach(p -> list.add(getLessonClass(n, POSTFIX_CLAZZ_LIST.get(p))));
        });
        return list;
    }

    private static LessonClass getLessonClass(int clazz, String postfix) {
        return LessonClass.builder()
                .classId(clazz + "-" + postfix)
                          .clazz(clazz)
                          .postfix(postfix)
                          .pupils(getRandomPupilList(clazz, postfix))
                          .mainTeacher(getTeacher(clazz, postfix))
                          .build();
    }

    private static Teacher getTeacher(int clazz, String postfix) {
        return Teacher.builder()
                      .firstName(FIRST_NAME_LIST.get(RN.nextInt(FIRST_NAME_LIST.size() - 1)))
                      .lastName(LAST_NAME_LIST.get(RN.nextInt(LAST_NAME_LIST.size() - 1)))
                      .mainClass(clazz + "-" + postfix)
                      .mainObject(MainObject.values()[RN.nextInt(MainObject.values().length)])
                      .build();
    }

    private static List<Pupil> getRandomPupilList(int clazz, String postfix) {
        List<Pupil> list = new ArrayList<>();
        IntStream.range(0, 15).forEach(n -> list.add(getPupil(clazz, postfix)));
        return list;
    }

    private static Pupil getPupil(int clazz, String postfix) {
        return Pupil.builder()
                    .firstName(FIRST_NAME_LIST.get(RN.nextInt(FIRST_NAME_LIST.size() - 1)))
                    .lastName(LAST_NAME_LIST.get(RN.nextInt(LAST_NAME_LIST.size() - 1)))
                    .clazz(clazz + "-" + postfix)
                    .gender(Gender.values()[RN.nextInt(2)])
                    .build();
    }


    private static List<String> initFirstNameList() {
        return List.of("ЕжВТумане",
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
                       "БабаЯга",
                       "Леший",
                       "Кикимора",
                       "Балда",
                       "ИтакСойдет",
                       "Кеша",
                       "ПочтальонПечкин",
                       "Буратино",
                       "ФрекенБок",
                       "ГоспожаБеладонна",
                       "Фунтик",
                       "Шапокляк",
                       "Шарик",
                       "Золушка",
                       "Рапунцель",
                       "Эйприл",
                       "Донателло",
                       "Микеланджело",
                       "Леонардо",
                       "Рафаэль",
                       "Сплинтер",
                       "Вий",
                       "ИванДурак");
    }

    private static List<String> initLastNameList() {
        return List.of("Абрамов",
                       "Агафонов",
                       "Анисимов",
                       "Антонов",
                       "Архипов",
                       "Афанасьев",
                       "Баранов",
                       "Белов",
                       "Блинов",
                       "Бобров",
                       "Быков",
                       "Виноградов",
                       "Вишняков",
                       "Власов",
                       "Волков",
                       "Воробьёв",
                       "Воронов",
                       "Галкин",
                       "Голубев",
                       "Горбачёв",
                       "Горшков",
                       "Гурьев",
                       "Гусев",
                       "Денисов",
                       "Дмитриев",
                       "Дьячков",
                       "Евдокимов",
                       "Елисеев",
                       "Емельянов",
                       "Ермаков",
                       "Ефимов",
                       "Ефремов",
                       "Жуков",
                       "Зайцев",
                       "Зуев",
                       "Иванов",
                       "Игнатов",
                       "Ильин",
                       "Исаков",
                       "Кабанов",
                       "Казаков",
                       "Калашников",
                       "Калинин",
                       "Князев",
                       "Козлов",
                       "Коновалов",
                       "Кононов",
                       "Копылов",
                       "Королёв",
                       "Котов",
                       "Крылов",
                       "Кузнецов",
                       "Кузьмин",
                       "Ларионов",
                       "Лихачёв",
                       "Лобанов",
                       "Макаров",
                       "Максимов",
                       "Мамонтов",
                       "Медведев",
                       "Миронов",
                       "Михайлов",
                       "Муравьёв",
                       "Мухин",
                       "Мышкин",
                       "Некрасов",
                       "Нестеров",
                       "Николаев",
                       "Носков",
                       "Носов",
                       "Одинцов",
                       "Орлов",
                       "Панфилов",
                       "Пахомов",
                       "Петухов",
                       "Попов",
                       "Прохоров",
                       "Рогов",
                       "Рожков",
                       "Рыбаков",
                       "Рябов",
                       "Савельев",
                       "Савин",
                       "Самсонов",
                       "Селезнёв",
                       "Селиверстов",
                       "Чен");
    }

    private static List<String> initCityNameList() {
        return List.of("ТриДевятоеЦарство",
                       "КанализацияЧерепашекНиндзя",
                       "НеЗнаюГде",
                       "Средиземье",
                       "ГотнамСити",
                       "СинееСинееМоре",
                       "ЦокотухаГрад",
                       "ГдеИванДуракЖивет",
                       "БолотоВодяного",
                       "НеПридумал",
                       "ВообщеНеПридумал",
                       "РодинаЦыган");
    }

    private static List<String> initSchoolNameList() {
        return List.of("им. ВанДамма",
                       "им. ДжонаРэмбо",
                       "им. Терминатора",
                       "им. Робокопа",
                       "им. СабЗиро",
                       "им. БрюсаЛи",
                       "им. ДжекаВоробья",
                       "им. СашиГрей",
                       "им. ЛысогоИзБраззерс",
                       "им. тов.Сухова",
                       "им. ЧакаНорриса",
                       "им. Чубаки",
                       "им. Бэтмена",
                       "им. Леонардо",
                       "им. Рафаэля",
                       "им. Микелянджело",
                       "им. Донателло");
    }
}
