package org.art.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
public class Teacher {

    private static int id = 1;

    private final int teacherId = id;
    private String firstName;
    private String lastName;
    private String mainClass;
    private MainObject mainObject;

    public Teacher(String firstName, String lastName, String mainClass, MainObject mainObject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mainClass = mainClass;
        this.mainObject = mainObject;
        id++;
    }
}
