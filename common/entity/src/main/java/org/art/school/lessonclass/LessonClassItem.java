package org.art.school.lessonclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import org.art.school.pupil.PupilItem;
import org.art.school.teacher.TeacherItem;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LessonClassItem {

    private String classId;
    private Integer clazz;
    private String postfix;
    private TeacherItem mainTeacher;
    private List<PupilItem> pupils;
    private Double awgClassMark;
}
