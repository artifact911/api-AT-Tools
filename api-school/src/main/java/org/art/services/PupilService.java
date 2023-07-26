package org.art.services;

import org.art.dto.pupil.PatchPupilReqBody;
import org.art.dto.pupil.CreatePupilReqBody;
import org.art.model.Pupil;

import java.util.List;

public interface PupilService {

    List<Pupil> getAll();

    Pupil getPupilById(Integer id);

    boolean delPupilById(Integer id);

    boolean addPupilToSchool(Integer schoolId, PatchPupilReqBody pupilReqBody);

    boolean pathPupil(Integer pupilId, PatchPupilReqBody pupilReqBody);

    boolean createPupil (CreatePupilReqBody body);
}
