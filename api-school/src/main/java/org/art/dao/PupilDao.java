package org.art.dao;

import org.art.dto.PupilReqBody;
import org.art.model.LessonClass;
import org.art.model.Pupil;
import org.art.model.School;
import org.art.model.Teacher;
import org.art.storage.EntityStorage;
import org.art.util.CreateNewLessonClassUtil;
import org.art.util.CreateNewPupilUtil;
import org.art.util.RandomGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

import static org.art.util.CreateNewLessonClassUtil.createNewLessonClass;
import static org.art.util.CreateNewPupilUtil.getNewPupil;
import static org.art.util.RandomGeneratorUtil.createRandomTeacher;
import static org.art.util.ReflectionApiUtil.*;

@Component
public class PupilDao implements Dao<Integer, Pupil> {

    private final SchoolDao schoolDao;
    private final LessonClassDao lessonClassDao;

    @Autowired
    public PupilDao(SchoolDao schoolDao, LessonClassDao lessonClassDao) {
        this.schoolDao = schoolDao;
        this.lessonClassDao = lessonClassDao;
    }

    @Override
    public List<Pupil> getAll() {
        return EntityStorage.getCities().stream()
                .flatMap(city -> city.getSchools().stream())
                .flatMap(school -> school.getLessonClassList().stream())
                .flatMap(lessonClass -> lessonClass.getPupils().stream())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Pupil> getById(Integer id) {
        return getAll().stream()
                .filter(pupil -> id.equals(pupil.getIdPupil()))
                .findFirst();
    }

    public boolean delPupilById(Integer id) {
        Optional<Pupil> foundUser = getById(id);

        if (foundUser.isPresent()) {
            EntityStorage.getCities().stream()
                    .flatMap(city -> city.getSchools().stream())
                    .flatMap(school -> school.getLessonClassList().stream())
                    .map(LessonClass::getPupils)
                    .forEach(lp -> lp.remove(foundUser.get()));
            return true;
        }
        return false;
    }

    public boolean addPupil(Integer schoolId, PupilReqBody pupilReqBody) {
        Optional<School> school = schoolDao.getById(schoolId);
        if (school.isPresent()) {
            Optional<LessonClass> lessonClass = school.get().getLessonClassList().stream()
                    .filter(lc -> pupilReqBody.getClazz() == (lc.getClazz())
                            && pupilReqBody.getPostfix().equals(lc.getPostfix()))
                    .findFirst();
            if (lessonClass.isPresent()) {
                lessonClass.get().getPupils().add(getNewPupil(pupilReqBody));
            } else {
                List<Pupil> list = new ArrayList<>();
                list.add(getNewPupil(pupilReqBody));

                Teacher teacher = createRandomTeacher(pupilReqBody.getClazz(), pupilReqBody.getPostfix());

                LessonClass newLessonClass = createNewLessonClass(list, teacher, pupilReqBody.getClazz(), pupilReqBody.getPostfix());

                school.get().getLessonClassList().add(newLessonClass);
                school.get().getTeacherList().add(teacher);
            }
            return true;
        }
        return false;
    }

    public boolean patchPupil(Integer pupilId, PupilReqBody pupilReqBody) {
        Optional<Pupil> maybePatchedPupil = getById(pupilId);

        if (maybePatchedPupil.isPresent()) {
            Pupil patchedPupil = maybePatchedPupil.get();
            Map<String, Object> reqFields = new HashMap<>();
            Arrays.stream(pupilReqBody.getClass().getDeclaredFields())
                    .peek(f -> f.setAccessible(true))
                    .filter(field -> getValueByField(field, pupilReqBody) != null)
                    .forEach(f -> reqFields.put(f.getName(), getValueByField(f, pupilReqBody)));
// TODO Хардкод поля. Может маппер можно?
            reqFields.keySet().forEach(k -> {
                Field fieldByFieldName = getFieldByFieldName(patchedPupil, k);
                fieldByFieldName.setAccessible(true);
                if (k.equals("gender")) {
                    reqFields.put("gender", CreateNewPupilUtil.validateGender((String) reqFields.get(k)));
                }
                setNewValueToField(fieldByFieldName, patchedPupil, reqFields.get(k));
                patchedPupil.setClazzFullName(RandomGeneratorUtil
                        .createClassFullName(patchedPupil.getClazz(), patchedPupil.getPostfix()));
            });
            return true;
        }
        return false;
    }


    public boolean movePupilToLessonClass(Integer schoolId, Integer pupilId) {
        Optional<School> maybeSchool = schoolDao.getById(schoolId);
        Optional<Pupil> maybePupil = getById(pupilId);
        if (maybeSchool.isPresent() && maybePupil.isPresent()) {
            School school = maybeSchool.get();
            Pupil pupil = maybePupil.get();

            Optional<LessonClass> maybeClass = school.getLessonClassList().stream()
                    .filter(lc -> pupil.getClazzFullName().equals(lc.getClassFullName()))
                    .findFirst();
            if (maybeClass.isPresent()) {
                LessonClass expectedClass = maybeClass.get();
                expectedClass.getPupils().add(pupil);
            } else {
                List<Pupil> list = new ArrayList<>();
                list.add(pupil);

                Teacher teacher = createRandomTeacher(pupil.getClazz(), pupil.getPostfix());

                LessonClass newLessonClass = createNewLessonClass(list, teacher, pupil.getClazz(), pupil.getPostfix());

                school.getLessonClassList().add(newLessonClass);
                school.getTeacherList().add(teacher);
            }
            return true;
        }
        return false;
    }
}
