package org.art.school.school;

import lombok.Getter;
import org.art.school.lessonclass.LessonClassItem;
import org.art.school.teacher.TeacherItem;

import java.util.List;

@Getter
public class SchoolItem {

    private Integer schoolId;
    private String name;
    private List<LessonClassItem> lessonClassList;
    private List<TeacherItem> teacherList;
}
