package hu.smiklos.stmm.pers.entity;

import hu.smiklos.stmm.pers.parameter.UserTypeParameter;
import hu.smiklos.stmm.pers.query.UsertypesQuery;

import javax.persistence.*;

/**
 * Created by SebestyenMiklos on 2017. 03. 19..
 */
@Entity
@Table(name = "usertype")
@NamedQueries( value = {
        @NamedQuery(name = UsertypesQuery.GET_ALL, query = "SELECT a FROM UserType a ORDER BY a.usertype"),
        @NamedQuery(name = UsertypesQuery.GET_TYPE_WHERE_STATE_IS, query = "SELECT a FROM UserType a WHERE a.state=:" + UserTypeParameter.STATE)
})
public class UserType {

    private String id;

    private String usertype;

    private int state;

    public UserType() {
    }


    public UserType(String id, String usertype) {
        this.id = id;
        this.usertype = usertype;
    }

    @Column(name = "usertype")
    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    @Id
    @Column(name = "usertype_id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "state", nullable = false)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
