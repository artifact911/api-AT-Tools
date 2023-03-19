package org.art.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Teacher {

    private String firstName;
    private String lastName;
    private String mainClass;
    private MainObject mainObject;
}
