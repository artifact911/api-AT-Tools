package org.art.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.art.dto.PupilReqBody;
import org.art.model.Gender;
import org.art.model.Pupil;

import java.util.Arrays;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CreateNewPupilUtil {

    public static Pupil getNewPupil(PupilReqBody pupilReqBody) {
        return Pupil.builder()
                .firstName(pupilReqBody.getFirstName())
                .lastName(pupilReqBody.getLastName())
                .gender(validateGender(pupilReqBody.getGender()))
                .clazz(pupilReqBody.getClazz() + "-" + pupilReqBody.getPostfix())
                .build();
    }

    private static Gender validateGender(String gender) {
       return Arrays.stream(Gender.values()).filter(g -> gender.equals(g.name()))
               .findFirst()
               .orElse(Gender.UNDEFINED);
    }
}
