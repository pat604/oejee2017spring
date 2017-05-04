package hu.smiklos.stmm.ejb.domain;

import hu.smiklos.stmm.ejb.common.Errors;
import hu.smiklos.stmm.pers.entity.MoneyTransfer;
import hu.smiklos.stmm.pers.entity.RepaymentType;
import hu.smiklos.stmm.pers.entity.Wallet;
import hu.smiklos.stmm.pers.entity.trunk.MoneyTransferStates;

import java.util.List;

/**
 * Created by SebestyenMiklos on 2017. 04. 15..
 */
public class MoneyTransferStub {
    public static final String INVEST_TIME_PERIOD = "invest_time_period" ;
    public static final String TRANSFER_AMOUNT = "transfer_amount";
    public static final String EXPECTED_RETURN_AMOUNT  = "expected_return_amount";
    public static final String REPAYMENT_TYPE  = "moneytransfer_repayment_type";
    public static final String MONEY_TRANSFER_ID_TO_DELETE_INVESTMENT = "money_transfer_id_to_delete_investment" ;


    private String moneytransfer_id;
    private Wallet wallet_from;
    private Wallet wallet_to;
    private double transfer_amount;
    private double expected_return_amount;
    private RepaymentType money_transfer_repayment_type;
    private int money_transfer_invest_period_month;
    private List<RepaymentType> money_transfer_repayment_types;
    private MoneyTransferStates state;

    private Errors errors;

    public MoneyTransferStub() {

    }

    public MoneyTransferStub(MoneyTransfer mTransfer) {
        moneytransfer_id = mTransfer.getMoneytransfer_id();
        wallet_from = mTransfer.getWallet_from();
        wallet_to = mTransfer.getWallet_to();
        transfer_amount = mTransfer.getTransfer_amount();
        expected_return_amount = mTransfer.getExpected_return_amount();
        money_transfer_repayment_type = mTransfer.getMoney_transfer_repayment_type();
        money_transfer_invest_period_month = mTransfer.getMoneytransfer_investment_time_period_month();
        state = mTransfer.getTransferState();
    }

    public MoneyTransfer toMoneyTransfer(){
        MoneyTransfer mTransfer= new MoneyTransfer();
        String repaymentType = money_transfer_repayment_type.getRepayment_type_id();
        mTransfer.setMoneytransfer_id(moneytransfer_id);
        mTransfer.setTransferState(state);
        mTransfer.setMoney_transfer_repayment_type(money_transfer_repayment_type);
        mTransfer.setTransfer_amount(transfer_amount);
        mTransfer.setExpected_return_amount(expected_return_amount);
        mTransfer.setMoneytransfer_investment_time_period_month(money_transfer_invest_period_month);
        mTransfer.setWallet_from(wallet_from);
        return  mTransfer;
    }

    public String getMoneytransfer_id() {
        return moneytransfer_id;
    }

    public void setMoneytransfer_id(String moneytransfer_id) {
        this.moneytransfer_id = moneytransfer_id;
    }

    public Wallet getWallet_from() {
        return wallet_from;
    }

    public void setWallet_from(Wallet wallet_from) {
        this.wallet_from = wallet_from;
    }

    public double getTransfer_amount() {
        return transfer_amount;
    }

    public void setTransfer_amount(int transfer_amount) {
        this.transfer_amount = transfer_amount;
    }

    public double getExpected_return_amount() {
        return expected_return_amount;
    }

    public void setExpected_return_amount(int expected_return_amount) {
        this.expected_return_amount = expected_return_amount;
    }

    public RepaymentType getMoney_transfer_repayment_type() {
        return money_transfer_repayment_type;
    }

    public void setMoney_transfer_repayment_type(String repaymentTypeId) {
        for(RepaymentType rType : this.getMoney_transfer_repayment_types()){
            if(rType.getRepayment_type_id().equals(repaymentTypeId)){
                this.money_transfer_repayment_type = rType;
            }
        }
    }

    public void setMoney_transfer_repayment_type(RepaymentType money_transfer_repayment_type) {
        this.money_transfer_repayment_type = money_transfer_repayment_type;
    }

    public boolean isValid() {
        if(this.errors == null){
            this.errors = new Errors();
        }
        if(wallet_from.getAmount() < transfer_amount || transfer_amount < 0){
            errors.add(TRANSFER_AMOUNT, "You have not enough money on your MB wallet");
        }
        if(expected_return_amount <= transfer_amount){
            errors.add(EXPECTED_RETURN_AMOUNT, "Expected return amount less than invested amount! ");
        }
        if(errors.hasError()){
            return false;
        }
        return true;
    }

    public List<RepaymentType> getMoney_transfer_repayment_types() {
        return money_transfer_repayment_types;
    }

    public void setMoney_transfer_repayment_types(List<RepaymentType> money_transfer_repayment_types) {
        this.money_transfer_repayment_types = money_transfer_repayment_types;
    }

    public int getMoney_transfer_invest_period_month() {
        return money_transfer_invest_period_month;
    }

    public void setMoney_transfer_invest_period_month(int money_transfer_invest_period_month) {
        this.money_transfer_invest_period_month = money_transfer_invest_period_month;
    }

    public Errors getErrors() {
        return errors;
    }

    public MoneyTransferStates getState() {
        return state;
    }

    public void setState(MoneyTransferStates state) {
        this.state = state;
    }
}
