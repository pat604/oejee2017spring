package hu.smiklos.stmm.pers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by SebestyenMiklos on 2017. 03. 19..
 */
@Entity
@Table(name = "usertype")
public class UserType {

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
