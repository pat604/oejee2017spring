package hu.smiklos.stmm.pers.entity;

import hu.smiklos.stmm.pers.parameter.CreditCardParameter;
import hu.smiklos.stmm.pers.query.CreditCardQuery;

import javax.persistence.*;

/**
 * Created by SebestyenMiklos on 2017. 04. 06..
 */
@Entity
@Table(name = "creditcard")
@NamedQueries(value = {
        @NamedQuery(name = CreditCardQuery.DELETE_BY_NUMBER, query = "DELETE FROM CreditCard c WHERE c.card_number=:" + CreditCardParameter.CARD_NUMBER),
        @NamedQuery(name = CreditCardQuery.GET_BY_CREDITCARD_ID, query = "SELECT c FROM CreditCard c WHERE c.creditcard_id=:"+ CreditCardParameter.CARD_ID),
        @NamedQuery(name = CreditCardQuery.DELETE_BY_CREDITCARD_ID, query = "DELETE FROM CreditCard c WHERE c.creditcard_id=:"+ CreditCardParameter.CARD_ID)
})
public class CreditCard {

    private String card_number;
    private String creditcard_card_holder_name;
    private String creditcard_expiry_year;
    private String creditcard_expiry_month;
    private String creditcard_id;

    public CreditCard() {
    }

    @Id
    @Column(name = "creditcard_id", nullable = false)
    public String getCreditcard_id() {
        return creditcard_id;
    }

    public void setCreditcard_id(String creditcard_id) {
        this.creditcard_id = creditcard_id;
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


    @Column(name = "creditcard_card_number", nullable = false)
    public String getCard_number() {
        return card_number;
    }


    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }
}
