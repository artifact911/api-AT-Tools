package org.art.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.art.model.LessonClass;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CreateNewLessonClassUtil {

    public static LessonClass getNewLessonClass() {
        return LessonClass.builder().build();
    }
}
