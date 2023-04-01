package org.art.model;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
public class Teacher {

    private static int id = 1;
    private final int teacherId = id;
    private int cityId;
    private int schoolId;
    private int lessonClassId;
    private String firstName;
    private String lastName;
    private String mainClass;
    private MainObject mainObject;

    public Teacher(int cityId, int schoolId, int lessonClassId, String firstName, String lastName, String mainClass, MainObject mainObject) {
        this.cityId = cityId;
        this.schoolId = schoolId;
        this.lessonClassId = lessonClassId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mainClass = mainClass;
        this.mainObject = mainObject;
        id++;
    }
}
