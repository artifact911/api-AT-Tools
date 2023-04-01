package org.art.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
public class School {

    private static int id = 1;
    private final int schoolId = id;
    private int cityId;
    private String name;
    private List<LessonClass> lessonClassList;
    private List<Teacher> teacherList;

    public School(int cityId, String name, List<LessonClass> lessonClassList, List<Teacher> teacherList) {
        this.cityId = cityId;
        this.name = name;
        this.lessonClassList = lessonClassList;
        this.teacherList = teacherList;
        id++;
    }
}
