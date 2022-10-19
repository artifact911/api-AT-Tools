package org.art.model;

public class Pupil {

    private static int id = 1;

    private int idPupil;

    private String firstName;

    private String lastName;

    private int clazz;

    private String postfixClazz;

    public Pupil(String firstName, String lastName, int clazz, String postfixClazz) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.clazz = clazz;
        this.postfixClazz = postfixClazz;
        this.idPupil = id;
        id++;
    }

    public int getIdPupil() {
        return idPupil;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getClazz() {
        return clazz;
    }

    public void setClazz(int clazz) {
        this.clazz = clazz;
    }

    public String getPostfixClazz() {
        return postfixClazz;
    }

    public void setPostfixClazz(String postfixClazz) {
        this.postfixClazz = postfixClazz;
    }

    @Override
    public String toString() {
        return "Pupil{" + "ID='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", clazz=" + clazz +
                ", postfixClazz='" + postfixClazz + '\'' +
                '}';
    }
}
