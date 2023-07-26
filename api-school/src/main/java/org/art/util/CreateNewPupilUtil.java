package org.art.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.art.dto.pupil.PatchPupilReqBody;
import org.art.dto.pupil.CreatePupilReqBody;
import org.art.model.Gender;
import org.art.model.LessonClass;
import org.art.model.Pupil;

import java.util.Arrays;

import static java.util.Objects.nonNull;
import static org.art.util.RandomGeneratorUtil.createClassFullName;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CreateNewPupilUtil {

    public static Pupil addNewPupil(PatchPupilReqBody pupilReqBody) {
        return Pupil.pupilBuilder()
                .firstName(pupilReqBody.getFirstName())
                .lastName(pupilReqBody.getLastName())
                .gender(validateGender(pupilReqBody.getGender()))
                .clazz(pupilReqBody.getClazz())
                .postfix(pupilReqBody.getPostfix())
                .clazzFullName(pupilReqBody.getClazz() + "-" + pupilReqBody.getPostfix())
                .build();
    }

    public static Pupil createNewPupil(CreatePupilReqBody body, @NonNull LessonClass lessonClass) {
        Pupil.PupilBuilder builder = Pupil.pupilBuilder();

        if (nonNull(body.getLessonClassId())) builder.lessonClassId(body.getLessonClassId());
        if (nonNull(body.getFirstName())) builder.firstName(body.getFirstName());
        if (nonNull(body.getLastName())) builder.lastName(body.getLastName());

        if (nonNull(body.getGender())) {
            builder.gender(validateGender(body.getGender()));
        } else {
            builder.gender(Gender.UNDEFINED);
        }

        builder.cityId(lessonClass.getCityId())
                .schoolId(lessonClass.getSchoolId())
                .clazz(lessonClass.getClazz())
                .postfix(lessonClass.getPostfix())
                .clazzFullName(createClassFullName(lessonClass.getClazz(), lessonClass.getPostfix()));

        return builder.build();
    }


    public static Gender validateGender(String gender) {
        return Arrays.stream(Gender.values()).filter(g -> gender.equals(g.name()))
                .findFirst()
                .orElse(Gender.UNDEFINED);
    }
}
