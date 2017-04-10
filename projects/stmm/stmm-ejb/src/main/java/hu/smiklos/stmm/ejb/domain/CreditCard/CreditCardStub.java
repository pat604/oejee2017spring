package hu.smiklos.stmm.ejb.domain.CreditCard;

import hu.smiklos.stmm.ejb.common.Errors;
import hu.smiklos.stmm.pers.entity.AppUser;
import hu.smiklos.stmm.pers.entity.CreditCard;


/**
 * Created by SebestyenMiklos on 2017. 04. 06..
 */
public class CreditCardStub {
    public static final String ATTR_CARD_HOLDER_NAME = "card_holder_name";
    public static final String ATTR_CARD_NUMBER = "card_number";
    public static final String ATTR_CARD_EXPIRY_YEAR= "card_expiry_year";
    public static final String ATTR_CARD_EXPIRY_MONTH = "card_expiry_month";
    public static final String ATTR_ERROR = "credit_card_error";

    private String card_number;
    private String creditcard_card_holder_name;
    private String creditcard_expiry_year;
    private String creditcard_expiry_month;
    private AppUser creditcard_appuser;

    private Errors errors;

    public CreditCardStub() {
    }

    public CreditCardStub(CreditCard creditCard) {
        this.card_number = creditCard.getCard_number();
        this.creditcard_card_holder_name = creditCard.getCreditcard_card_holder_name();
        this.creditcard_expiry_year = creditCard.getCreditcard_expiry_year();
        this.creditcard_expiry_month = creditCard.getCreditcard_expiry_month();
        this.creditcard_appuser = creditCard.getCreditCardAppUser();
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getCreditcard_card_holder_name() {
        return creditcard_card_holder_name;
    }

    public void setCreditcard_card_holder_name(String creditcard_card_holder_name) {
        this.creditcard_card_holder_name = creditcard_card_holder_name;
    }

    public String getCreditcard_expiry_year() {
        return creditcard_expiry_year;
    }

    public void setCreditcard_expiry_year(String creditcard_expiry_year) {
        this.creditcard_expiry_year = creditcard_expiry_year;
    }

    public String getCreditcard_expiry_month() {
        return creditcard_expiry_month;
    }

    public void setCreditcard_expiry_month(String creditcard_expiry_month) {
        this.creditcard_expiry_month = creditcard_expiry_month;
    }

    public AppUser getCreditcard_appuser() {
        return creditcard_appuser;
    }

    public void setCreditcard_appuser(AppUser creditcard_appuser) {
        this.creditcard_appuser = creditcard_appuser;
    }

    public CreditCard toCreditCard(AppUser user) {
        CreditCard card = new CreditCard();
        card.setCard_number(this.card_number);
        card.setCreditCardAppUser(user);
        card.setCreditcard_expiry_month(this.creditcard_expiry_month);
        card.setCreditcard_expiry_year(this.creditcard_expiry_year);
        card.setCreditcard_card_holder_name(this.creditcard_card_holder_name);
        return card;
    }

    public boolean isValid() {
        errors = new Errors();
        if(card_number == null || card_number.isEmpty()){
            errors.add(ATTR_CARD_NUMBER, "Credit card number empty");
        }
        if (card_number != null && !card_number.isEmpty() && card_number.length() != 16){
            errors.add(ATTR_CARD_NUMBER, "Credit card number has to be 16 character long");
        }
        if(creditcard_card_holder_name == null || creditcard_card_holder_name.isEmpty()){
            errors.add(ATTR_CARD_HOLDER_NAME, "Card holder name is empty");
        }
        if(creditcard_expiry_month == null || creditcard_expiry_month.isEmpty()){
            errors.add(ATTR_CARD_EXPIRY_MONTH, "Month is empty");
        }
        if(creditcard_expiry_year == null || creditcard_expiry_year.isEmpty()){
            errors.add(ATTR_CARD_EXPIRY_YEAR, "Year is empty");
        }
        return !errors.hasError();
    }

    public Errors getErrors() {
        return errors;
    }
}
