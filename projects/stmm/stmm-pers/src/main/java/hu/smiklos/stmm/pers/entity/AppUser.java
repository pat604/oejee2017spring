package hu.smiklos.stmm.pers.entity;

import hu.smiklos.stmm.pers.entity.enums.UserType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by SebestyenMiklos on 2017. 03. 12..
 */
@Entity
@Table(name = "appuser")
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

    @Column(name = "usertype", nullable = false)
    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
