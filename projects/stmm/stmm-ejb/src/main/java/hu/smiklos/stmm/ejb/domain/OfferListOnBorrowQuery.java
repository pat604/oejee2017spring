package hu.smiklos.stmm.ejb.domain;

import hu.smiklos.stmm.pers.entity.MoneyTransfer;

import java.io.Serializable;
import java.util.List;


/**
 * Created by SebestyenMiklos on 2017. 04. 16..
 */
public class OfferListOnBorrowQuery implements Serializable {

    List<MoneyTransfer> offers;

    public List<MoneyTransfer> getOffers() {
        return offers;
    }

    public void setOffers(List<MoneyTransfer> offers) {
        this.offers = offers;
    }
}
