package hu.smiklos.stmm.ejb.domain;

import hu.smiklos.stmm.pers.entity.MoneyTransfer;
import hu.smiklos.stmm.pers.entity.RepaymentType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by SebestyenMiklos on 2017. 04. 18..
 */
public class LoanOfferStub {
    MoneyTransfer transfer;


    List<RepaymentUnitStub> payments;

    public LoanOfferStub(MoneyTransfer transfer) {
        this.transfer = transfer;
    }

    public List<RepaymentUnitStub> getPayments() {
        if(payments == null){
            payments = new ArrayList<RepaymentUnitStub>();
        }
        calculatePaymentUnits(transfer,payments);
        return payments;
    }

    private void calculatePaymentUnits(MoneyTransfer transfer, List<RepaymentUnitStub> payments) {
        int numberOfPayments = getNumberOfPayments(transfer);
        initEmptyPaymentUnits(numberOfPayments, payments);
        setPaymentAmounts(numberOfPayments,transfer,payments);
        setPaymentDeadLines(transfer, payments);
    }

    private void initEmptyPaymentUnits(int numberOfPayments, List<RepaymentUnitStub> payments) {
        for(int i=0; i< numberOfPayments; i++){
            payments.add(new RepaymentUnitStub());
        }
    }


    private int getNumberOfPayments(MoneyTransfer transfer){
        int numberOfPayments = transfer.getMoneytransfer_investment_time_period_month();
        String repaymentType = transfer.getMoney_transfer_repayment_type().getRepayment_type_id();
        if(repaymentType.equals(RepaymentType.WEEK)){
            numberOfPayments *= 4;
        }
        return numberOfPayments;
    }

    private void setPaymentAmounts(int numberOfPayments, MoneyTransfer transfer, List<RepaymentUnitStub> payments){
        double amount = transfer.getExpected_return_amount() / (double) numberOfPayments;
        for( int i=0; i < numberOfPayments; i++){
            payments.get(i).setAmount(amount);
        }

    }

    private void setPaymentDeadLines(MoneyTransfer transfer, List<RepaymentUnitStub> payments) {
        int numberOfPayments = payments.size();
        int dayBetweenPayments = 30;
        if(transfer.getMoney_transfer_repayment_type().getRepayment_type_id() == RepaymentType.WEEK){
            dayBetweenPayments = 7;
        }
        for (int i = 0; i< payments.size(); i++){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime((i == 0)? new Date() : payments.get(i-1).getDeadline());
            calendar.add(Calendar.DAY_OF_YEAR, dayBetweenPayments);
            payments.get(i).setDeadline(calendar.getTime());
        }
    }

    public double getNetValue() {
        return transfer.getTransfer_amount();
    }

    public double getTotalRepayAmount() {
        return transfer.getExpected_return_amount();
    }

    public String getRePaymentMethod() {
        return transfer.getMoney_transfer_repayment_type().getRepayment_type_name();
    }

    public int getNumberOfPayments() {
        return this.getNumberOfPayments(transfer);
    }

    public String getMoneyTransferId() {
        return transfer.getMoneytransfer_id();
    }
}
