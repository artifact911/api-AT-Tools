package org.art.dao;

import org.art.model.Pupil;
import org.art.model.School;
import org.art.util.RandomGeneratorUtil;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SchoolDaoImpl implements SchoolDao {

    private static final List<School> schoolListDao = RandomGeneratorUtil.getRandomSchools(3);

    @Override
    public List<School> getSchools() {
        return schoolListDao;
    }

    @Override
    public School getSchool(int id) {
        return schoolListDao.stream()
                .filter(school -> school.getId() == id)
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    @Override
    public List<Pupil> addPupil(int idSchool, Pupil pupil) {
        getSchool(idSchool).getPupilList().add(pupil);
        return getSchool(idSchool).getPupilList();
    }

    @Override
    public List<Pupil> delPupil(int idSchool, int idPupil) {
        List<Pupil> pupilList = getSchool(idSchool).getPupilList();
        pupilList.stream()
                .filter(pupil -> pupil.getIdPupil() == idPupil)
                .findFirst()
                .ifPresent(pupilList::remove);
        getSchool(idSchool).setPupilList(pupilList);
        return getSchool(idSchool).getPupilList();
    }
}
