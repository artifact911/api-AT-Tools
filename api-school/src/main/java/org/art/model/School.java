package org.art.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.art.model.schoolstaff.SchoolStaff;

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
    private List<SchoolStaff> staffs;

    public School(int cityId, String name, List<LessonClass> lessonClassList,
                  List<Teacher> teacherList, List<SchoolStaff> staffs) {
        this.cityId = cityId;
        this.name = name;
        this.lessonClassList = lessonClassList;
        this.teacherList = teacherList;
        this.staffs = staffs;
        id++;
    }
}
