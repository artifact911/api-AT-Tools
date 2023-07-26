package org.art.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.art.model.schoolstaff.SchoolStaff;
import org.art.model.schoolstaff.StaffRole;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Getter
@Setter
@ToString
@Schema(name = "pupil_model", description = "Pupil model", implementation = Pupil.class)
public class Pupil extends SchoolStaff {

    @Schema(accessMode = Schema.AccessMode.READ_WRITE, description = "Pupils awgMark", example = "6.3")
    private final Double awgMark = createAwgMark();

    @Schema(accessMode = Schema.AccessMode.READ_WRITE, description = "LessonClass Id", example = "1")
    private int lessonClassId;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Pupil's gender", example = "MALE")
    private Gender gender;

    @Schema(accessMode = Schema.AccessMode.READ_WRITE, description = "Class number", example = "1")
    private int clazz;

    @Schema(accessMode = Schema.AccessMode.READ_WRITE, description = "Class postfix", example = "A")
    private String postfix;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Class full name", example = "1-A")
    private String clazzFullName;

    @Builder(builderMethodName = "pupilBuilder")
    public Pupil(int cityId, int schoolId, int lessonClassId, StaffRole staffRole, String firstName, String lastName, Gender gender,
                 int clazz, String postfix, String clazzFullName, LocalDate birthdate) {

        super(cityId, schoolId, staffRole.getRusStaffName(), firstName, lastName, birthdate);
        this.lessonClassId = lessonClassId;
        this.gender = gender;
        this.clazz = clazz;
        this.postfix = postfix;
        this.clazzFullName = clazzFullName;
    }

    private Double createAwgMark() {
        AtomicInteger sum = new AtomicInteger();
        IntStream.range(1, 10).forEach(n -> {
            sum.addAndGet(new Random().nextInt(10) + 2);
        });
        return (double) sum.intValue() / 10;
    }
}
