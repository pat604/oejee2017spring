package hu.smiklos.stmm.pers.entity;

import com.sun.xml.internal.bind.v2.runtime.Name;
import hu.smiklos.stmm.pers.parameter.AppUserParameter;
import hu.smiklos.stmm.pers.query.AppUserQuery;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by SebestyenMiklos on 2017. 03. 12..
 */
@Entity
@Table(name = "appuser")
@NamedQueries(value = { //
        @NamedQuery(name = AppUserQuery.GET_ALL, query = "SELECT a FROM AppUser a ORDER BY a.userId"),
        @NamedQuery(name = AppUserQuery.GET_BY_ID, query = "SELECT a FROM AppUser a WHERE a.userId=:"+ AppUserParameter.ID)
})
public class AppUser implements Serializable {


    private String userId;
    private String walletId;
    private String password;
    private UserType userType;

    public AppUser(String userId, String walletId, String password, UserType userType) {
        this.userId = userId;
        this.walletId = walletId;
        this.password = password;
        this.userType = userType;
    }

    public AppUser() {
    }

    @Id
    @Column(name = "appuser_id", nullable = false)
    public String getUserId() {

        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "wallet_id", nullable = true)
    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    @Column(name = "password", nullable = true)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToOne
    @JoinColumn(name="appuser_usertype_id")
    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }


}
