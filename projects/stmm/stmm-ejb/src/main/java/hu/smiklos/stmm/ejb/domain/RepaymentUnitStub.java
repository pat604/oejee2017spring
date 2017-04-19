package hu.smiklos.stmm.ejb.domain;

import java.util.Date;

/**
 * Created by SebestyenMiklos on 2017. 04. 18..
 */
public class RepaymentUnitStub {
    private Date deadline;
    private float amount;

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
