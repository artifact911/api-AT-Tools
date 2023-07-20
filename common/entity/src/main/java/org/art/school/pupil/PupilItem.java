package org.art.school.pupil;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PupilItem {

    private Integer idPupil;
    private Double awgMark;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String clazz;
}
