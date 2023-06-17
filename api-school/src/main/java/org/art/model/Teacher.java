package org.art.model;

import lombok.*;
import org.art.model.schoolstaff.SchoolStaff;
import org.art.model.schoolstaff.StaffRole;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
//@AllArgsConstructor
public class Teacher extends SchoolStaff {

    private static int id = 1;
    private final int teacherId = id;
    private int lessonClassId;
    private String mainClass;
    private MainObject mainObject;

    @Builder(builderMethodName = "teacherBuilder")
    public Teacher(int cityId, int schoolId, int lessonClassId, StaffRole staffRole,
                   String firstName, String lastName, String mainClass,
                   MainObject mainObject, LocalDate birthdate) {

        super(id, cityId, schoolId, staffRole, firstName, lastName, birthdate);
        this.lessonClassId = lessonClassId;
        this.mainClass = mainClass;
        this.mainObject = mainObject;
        id++;
    }
}
