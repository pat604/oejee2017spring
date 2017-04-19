package hu.smiklos.stmm.ejb.domain;

import java.util.Date;

/**
 * Created by SebestyenMiklos on 2017. 04. 18..
 */
public class RepaymentUnitStub {
    private Date deadline;
    private double amount;

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
