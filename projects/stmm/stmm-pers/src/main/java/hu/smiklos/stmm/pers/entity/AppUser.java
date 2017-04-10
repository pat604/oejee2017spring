package hu.smiklos.stmm.pers.entity;

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
        @NamedQuery(name = AppUserQuery.GET_BY_ID, query = "SELECT a FROM AppUser a WHERE a.userId=:"+ AppUserParameter.ID),
        @NamedQuery(name = AppUserQuery.GET_BY_USERNAME, query = "SELECT a FROM  AppUser a WHERE a.username=:" + AppUserParameter.USERNAME)
})
public class AppUser implements Serializable {


    private String userId;
    private String walletId;
    private String first_name;
    private String last_name;
    private String password;
    private String username;
    private UserType userType;
    private CreditCard creditCard;

    public AppUser(String userId, String walletId, String first_name, String last_name, String password, UserType userType) {
        this.userId = userId;
        this.walletId = walletId;
        this.first_name = first_name;
        this.last_name = last_name;
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

    @Column(name = "first_name", nullable = false)
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Column(name = "last_name", nullable = false)
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    @OneToOne
    @JoinColumn(name="appuser_creditcard_card_number")
    public CreditCard getCreditCard() { return  creditCard; }

    public void setCreditCard(CreditCard card) {
        this.creditCard = card;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
