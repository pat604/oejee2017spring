package hu.pat604.dogschool.ejbservice.domain;

import java.lang.Override;
import java.lang.String;

/**
 * Created by pati on 2017-03-15.
 */

public class DogSchoolStub {

    private String name;
    private String location;
    private String openedIn;
    private InstructorStub leader;

    public DogSchoolStub(String name, InstructorStub leader, String location, String openedIn) {
        this.leader = leader;
        this.location = location;
        this.name = name;
        this.openedIn = openedIn;
    }

    @Override
    public String toString() {
        return "DogSchoolStub{" +
                ", name=" + name +
                ", location=" + location +
                ", openedIn=" + openedIn +
                ", leader=" + leader +
                '}';
    }


    public InstructorStub getLeader() {
        return leader;
    }

    public void setLeader(InstructorStub leader) {
        this.leader = leader;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpenedIn() {
        return openedIn;
    }

    public void setOpenedIn(String openedIn) {
        this.openedIn = openedIn;
    }
}