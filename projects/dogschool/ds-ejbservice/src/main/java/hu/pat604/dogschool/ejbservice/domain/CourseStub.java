package hu.pat604.dogschool.ejbservice.domain;

import java.util.Date;

/**
 * Created by pati on 2017-03-29.
 */
public class CourseStub {

    // ezen a szinten egy v több tulajdonság azonosítja egyértelműen a példányt, nem az ID

    private DogSchoolStub dogSchoolStub;
    private Date startDate;
    private CourseTypeStub courseTypeStub;
    private DogSizeStub size;
    private InstructorStub groupLeader;
    private InstructorStub assistantPrimary;
    private InstructorStub assistantSecondary;

    public CourseStub(DogSchoolStub dogSchoolStub, Date startDate, CourseTypeStub courseTypeStub, DogSizeStub size,
                      InstructorStub groupLeader, InstructorStub assistantPrimary, InstructorStub assistantSecondary) {
        this.dogSchoolStub = dogSchoolStub;
        this.startDate = startDate;
        this.courseTypeStub = courseTypeStub;
        this.size = size;
        this.groupLeader = groupLeader;
        this.assistantPrimary = assistantPrimary;
        this.assistantSecondary = assistantSecondary;
    }

    public DogSchoolStub getDogSchoolStub() {
        return dogSchoolStub;
    }

    public void setDogSchoolStub(DogSchoolStub dogSchoolStub) {
        this.dogSchoolStub = dogSchoolStub;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public CourseTypeStub getCourseTypeStub() {
        return courseTypeStub;
    }

    public void setCourseTypeStub(CourseTypeStub courseTypeStub) {
        this.courseTypeStub = courseTypeStub;
    }

    public DogSizeStub getSize() {
        return size;
    }

    public void setSize(DogSizeStub size) {
        this.size = size;
    }

    public InstructorStub getGroupLeader() {
        return groupLeader;
    }

    public void setGroupLeader(InstructorStub groupLeader) {
        this.groupLeader = groupLeader;
    }

    public InstructorStub getAssistantPrimary() {
        return assistantPrimary;
    }

    public void setAssistantPrimary(InstructorStub assistantPrimary) {
        this.assistantPrimary = assistantPrimary;
    }

    public InstructorStub getAssistantSecondary() {
        return assistantSecondary;
    }

    public void setAssistantSecondary(InstructorStub assistantSecondary) {
        this.assistantSecondary = assistantSecondary;
    }

    @Override
    public String toString() {
        return "CourseStub{" +
                ", dogSchoolStub=" + dogSchoolStub +
                ", startDate=" + startDate +
                ", courseTypeStub=" + courseTypeStub +
                ", size=" + size +
                ", groupLeader=" + groupLeader +
                ", assistantPrimary=" + assistantPrimary +
                ", assistantSecondary=" + assistantSecondary +
                '}';
    }
}
