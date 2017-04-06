package hu.smiklos.stmm.pers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by SebestyenMiklos on 2017. 04. 06..
 */
@Entity
@Table(name = "creditcard")
public class CreditCard {

    private String card_number;

    public CreditCard() {
    }

    @Id
    @Column(name = "creditcard_card_number")
    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }
}
