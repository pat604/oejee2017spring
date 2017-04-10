package hu.smiklos.stmm.pers.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by SebestyenMiklos on 2017. 04. 10..
 */
@Entity
@Table(name = "userrole")
public class UserRole {
    @Id
    @SequenceGenerator(name = "userroleIdGenerator", sequenceName = "userrole_userrole_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userroleIdGenerator")
    @Column(name = "userrole_id")
    private int userrole_id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "userrole_appuser_id", referencedColumnName = "appuser_id", nullable = false)
    private AppUser appUser;
    @OneToOne
    @JoinColumn(name = "userrole_usertype_id", nullable = false)
    private UserType userType;

    public UserRole() {
    }


}
