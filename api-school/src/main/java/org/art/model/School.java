package org.art.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class School {

    private static int id = 1;

    private final int schoolId = id;
    private String name;

    private List<LessonClass> lessonClassList;
    private List<Teacher> teacherList;

    public School(String name, List<LessonClass> lessonClassList, List<Teacher> teacherList) {
        this.lessonClassList = lessonClassList;
        this.name = name;
        this.teacherList = teacherList;
        id++;
    }
}
