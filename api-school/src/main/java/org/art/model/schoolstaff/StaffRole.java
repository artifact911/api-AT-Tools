package org.art.model.schoolstaff;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StaffRole {

    DIRECTOR("Директор"),
    HEAD_TEACHER("Завуч"),
    SUPPLY_MANAGER("Завхоз"),
    DOCTOR("Врач"),
    FIREMAN("Пожарник"),
    POLICEMAN("Участковый инспектор милиции"),
    PSYCHOLOGIST("Психолог"),
    TEACHER("Преподаватель"),
    PUPIL("Ученик"),
    UNDEFINED("Неопределен");

    private final String rusStaffName;
}
