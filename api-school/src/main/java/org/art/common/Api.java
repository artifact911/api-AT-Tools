package org.art.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Api {

    CITY_API("city-api"),
    SCHOOL_API("school-api"),
    LESSON_CLASS_API("lesson-class-api"),
    TEACHER_API("teacher-api"),
    PUPIL_API("pupil-api"),
    HEADER_API("header-api");

    private final String name;
}
