package org.art.school.teacher;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeacherItem {

    private Integer teacherId;
    private String firstName;
    private String lastName;
    private String mainClass;
    private MainObject mainObject;
}
