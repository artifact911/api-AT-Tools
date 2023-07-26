package org.art.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.art.model.schoolstaff.SchoolStaff;
import org.art.model.schoolstaff.StaffRole;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Schema(name = "teacher_model", description = "Teacher model", implementation = Teacher.class)
public class Teacher extends SchoolStaff {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Curator of the class Id", example = "12")
    private int lessonClassId;

    @Schema(accessMode = Schema.AccessMode.READ_WRITE, description = "Curator of the class number and postfix", example = "1-D")
    private String mainClass;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Teacher's main object", example = "ART")
    private MainObject mainObject;

    @Builder(builderMethodName = "teacherBuilder")
    public Teacher(int cityId, int schoolId, int lessonClassId, StaffRole staffRole,
                   String firstName, String lastName, String mainClass,
                   MainObject mainObject, LocalDate birthdate) {

        super(cityId, schoolId, staffRole.getRusStaffName(), firstName, lastName, birthdate);
        this.lessonClassId = lessonClassId;
        this.mainClass = mainClass;
        this.mainObject = mainObject;
    }
}
