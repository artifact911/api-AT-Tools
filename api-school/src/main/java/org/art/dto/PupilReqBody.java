package org.art.dto;

import lombok.Getter;

@Getter
public class PupilReqBody {

    private String firstName;
    private String lastName;
    private String gender;
    private int clazz;
    private String postfix;
    private int cityId;
    private int schoolId;
    private int lessonClassId;
}
