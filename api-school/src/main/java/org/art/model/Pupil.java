package org.art.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Pupil {

    private static int id = 1;
    private final int idPupil;
    private String firstName;
    private String lastName;
    private Gender gender;
    private int clazz;
    private String postfixClazz;

    public Pupil(String firstName, String lastName, Gender gender, int clazz, String postfixClazz) {
        this.idPupil = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.clazz = clazz;
        this.postfixClazz = postfixClazz;
        id++;
    }
}
