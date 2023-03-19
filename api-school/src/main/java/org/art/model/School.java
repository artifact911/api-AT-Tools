package org.art.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class School {

    private static int idSchool = 1;

    private int id;

    private List<Pupil> pupilList;

    public School(List<Pupil> pupilList) {
        this.pupilList = pupilList;
        this.id = idSchool;
        idSchool++;
    }
}
