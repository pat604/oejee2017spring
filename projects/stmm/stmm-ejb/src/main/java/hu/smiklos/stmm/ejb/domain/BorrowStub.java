package hu.smiklos.stmm.ejb.domain;

import hu.smiklos.stmm.ejb.common.Errors;
import hu.smiklos.stmm.pers.entity.RepaymentType;
import hu.smiklos.stmm.pers.entity.trunk.MoneyTransferStates;

/**
 * Created by SebestyenMiklos on 2017. 04. 16..
 */
public class BorrowStub {
    public static final String BORROW_AMOUNT = "borrow_amount";
    public static final String BORROW_REPAYMENT_TYPE = "borrow_repayment_type";
    public static final String BORROW_REPAYMENT_PERIOD_MONTH_MIN = "borrow_repayment_period_month_min";
    public static final String BORROW_REPAYMENT_PERIOD_MONTH_MAX = "borrow_repayment_period_month_max";

    private String repaymentType = RepaymentType.MONTH;
    private int borrowAmount;
    private int repaymentDurationFrom = 1;
    private int repaymentDurationTo = 600;

    private Errors errors;

    public String getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(String repaymentType) {
        this.repaymentType = repaymentType;
    }

    public int getBorrowAmount() {
        return borrowAmount;
    }

    public void setBorrowAmount(int borrowAmount) {
        this.borrowAmount = borrowAmount;
    }

    public int getRepaymentDurationFrom() {
        return repaymentDurationFrom;
    }

    public void setRepaymentDurationFrom(int repaymentDurationFrom) {
        this.repaymentDurationFrom = repaymentDurationFrom;
    }

    public int getRepaymentDurationTo() {
        return repaymentDurationTo;
    }

    public void setRepaymentDurationTo(int getRepaymentDurationTo) {
        this.repaymentDurationTo = getRepaymentDurationTo;
    }

    public boolean isValid(){
        if(errors == null){
            errors = new Errors();
        }
        if(repaymentDurationFrom >= repaymentDurationTo){
            errors.add(BorrowStub.BORROW_AMOUNT,"Wrong repayment length given!");
        }
        return !errors.hasError();

    }

    public Errors getErrors() {
        return errors;
    }


}
