package hu.smiklos.stmm.pers.entity;

import hu.smiklos.stmm.pers.entity.trunk.MoneyTransferStates;
import hu.smiklos.stmm.pers.parameter.MoneyTransferParameter;
import hu.smiklos.stmm.pers.query.MoneyTransferQuery;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SebestyenMiklos on 2017. 04. 15..
 */
@Entity
@Table(name = "money_transfer")
@NamedQueries(value = {
        @NamedQuery(name = MoneyTransferQuery.GET_BY_BORROW_QUERY,
                query = "SELECT a FROM MoneyTransfer a WHERE a.money_transfer_repayment_type.repayment_type_id =:" + MoneyTransferParameter.REPAYMENT_TYPE +
                        " and a.wallet_from.wallet_id <>:" + MoneyTransferParameter.WALLET_ID +
                        " and a.transferState  =:" + MoneyTransferParameter.MONEY_TRANSFER_STATE +
                        " and a.moneytransfer_investment_time_period_month between :" + MoneyTransferParameter.REPAYMENT_MONTHS_FROM + " and :" + MoneyTransferParameter.REPAYMENT_MONTHS_TO),
        @NamedQuery(name = MoneyTransferQuery.GET_BY_ID,
                query = "SELECT a FROM MoneyTransfer a WHERE a.moneytransfer_id =:" + MoneyTransferParameter.ID),
        @NamedQuery(name = MoneyTransferQuery.DELETE_BY_ID,
                query = "DELETE FROM MoneyTransfer a WHERE a.moneytransfer_id=:" + MoneyTransferParameter.ID),
        @NamedQuery(name = MoneyTransferQuery.GET_BY_REPAYMENT_TYPE,
                query = "SELECT a FROM MoneyTransfer a WHERE a.money_transfer_repayment_type.repayment_type_id =:" + MoneyTransferParameter.REPAYMENT_TYPE)
})
public class MoneyTransfer implements Serializable {


    private String moneytransfer_id;
    private Wallet wallet_from;
    private Wallet wallet_to;
    private Date transferdate;
    private Date returndate;
    private double transfer_amount;
    private double expected_return_amount;
    private int moneytransfer_investment_time_period_month;
    private RepaymentType money_transfer_repayment_type;
    private MoneyTransferStates transfer_state;

    private Set<RepaymentUnit> repaymentUnits;

    public MoneyTransfer() {
        repaymentUnits = new HashSet<RepaymentUnit>();
    }

    @Id
    @Column(name = "moneytransfer_id")
    public String getMoneytransfer_id() {
        return moneytransfer_id;
    }

    public void setMoneytransfer_id(String moneytransfer_id) {
        this.moneytransfer_id = moneytransfer_id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wallet_from")
    public Wallet getWallet_from() {
        return wallet_from;
    }

    public void setWallet_from(Wallet wallet_from) {
        this.wallet_from = wallet_from;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wallet_to")
    public Wallet getWallet_to() {
        return wallet_to;
    }


    public void setWallet_to(Wallet wallet_to) {
        this.wallet_to = wallet_to;
    }

    @Column(name = "transferdate")
    public Date getTransferdate() {
        return transferdate;
    }

    public void setTransferdate(Date transferdate) {
        this.transferdate = transferdate;
    }

    @Column(name = "returndate")
    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    @Column(name = "money_transfer_amount")
    public double getTransfer_amount() {
        return transfer_amount;
    }

    public void setTransfer_amount(double transfer_amount) {
        this.transfer_amount = transfer_amount;
    }

    @Column(name = "money_transfer_return_amount")
    public double getExpected_return_amount() {
        return expected_return_amount;
    }

    public void setExpected_return_amount(double expected_return_amount) {
        this.expected_return_amount = expected_return_amount;
    }


    @OneToOne
    @JoinColumn(name = "money_transfer_repayment_type", nullable = false)
    public RepaymentType getMoney_transfer_repayment_type() {
        return money_transfer_repayment_type;
    }

    public void setMoney_transfer_repayment_type(RepaymentType money_transfer_repayment_type) {
        this.money_transfer_repayment_type = money_transfer_repayment_type;
    }

    @Column(name = "money_transfer_invest_period_month", nullable = false)
    public int getMoneytransfer_investment_time_period_month() {
        return moneytransfer_investment_time_period_month;
    }

    public void setMoneytransfer_investment_time_period_month(int moneytransfer_investment_time_period_month) {
        this.moneytransfer_investment_time_period_month = moneytransfer_investment_time_period_month;
    }


    @Enumerated(EnumType.STRING)
    @Column(name = "money_transfer_state", nullable = false)
    public MoneyTransferStates getTransferState() {
        return transfer_state;
    }

    public void setTransferState(MoneyTransferStates transfer_state) {
        this.transfer_state = transfer_state;
    }

    @OneToMany(fetch = FetchType.EAGER, targetEntity = RepaymentUnit.class, mappedBy = "money_transfer")
    public Set<RepaymentUnit> getRepaymentUnits() {
        return repaymentUnits;
    }

    public void setRepaymentUnits(Set<RepaymentUnit> repaymentUnits) {
        this.repaymentUnits = repaymentUnits;
    }
}
