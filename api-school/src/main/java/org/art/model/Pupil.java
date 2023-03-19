package org.art.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Pupil {

    private static int id = 1;
    private final int idPupil = id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String clazz;

    public Pupil(String firstName, String lastName, Gender gender, String clazz) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.clazz = clazz;
        id++;
    }
}
