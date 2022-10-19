package org.art.model;

import java.util.List;

public class School {

    private static int idSchool = 1;

    private int id;

    private List<Pupil> pupilList;

    public School(List<Pupil> pupilList) {
        this.pupilList = pupilList;
        this.id = idSchool;
        idSchool++;
    }

    public int getId() {
        return id;
    }

    public List<Pupil> getPupilList() {
        return pupilList;
    }

    public void setPupilList(List<Pupil> pupilList) {
        this.pupilList = pupilList;
    }
}
