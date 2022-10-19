package org.art.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pupil {

    private int id;
    private String firstName;
    private String lastName;
    private int clazz;
    private String postfixClazz;
}
