package hu.smiklos.stmm.ejb.domain;

import java.io.Serializable;

/**
 * Created by SebestyenMiklos on 2017. 05. 01..
 */
public class LoanOfferForRemoteStub implements Serializable {
    private double amount;
    private double repayment_amount;
    private String repayment_type;
    private double cost_of_loan;
    private double number_repayment_unit;


    public LoanOfferForRemoteStub(double amount, double repayment_amount,String repayment_type, double cost_of_loan, double number_repayment_unit) {
        this.amount = amount;
        this.repayment_amount = repayment_amount;
        this.cost_of_loan = cost_of_loan;
        this.number_repayment_unit = number_repayment_unit;
        this.repayment_type = repayment_type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getRepayment_amount() {
        return repayment_amount;
    }

    public void setRepayment_amount(double repayment_amount) {
        this.repayment_amount = repayment_amount;
    }

    public double getCost_of_loan() {
        return cost_of_loan;
    }

    public void setCost_of_loan(double cost_of_loan) {
        this.cost_of_loan = cost_of_loan;
    }

    public double getNumber_repayment_unit() {
        return number_repayment_unit;
    }

    public void setNumber_repayment_unit(double number_repayment_unit) {
        this.number_repayment_unit = number_repayment_unit;
    }

    public String getRepayment_type() {
        return repayment_type;
    }

    public void setRepayment_type(String repayment_type) {
        this.repayment_type = repayment_type;
    }
}
