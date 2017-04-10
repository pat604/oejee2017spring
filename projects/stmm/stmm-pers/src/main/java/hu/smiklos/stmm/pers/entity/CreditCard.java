package hu.smiklos.stmm.pers.entity;

import javax.persistence.*;

/**
 * Created by SebestyenMiklos on 2017. 04. 06..
 */
@Entity
@Table(name = "creditcard")
public class CreditCard {

    private String card_number;
    private String creditcard_card_holder_name;
    private String creditcard_expiry_year;
    private String creditcard_expiry_month;
    private AppUser CreditCardAppUser;

    public CreditCard() {
    }

    public String getCreditcard_card_holder_name() {
        return creditcard_card_holder_name;
    }

    @Column(name = "creditcard_card_holder_name", nullable = false)
    public void setCreditcard_card_holder_name(String creditcard_card_holder_name) {
        this.creditcard_card_holder_name = creditcard_card_holder_name;
    }

    @Column(name = "creditcard_expiry_year", nullable = false)
    public String getCreditcard_expiry_year() {
        return creditcard_expiry_year;
    }

    public void setCreditcard_expiry_year(String creditcard_expiry_year) {
        this.creditcard_expiry_year = creditcard_expiry_year;
    }

    @Column(name="creditcard_expiry_month" ,nullable = false)
    public String getCreditcard_expiry_month() {
        return creditcard_expiry_month;
    }

    public void setCreditcard_expiry_month(String creditcard_expiry_month) {
        this.creditcard_expiry_month = creditcard_expiry_month;
    }

    @OneToOne
    @JoinColumn(name = "creditcard_appuser_id" ,nullable = false)
    public AppUser getCreditCardAppUser() {
        return CreditCardAppUser;
    }

    public void setCreditCardAppUser(AppUser creditcard_appuser_id) {
        this.CreditCardAppUser = creditcard_appuser_id;
    }

    @Id
    @Column(name = "creditcard_card_number", nullable = false)
    public String getCard_number() {
        return card_number;
    }


    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }
}
