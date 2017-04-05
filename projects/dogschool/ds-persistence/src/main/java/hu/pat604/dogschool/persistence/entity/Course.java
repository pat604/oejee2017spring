package hu.pat604.dogschool.persistence.entity;

import hu.pat604.dogschool.persistence.entity.trunk.CourseType;
import hu.pat604.dogschool.persistence.entity.trunk.DogSize;
import hu.pat604.dogschool.persistence.parameter.CourseParameter;
import hu.pat604.dogschool.persistence.query.CourseQuery;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by pati on 2017-03-29.
 */

@Entity
@Table(name = "course")
@NamedQueries(value = {
        @NamedQuery(name = CourseQuery.COUNT_BY_ID, query = "SELECT COUNT(c) FROM Course c WHERE c.id=:" + CourseParameter.ID),
        @NamedQuery(name = CourseQuery.GET_BY_ID, query = "SELECT c FROM Course c WHERE c.id=:" + CourseParameter.ID),
        @NamedQuery(name = CourseQuery.GET_BY_DOGSCHOOL, query = "SELECT c FROM Course c WHERE c.dogSchool=:" + CourseParameter.DOGSCHOOL),
        @NamedQuery(name = CourseQuery.GET_BY_DOGSCHOOL_GROUPLEADER, query = "SELECT c FROM Course c WHERE c.dogSchool=:" + CourseParameter.DOGSCHOOL + " AND c.groupLeader=:" + CourseParameter.GROUPLEADER),
        @NamedQuery(name = CourseQuery.GET_BY_GROUPLEADER, query = "SELECT c FROM Course c WHERE c.groupLeader=:" + CourseParameter.GROUPLEADER),
        @NamedQuery(name = CourseQuery.GET_BY_DOGSCHOOL_STARTDATE, query = "SELECT c FROM Course c WHERE c.dogSchool=:" + CourseParameter.DOGSCHOOL + " AND c.startDate=:" + CourseParameter.START),
        @NamedQuery(name = CourseQuery.GET_ALL, query = "SELECT c FROM Course c ORDER By c.id"),
        @NamedQuery(name = CourseQuery.REMOVE_BY_ID, query = "DELETE FROM Course c WHERE c.id=:" + CourseParameter.ID)
})
public class Course {

    @Id
    @SequenceGenerator(name = "generatorCourse", sequenceName = "course_course_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorCourse")
    @Column(name = "course_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_school_id", referencedColumnName = "dogschool_id")
    private DogSchool dogSchool;

    @ManyToOne
    @JoinColumn(name = "course_course_type_id", referencedColumnName = "course_type_id")
    private CourseType courseType;

    @ManyToOne
    @JoinColumn(name = "course_dog_size_id", referencedColumnName = "dog_size_id")
    private DogSize size;

    @ManyToMany // mint leader, csak egy lehet: ManyToOne, de Instructorból több van: ManyToMany
    @JoinColumn(name = "course_group_leader_id", referencedColumnName = "instructor_id")
    private Instructor groupLeader;

    @ManyToMany
    @JoinColumn(name = "course_assistant_primary_id", referencedColumnName = "instructor_id")
    private Instructor assistantPrimary;

    @ManyToMany
    @JoinColumn(name = "course_assistant_secondary_id", referencedColumnName = "instructor_id")
    private Instructor assistantSecondary;

    @Column(name = "course_start")
    private Date startDate;

    public Course(DogSchool dogSchool, Date startDate, CourseType courseType, DogSize size, Instructor groupLeader, Instructor assistantPrimary, Instructor assistantSecondary) {
        this.dogSchool = dogSchool;
        this.startDate = startDate;
        this.courseType = courseType;
        this.size = size;
        this.groupLeader = groupLeader;
        this.assistantPrimary = assistantPrimary;
        this.assistantSecondary = assistantSecondary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DogSchool getDogSchool() {
        return dogSchool;
    }

    public void setDogSchool(DogSchool dogSchool) {
        this.dogSchool = dogSchool;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public DogSize getSize() {
        return size;
    }

    public void setSize(DogSize size) {
        this.size = size;
    }

    public Instructor getGroupLeader() {
        return groupLeader;
    }

    public void setGroupLeader(Instructor groupLeader) {
        this.groupLeader = groupLeader;
    }

    public Instructor getAssistantPrimary() {
        return assistantPrimary;
    }

    public void setAssistantPrimary(Instructor assistantPrimary) {
        this.assistantPrimary = assistantPrimary;
    }

    public Instructor getAssistantSecondary() {
        return assistantSecondary;
    }

    public void setAssistantSecondary(Instructor assistantSecondary) {
        this.assistantSecondary = assistantSecondary;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", dogSchool=" + dogSchool +
                ", startDate=" + startDate +
                ", courseType=" + courseType +
                ", size=" + size +
                ", groupLeader=" + groupLeader +
                ", assistantPrimary=" + assistantPrimary +
                ", assistantSecondary=" + assistantSecondary +
                '}';
    }
}
