package hu.pat604.dogschool.ejbservice.domain;

import java.lang.Override;
import java.lang.String;

/**
 * Created by pati on 2017-03-15.
 */


public class InstructorStub {

    private String name;
    private String birthYear;
    private String zipCode;
    private String telephone;
    private LevelStub level;
    private DogSchoolStub schoolPrimary;
    private DogSchoolStub schoolSecondary;

    public InstructorStub(String name, String birthYear, LevelStub level,
                          DogSchoolStub schoolPrimary, DogSchoolStub schoolSecondary, String telephone, String zipCode) {
        this.birthYear = birthYear;
        this.level = level;
        this.name = name;
        this.schoolPrimary = schoolPrimary;
        this.schoolSecondary = schoolSecondary;
        this.telephone = telephone;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "InstructorStub{" +
                "birthYear=" + birthYear +
                ", name=" + name +
                ", zipCode=" + zipCode +
                ", telephone=" + telephone +
                ", levelStub=" + level +
                ", schoolPrimary=" + schoolPrimary +
                ", schoolSecondary=" + schoolSecondary +
                '}';
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public LevelStub getLevelStub() {
        return level;
    }

    public void setLevelStub(LevelStub levelStub) {
        this.level = levelStub;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DogSchoolStub getSchoolPrimary() {
        return schoolPrimary;
    }

    public void setSchoolPrimary(DogSchoolStub schoolPrimary) {
        this.schoolPrimary = schoolPrimary;
    }

    public DogSchoolStub getSchoolSecondary() {
        return schoolSecondary;
    }

    public void setSchoolSecondary(DogSchoolStub schoolSecondary) {
        this.schoolSecondary = schoolSecondary;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}

