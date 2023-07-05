package org.art.model.schoolstaff;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SchoolStaff {

    public static int staffIdIncrement = 1;
    private int id;
    private int cityId;
    private int schoolId;
    private String staffRole;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
}
