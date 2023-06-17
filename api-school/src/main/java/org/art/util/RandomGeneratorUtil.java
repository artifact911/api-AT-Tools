package org.art.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.art.model.*;
import org.art.model.schoolstaff.SchoolStaff;
import org.art.model.schoolstaff.StaffRole;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
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


    public static List<City> createRandomCitiesList(int amount) {
        List<City> cities = new ArrayList<>();
        IntStream.range(0, amount).forEach(n -> cities.add(createRandomCity(n)));

        return cities;
    }

    private static City createRandomCity(int nameIndex) {
        City city = City.builder()
                .name(CITY_NAME_LIST.get(nameIndex))
                .build();
        city.setSchools(createRandomSchoolsList(city.getCityId()));
        return city;

    }

    private static List<School> createRandomSchoolsList(int cityId) {
        List<School> list = new ArrayList<>();
        IntStream.range(0, RN.nextInt(5)).forEach(n -> list.add(createRandomSchool(cityId)));

        return list;
    }

    private static School createRandomSchool(int cityId) {
        School school = School.builder()
                .name(SCHOOL_NAME_LIST.get(RN.nextInt(SCHOOL_NAME_LIST.size() - 1)))
                .build();

        school.setCityId(cityId);
        school.setLessonClassList(createRandomLessonClassList(cityId, school.getSchoolId()));
        school.setTeacherList(createRandomTeacherList(school.getLessonClassList()));
        school.setStaffs(createStaffList(cityId, school.getSchoolId()));

        return school;
    }

    private static List<Teacher> createRandomTeacherList(List<LessonClass> classList) {
        return classList.stream()
                .map(LessonClass::getMainTeacher)
                .collect(Collectors.toList());
    }

    private static List<LessonClass> createRandomLessonClassList(int cityId, int schoolId) {
        List<LessonClass> list = new ArrayList<>();
        IntStream.range(1, 12).forEach(n -> {
            IntStream.range(1, RN.nextInt(4) + 1)
                    .forEach(p -> list.add(createRandomLessonClass(n, POSTFIX_CLAZZ_LIST.get(p),
                            cityId, schoolId)));
        });
        return list;
    }

    private static LessonClass createRandomLessonClass(int clazz, String postfix,
                                                       int cityId, int schoolId) {
        LessonClass lessonClass = LessonClass.builder()
                .classFullName(createClassFullName(clazz, postfix))
                .clazz(clazz)
                .postfix(postfix)
                .cityId(cityId)
                .schoolId(schoolId)
                .build();

        lessonClass.setPupils(createRandomPupilList(clazz, postfix, cityId, schoolId, lessonClass.getIdLessonClass()));
        lessonClass.setMainTeacher(createRandomTeacher(clazz, postfix, cityId, schoolId, lessonClass.getIdLessonClass()));
        lessonClass.setAwgClassMark(lessonClass.createAwgClassMark());

        return lessonClass;
    }

    public static Teacher createRandomTeacher(int clazz, String postfix, int cityId, int schoolId, int lessonClassId) {
        return Teacher.teacherBuilder()
                .firstName(FIRST_NAME_LIST.get(RN.nextInt(FIRST_NAME_LIST.size() - 1)))
                .lastName(LAST_NAME_LIST.get(RN.nextInt(LAST_NAME_LIST.size() - 1)))
                .mainClass(createClassFullName(clazz, postfix))
                .cityId(cityId)
                .schoolId(schoolId)
                .lessonClassId(lessonClassId)
                .mainObject(MainObject.values()[RN.nextInt(MainObject.values().length)])
                .birthdate(createStaffBirthday())
                .staffRole(StaffRole.TEACHER)
                .build();
    }

    private static List<Pupil> createRandomPupilList(int clazz, String postfix, int cityId,
                                                     int schoolId, int lessonClassId) {
        List<Pupil> list = new ArrayList<>();
        IntStream.range(0, 15).forEach(n -> list.add(createRandomPupil(clazz, postfix, cityId, schoolId, lessonClassId)));
        return list;
    }

    private static Pupil createRandomPupil(int clazz, String postfix, int cityId, int schoolId, int lessonClassId) {
        return Pupil.pupilBuilder()
                .firstName(FIRST_NAME_LIST.get(RN.nextInt(FIRST_NAME_LIST.size() - 1)))
                .lastName(LAST_NAME_LIST.get(RN.nextInt(LAST_NAME_LIST.size() - 1)))
                .clazz(clazz)
                .postfix(postfix)
                .clazzFullName(createClassFullName(clazz, postfix))
                .cityId(cityId)
                .schoolId(schoolId)
                .lessonClassId(lessonClassId)
                .gender(Gender.values()[RN.nextInt(2)])
                .birthdate(createPupilBirthdateByClazz(clazz))
                .staffRole(StaffRole.PUPIL)
                .build();
    }

    private static List<SchoolStaff> createStaffList(int cityId, int schoolId) {
        return Arrays.stream(StaffRole.values())
                .filter(sr -> !StaffRole.TEACHER.equals(sr)
                        && !StaffRole.PUPIL.equals(sr)
                        && !StaffRole.UNDEFINED.equals(sr))
                .map(r -> createStaffByType(cityId, schoolId, r))
                .toList();
    }

    private static SchoolStaff createStaffByType(int cityId, int schoolId, StaffRole staffRole) {
        SchoolStaff staff = SchoolStaff.builder()
                .id(SchoolStaff.staffIdIncrement)
                .staffRole(staffRole)
                .birthdate(createStaffBirthday())
                .cityId(cityId)
                .schoolId(schoolId)
                .firstName(FIRST_NAME_LIST.get(RN.nextInt(FIRST_NAME_LIST.size() - 1)))
                .lastName(LAST_NAME_LIST.get(RN.nextInt(LAST_NAME_LIST.size() - 1)))
                .build();

        SchoolStaff.staffIdIncrement++;

        return staff;
    }

    public static String createClassFullName(int clazz, String postfix) {
        return clazz + "-" + postfix;
    }


    private static LocalDate createPupilBirthdateByClazz(int clazz) {
        int randomYear = LocalDate.now().getYear() - (clazz + (6 + RN.nextInt(2)));
        Month randomMonth = Month.of(1 + RN.nextInt(11));
        int randomDay = 1 + RN.nextInt(randomMonth.maxLength() - 1);

        return LocalDate.of(randomYear, randomMonth, randomDay);
    }

    private static LocalDate createStaffBirthday() {
        int randomYear = LocalDate.now().getYear() - (19 + RN.nextInt(40));
        Month randomMonth = Month.of(1 + RN.nextInt(11));
        int randomDay = 1 + RN.nextInt(randomMonth.maxLength() - 1);

        return LocalDate.of(randomYear, randomMonth, randomDay);
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
