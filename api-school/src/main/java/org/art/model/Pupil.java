package org.art.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
public class Pupil {

    private static int id = 1;
    private final int idPupil = id;
    private final Double awgMark = createAwgMark();
    private int cityId;
    private int schoolId;
    private int lessonClassId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private int clazz;
    private String postfix;
    private String clazzFullName;
    private LocalDate birthdate;

    public Pupil(int cityId, int schoolId, int lessonClassId, String firstName, String lastName, Gender gender,
                 int clazz, String postfix, String clazzFullName, LocalDate birthdate) {
        this.cityId = cityId;
        this.schoolId = schoolId;
        this.lessonClassId = lessonClassId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.clazz = clazz;
        this.postfix = postfix;
        this.clazzFullName = clazzFullName;
        this.birthdate = birthdate;
        id++;
    }

    private Double createAwgMark() {
        AtomicInteger sum = new AtomicInteger();
        IntStream.range(1, 10).forEach(n -> {
            sum.addAndGet(new Random().nextInt(10) + 2);
        });
        return (double) sum.intValue() / 10;
    }
}
