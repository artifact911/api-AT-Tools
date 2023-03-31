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
@AllArgsConstructor
public class LessonClass {

    @Builder.Default
    private String classId = "";
    private int clazz;
    @Builder.Default
    private String postfix = "";
    private Teacher mainTeacher;
    @Builder.Default
    private List<Pupil> pupils = new ArrayList<>();
    @Builder.Default
    private Double awgClassMark = 0.0;

    public Double createAwgClassMark() {
        assert pupils != null;
        return pupils.stream()
                     .mapToDouble(Pupil::getAwgMark)
                     .average().getAsDouble();
    }
}
