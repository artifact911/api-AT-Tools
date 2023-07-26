package org.art.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.art.model.schoolstaff.SchoolStaff;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Schema(name = "lesson_class_model", description = "LessonClass model", implementation = LessonClass.class)
public class LessonClass {

    private static int id = 1;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "LessonClass Id", example = "1")
    private final int idLessonClass = id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "City Id", example = "1")
    private int cityId;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "School Id", example = "1")
    private int schoolId;

    @Builder.Default
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Class full name", example = "1-A")
    private String classFullName = "";

    @Schema(accessMode = Schema.AccessMode.READ_WRITE, description = "Class number", example = "1")
    private int clazz;

    @Builder.Default
    @Schema(accessMode = Schema.AccessMode.READ_WRITE, description = "Class postfix", example = "A")
    private String postfix = "";

    @Schema(accessMode = Schema.AccessMode.READ_WRITE, description = "Class' main teacher")
    private Teacher mainTeacher;

    @Builder.Default
    @Schema(accessMode = Schema.AccessMode.READ_WRITE, description = "Class' pupils")
    private List<Pupil> pupils = new ArrayList<>();


    @Builder.Default
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Class' awg mark")
    private Double awgClassMark = 0.0;

    public LessonClass(int cityId, int schoolId, String classFullName, int clazz, String postfix, Teacher mainTeacher,
                       List<Pupil> pupils, Double awgClassMark) {
        this.cityId = cityId;
        this.schoolId = schoolId;
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
}
