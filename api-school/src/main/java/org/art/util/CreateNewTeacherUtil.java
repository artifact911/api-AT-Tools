package org.art.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.art.model.MainObject;
import org.art.model.Teacher;

import static org.art.util.RandomGeneratorUtil.createClassFullName;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CreateNewTeacherUtil {

    public static Teacher createNewTeacher(String firstName, String lastName, int clazz, String postfix,
                                           int cityId, int schoolId, MainObject mainObject) {
        return Teacher.teacherBuilder()
                .firstName(firstName)
                .lastName(lastName)
                .mainClass(createClassFullName(clazz, postfix))
                .cityId(cityId)
                .schoolId(schoolId)
                .mainObject(mainObject)
                .build();
    }
}
