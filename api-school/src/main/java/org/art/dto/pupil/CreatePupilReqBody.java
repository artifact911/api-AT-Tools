package org.art.dto.pupil;

import lombok.Getter;

@Getter
public class CreatePupilReqBody {

    private Integer lessonClassId;
    private String firstName;
    private String lastName;
    private String gender;
}
