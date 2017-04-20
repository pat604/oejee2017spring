package hu.smiklos.stmm.pers.entity;

import hu.smiklos.stmm.pers.parameter.AppUserParameter;
import hu.smiklos.stmm.pers.query.AppUserQuery;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SebestyenMiklos on 2017. 03. 12..
 */
@Entity
@Table(name = "appuser")
@NamedQueries(value = { //
        @NamedQuery(name = AppUserQuery.GET_ALL, query = "SELECT a FROM AppUser a ORDER BY a.userId"),
        @NamedQuery(name = AppUserQuery.GET_BY_ID, query = "SELECT a FROM AppUser a WHERE a.userId=:" + AppUserParameter.ID),
        @NamedQuery(name = AppUserQuery.GET_BY_USERNAME, query = "SELECT a FROM  AppUser a WHERE a.username=:" + AppUserParameter.USERNAME)
})
public class AppUser implements Serializable {


    private String userId;
    private Wallet wallet;
    private String first_name;
    private String last_name;
    private String password;
    private String username;
    private Set<UserType> userroles;
    private CreditCard creditCard;

    public AppUser(String userId, String first_name, String last_name, String password) {

        this.userId = userId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.userroles = new HashSet<UserType>();
    }

    public AppUser() {
        this.userroles = new HashSet<UserType>();
    }

    @OneToMany
    @JoinTable(name = "userrole", joinColumns = {@JoinColumn(name = "userrole_appuser_id", referencedColumnName = "appuser_id")}, inverseJoinColumns = {@JoinColumn(name = "userrole_usertype_id", referencedColumnName = "usertype_id")})
    public Set<UserType> getUserroles() {
        return userroles;
    }

    public void setUserroles(Set<UserType> userroles) {
        this.userroles = userroles;
    }

    public void addUserRole(UserType userType) {
        if(this.userroles == null){
            this.userroles = new HashSet<UserType>();
        }
        this.userroles.add(userType);
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

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "appuser_wallet_id")
    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Column(name = "password", nullable = true)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "appuser_creditcard_id")
    public CreditCard getCreditCard() {
        return creditCard;
    }

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
