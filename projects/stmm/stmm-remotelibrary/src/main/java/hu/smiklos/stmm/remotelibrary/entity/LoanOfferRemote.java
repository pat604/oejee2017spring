package hu.smiklos.stmm.remotelibrary.entity;

import java.io.Serializable;

/**
 * Created by SebestyenMiklos on 2017. 05. 04..
 */
public class LoanOfferRemote implements Serializable {
    private String repaymentType;
    private int duration;
    private double amount;
    private double cost;

    public LoanOfferRemote(String repaymentType, int duration, double amount, double cost) {
        this.repaymentType = repaymentType;
        this.duration = duration;
        this.amount = amount;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("%s %n %n %n", repaymentType,duration,amount,cost);
    }
}
