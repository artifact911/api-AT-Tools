package org.art.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LessonClass {

    private String classId;
    private int clazz;
    private String postfix;
    private Teacher mainTeacher;
    private List<Pupil> pupils;
    private Double awgClassMark;

    public Double createAwgClassMark() {
        assert pupils != null;
        return pupils.stream()
                     .mapToDouble(Pupil::getAwgMark)
                     .average().getAsDouble();
    }
}
