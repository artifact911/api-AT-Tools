package org.art.model.schoolstaff;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "school_staff_model", description = "SchoolStaff parent model", implementation = SchoolStaff.class)
public class SchoolStaff {

    public static int staffIdIncrement = 1;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "SchoolStaff Id", example = "123")
    private int staffId;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "City Id", example = "1")
    private int cityId;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "School Id", example = "2")
    private int schoolId;

    @Schema(accessMode = Schema.AccessMode.READ_WRITE, description = "Staff Role", example = "Врач")
    private String staffRole;

    @Schema(accessMode = Schema.AccessMode.READ_WRITE, description = "Staff first name", example = "Илья")
    private String firstName;
    @Schema(accessMode = Schema.AccessMode.READ_WRITE, description = "Staff last name", example = "Муромец")
    private String lastName;

    @Schema(accessMode = Schema.AccessMode.READ_WRITE, description = "Staff birthdate", example = "1986-04-06")
    private LocalDate birthdate;

    public SchoolStaff(int cityId, int schoolId,
                       String staffRole, String firstName, String lastName,
                       LocalDate birthdate) {
        this.staffId = staffIdIncrement;
        this.cityId = cityId;
        this.schoolId = schoolId;
        this.staffRole = staffRole;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        staffIdIncrement++;
    }
}
