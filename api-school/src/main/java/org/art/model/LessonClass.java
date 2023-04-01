package org.art.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
public class LessonClass {

    private static int id = 1;
    private final int idLessonClass = id;

    @Builder.Default
    private String classFullName = "";
    private int clazz;
    @Builder.Default
    private String postfix = "";
    private Teacher mainTeacher;
    @Builder.Default
    private List<Pupil> pupils = new ArrayList<>();
    @Builder.Default
    private Double awgClassMark = 0.0;

    // TODO Зачем конструктор со всеми параметрами, но с этим не работает?
    public LessonClass(int clazz, String postfix, Teacher mainTeacher,
                       List<Pupil> pupils) {
        this.clazz = clazz;
        this.postfix = postfix;
        this.mainTeacher = mainTeacher;
        this.pupils = pupils;
        this.classFullName = createLessonClassFullName();
        this.awgClassMark = createAwgClassMark();
        id++;
    }

    public LessonClass(String classFullName, int clazz, String postfix, Teacher mainTeacher, List<Pupil> pupils, Double awgClassMark) {
        this.classFullName = classFullName;
        this.clazz = clazz;
        this.postfix = postfix;
        this.mainTeacher = mainTeacher;
        this.pupils = pupils;
        this.awgClassMark = awgClassMark;
        id++;
    }

    public Double createAwgClassMark() {
        assert pupils != null;
        return pupils.stream()
                .mapToDouble(Pupil::getAwgMark)
                .average().getAsDouble();
    }

    public String createLessonClassFullName() {
        return clazz + "-" + postfix;
    }
}
