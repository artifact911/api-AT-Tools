package org.art.school.school;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import org.art.school.lessonclass.LessonClassItem;
import org.art.school.teacher.TeacherItem;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SchoolItem {

    private Integer schoolId;
    private String name;
    private List<LessonClassItem> lessonClassList;
    private List<TeacherItem> teacherList;
}
