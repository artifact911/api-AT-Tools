package org.art.dao;

import org.art.dto.PupilReqBody;
import org.art.model.LessonClass;
import org.art.model.Pupil;
import org.art.model.School;
import org.art.model.Teacher;
import org.art.storage.EntityStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.art.util.CreateNewPupilUtil.getNewPupil;
import static org.art.util.RandomGeneratorUtil.getTeacher;

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

                Teacher teacher = getTeacher(pupilReqBody.getClazz(), pupilReqBody.getPostfix());

                LessonClass lessonClassNew = LessonClass.builder()
                        .clazz(pupilReqBody.getClazz())
                        .postfix(pupilReqBody.getPostfix())
                        .classId(pupilReqBody.getClazz() + "-" + pupilReqBody.getPostfix())
                        .pupils(list)
                        .mainTeacher(teacher)
                        .build();

                lessonClassNew.setAwgClassMark(lessonClassNew.createAwgClassMark());
                school.get().getLessonClassList().add(lessonClassNew);
                school.get().getTeacherList().add(teacher);
            }
            return true;
        }
        return false;
    }
}
