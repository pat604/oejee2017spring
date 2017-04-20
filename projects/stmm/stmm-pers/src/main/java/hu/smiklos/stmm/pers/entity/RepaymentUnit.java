package hu.smiklos.stmm.pers.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by SebestyenMiklos on 2017. 04. 19..
 */
@Entity
@Table(name = "repayment_unit")
public class RepaymentUnit {

    private String repayment_unit_id;
    private MoneyTransfer money_transfer;
    private Date repayment_unit_deadline;
    private double repayment_unit_amount;

    public RepaymentUnit() {

    }

    @Id
    @Column(name = "repayment_unit_id")
    public String getId() {
        return repayment_unit_id;
    }

    public void setId(String repayment_unit_id) {
        this.repayment_unit_id = repayment_unit_id;
    }

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "repayment_unit_money_transfer_id")
    public MoneyTransfer getMoney_transfer() {
        return money_transfer;
    }

    public void setMoney_transfer(MoneyTransfer money_transfer) {
        this.money_transfer = money_transfer;
    }

    @Column(name = "repayment_unit_deadline", nullable = false)
    public Date getDeadline() {
        return repayment_unit_deadline;
    }

    public void setDeadline(Date repayment_unit_deadline) {
        this.repayment_unit_deadline = repayment_unit_deadline;
    }

    @Column(name = "repayment_unit_amount", nullable = false)
    public double getRepaymentAmount() {
        return repayment_unit_amount;
    }

    public void setRepaymentAmount(double repayment_unit_amount) {
        this.repayment_unit_amount = repayment_unit_amount;
    }
}
