package org.art.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    private String firstName;
    private String lastName;
    private Gender gender;

    private int clazz;
    @Builder.Default
    private String postfix = "";
    private String clazzFullName;

    public Pupil(String firstName, String lastName, Gender gender, int clazz, String postfix, String clazzFullName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.clazz = clazz;
        this.postfix = postfix;
        this.clazzFullName = clazzFullName;
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
