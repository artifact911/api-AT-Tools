package org.art.school.teacher;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MainObject {

    ART ("Искусство"),
    ASTRONOMY("Астрономия"),
    BELORUSSIAN("Белорусский язык"),
    BY_LITERATURE("Белорусская литература"),
    BIOLOGY("Биология"),
    CHEMISTRY("Химия"),
    COMPUTER_SCIENCE("Информатика"),
    ENGLISH("Английский язык"),
    GEOGRAPHY("География"),
    HISTORY("История"),
    MATH ("Математика"),
    MUSIC("Музыка"),
    PAINTING("Рисование"),
    PHYSICS("Физика"),
    RUS_LITERATURE("Русская литература"),
    RUSSIAN("Русский язык"),
    SPORT("ФизВоспитание"),
    TECHNICAL_DRAWING("Черчение");

    private final String rusName;
}
