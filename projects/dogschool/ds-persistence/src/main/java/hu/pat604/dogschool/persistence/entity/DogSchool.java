package hu.pat604.dogschool.persistence.entity;

import hu.pat604.dogschool.persistence.parameter.DogSchoolParameter;
import hu.pat604.dogschool.persistence.query.DogSchoolQuery;

import javax.persistence.*;

/**
 * Created by pati on 2017-03-15.
 */

@Entity
@Table(name = "dogschool")
@NamedQueries(value = {
        @NamedQuery(name = DogSchoolQuery.GET_BY_ID, query = "SELECT d FROM DogSchool d WHERE d.id=:" + DogSchoolParameter.ID),
        @NamedQuery(name = DogSchoolQuery.GET_ALL, query = "SELECT d FROM DogSchool d ORDER BY d.name")
})
public class DogSchool {

    @Id
    @SequenceGenerator(name = "generatorDogschool", sequenceName = "dogschool_dogschool_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorDogschool")
    @Column(name = "dogschool_id", nullable = false)
    private Long id;

    @Column(name = "dogschool_name", nullable = false)
    private String name;

    @Column(name = "dogschool_location", nullable = false)
    private String location;

    @Column(name = "dogschool_opened_in", nullable = false)
    private String openedIn;

    @OneToOne
    @JoinColumn(name="dogschool_leader_id", referencedColumnName="instructor_id")
    private Instructor leader;

    public DogSchool(String name, Instructor leader, String location, String openedIn) {
        this.leader = leader;
        this.location = location;
        this.name = name;
        this.openedIn = openedIn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOpenedIn() {
        return openedIn;
    }

    public void setOpenedIn(String openedIn) {
        this.openedIn = openedIn;
    }

    public Instructor getLeader() {
        return leader;
    }

    public void setLeader(Instructor leader) {
        this.leader = leader;
    }

    @Override
    public String toString() {
        return "DogSchool{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", openedIn='" + openedIn + '\'' +
                ", leader='" + leader + '\'' +
                '}';
    }
}
