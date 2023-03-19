package org.art.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
public class LessonClass {

    private int clazz;
    private String postfix;
    private Teacher mainTeacher;
    private List<Pupil> pupils;
    private Double awgClassMark;

    public LessonClass(int clazz, String postfix, Teacher mainTeacher, List<Pupil> pupils, Double awgClassMark) {
        this.clazz = clazz;
        this.postfix = postfix;
        this.mainTeacher = mainTeacher;
        this.pupils = pupils;
        this.awgClassMark = awgClassMark;
    }
}
