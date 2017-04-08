package hu.pat604.dogschool.persistence.entity;

import hu.pat604.dogschool.persistence.entity.trunk.Level;
import hu.pat604.dogschool.persistence.parameter.InstructorParameter;
import hu.pat604.dogschool.persistence.query.InstructorQuery;

import javax.persistence.*;

/**
 * Created by pati on 2017-03-15.
 */

@Entity
@Table(name = "instructor")
@NamedQueries(value = {
        @NamedQuery(name = InstructorQuery.GET_BY_ID, query = "SELECT i FROM Instructor i WHERE i.id=:" + InstructorParameter.ID),
        @NamedQuery(name = InstructorQuery.GET_BY_NAME_TELEPHONE, query = "SELECT i FROM Instructor i WHERE i.name=:" + InstructorParameter.NAME
                + " AND i.telephone=:" + InstructorParameter.TELEPHONE),
        @NamedQuery(name = InstructorQuery.GET_BY_LEVEL, query = "SELECT i FROM Instructor i WHERE i.level=:" + InstructorParameter.LEVEL),
        @NamedQuery(name = InstructorQuery.GET_BY_DOGSCHOOL, query = "SELECT i FROM Instructor i WHERE i.dogSchoolPrimary=:" + InstructorParameter.DOGSCHOOL
                + " OR i.dogSchoolSecondary=:" + InstructorParameter.DOGSCHOOL),
        @NamedQuery(name = InstructorQuery.GET_ALL, query = "SELECT i FROM Instructor i ORDER BY i.name"),
        @NamedQuery(name = InstructorQuery.COUNT_BY_NAME_TELEPHONE, query = "SELECT COUNT(i) FROM Instructor i WHERE i.name=:" + InstructorParameter.NAME
                + " AND i.telephone=:" + InstructorParameter.TELEPHONE),
        @NamedQuery(name = InstructorQuery.REMOVE_BY_ID, query = "DELETE FROM Instructor i WHERE i.id=:" + InstructorParameter.ID),
        @NamedQuery(name = InstructorQuery.REMOVE_BY_NAME_TELEPHONE, query = "DELETE FROM Instructor i WHERE i.name=:" + InstructorParameter.NAME
                + " AND i.telephone=:" + InstructorParameter.TELEPHONE)
        })
public class Instructor {

    @Id
    @SequenceGenerator(name = "generatorInstructor", sequenceName = "instructor_instructor_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorInstructor")
    @Column(name = "instructor_id", nullable = false)
    private Long id;

    @Column(name = "instructor_name", nullable = false)
    private String name;

    @Column(name = "instructor_birth_year", nullable = false)
    private String birthYear;

    @Column(name = "instructor_zip_code")
    private String zipCode;

    @Column(name = "instructor_telephone", nullable = false)
    private String telephone;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "instructor_level_id", nullable = false)
    private Level level;

    @ManyToMany
    @JoinColumn(name = "instructor_school_id_primary", referencedColumnName = "dogschool_id")
    private DogSchool schoolPrimary;

    @ManyToMany
    @JoinColumn(name = "instructor_school_id_secondary", referencedColumnName = "dogschool_id")
    private DogSchool schoolSecondary;

    public Instructor(String name, String birthYear, Level level, DogSchool schoolPrimary, DogSchool schoolSecondary, String telephone, String zipCode) {
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
        return "Instructor{" +
                "birthYear=" + birthYear +
                ", id=" + id +
                ", name=" + name +
                ", zipCode=" + zipCode +
                ", telephone=" + telephone +
                ", level=" + level +
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DogSchool getSchoolPrimary() {
        return schoolPrimary;
    }

    public void setSchoolPrimary(DogSchool schoolPrimary) {
        this.schoolPrimary = schoolPrimary;
    }

    public DogSchool getSchoolSecondary() {
        return schoolSecondary;
    }

    public void setSchoolSecondary(DogSchool schoolSecondary) {
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

