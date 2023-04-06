package org.art.services;

import org.art.dto.PupilReqBody;
import org.art.dto.pupil.CreatePupilReqBody;
import org.art.model.Pupil;

import java.util.List;

public interface PupilService {

    List<Pupil> getAll();

    Pupil getPupilById(Integer id);

    boolean delPupilById(Integer id);

    boolean addPupilToSchool(Integer schoolId, PupilReqBody pupilReqBody);

    boolean pathPupil(Integer pupilId, PupilReqBody pupilReqBody);

    boolean createPupil (CreatePupilReqBody body);
}
