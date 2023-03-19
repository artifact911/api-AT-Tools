package org.art.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MainObject {

    MATH ("Математика"),
    HISTORY("История"),
    PHYSICS("Физика"),
    CHEMISTRY("Химия"),
    ENGLISH("Английский язык"),
    RUSSIAN("Русский язык"),
    BIOLOGY("Биология"),
    GEOGRAPHY("География"),
    LITERATURE("Литература"),
    SPORT("ФизВоспитание"),
    ASTRONOMY("Астрономия");

    private final String rusName;
}
