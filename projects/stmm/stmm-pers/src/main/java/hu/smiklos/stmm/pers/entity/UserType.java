package hu.smiklos.stmm.pers.entity;

import hu.smiklos.stmm.pers.query.UsertypesQuery;

import javax.persistence.*;

/**
 * Created by SebestyenMiklos on 2017. 03. 19..
 */
@Entity
@Table(name = "usertype")
@NamedQueries( value = {
        @NamedQuery(name = UsertypesQuery.GET_ALL, query = "SELECT a FROM UserType a ORDER BY a.usertype"),
})
public class UserType {

    public UserType() {
    }

    public UserType(String id, String usertype) {
        this.id = id;
        this.usertype = usertype;
    }

    private String id;

    @Column(name = "usertype")
    public String getUsertype() {
        return usertype;
    }


    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    private String usertype;

    @Id
    @Column(name = "usertype_id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
