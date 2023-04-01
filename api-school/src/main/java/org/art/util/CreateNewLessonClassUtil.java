package org.art.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.art.model.LessonClass;
import org.art.model.Pupil;
import org.art.model.Teacher;

import java.util.List;

import static org.art.util.RandomGeneratorUtil.createClassFullName;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CreateNewLessonClassUtil {

    public static LessonClass createNewLessonClass(List<Pupil> pupils, Teacher teacher, int clazz, String postfix) {
        LessonClass lessonClass = LessonClass.builder()
                .clazz(clazz)
                .postfix(postfix)
                .pupils(pupils)
                .mainTeacher(teacher)
                .build();

        lessonClass.setClassFullName(createClassFullName(clazz, postfix));
        lessonClass.setAwgClassMark(lessonClass.createAwgClassMark());

        return lessonClass;
    }
}
