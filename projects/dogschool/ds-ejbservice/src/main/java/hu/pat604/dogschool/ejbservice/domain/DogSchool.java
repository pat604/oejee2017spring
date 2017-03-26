package hu.pat604.dogschool.ejbservice.domain;

/**
 * Created by pati on 2017-03-15.
 */
public class DogSchool {

    private Long id;
    private String name;
    private String location;
    private String openedIn;
    private String leader;

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

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
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
