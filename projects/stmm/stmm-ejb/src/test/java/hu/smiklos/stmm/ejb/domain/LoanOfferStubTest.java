package hu.smiklos.stmm.ejb.domain;

import hu.smiklos.stmm.pers.entity.MoneyTransfer;
import hu.smiklos.stmm.pers.entity.RepaymentType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by SebestyenMiklos on 2017. 04. 18..
 */
public class LoanOfferStubTest {
    MoneyTransfer transferWeekly;
    MoneyTransfer transferMonthly;
    float epsilon = 0.001f;

    @Before
    public void setUp() throws Exception {
        transferWeekly = new MoneyTransfer();
        transferMonthly = new MoneyTransfer();
        initMonthlyTransfer(transferMonthly);
        initWeeklyTransfer(transferWeekly);
    }

    private void initWeeklyTransfer(MoneyTransfer transfer){
        RepaymentType repaymentType= new RepaymentType();
        repaymentType.setRepayment_type_id(RepaymentType.WEEK);
        repaymentType.setRepayment_type_name("Weekly");

        transfer.setMoney_transfer_repayment_type(repaymentType);
        transfer.setTransfer_amount(100);
        transfer.setExpected_return_amount(113);
        transfer.setMoneytransfer_investment_time_period_month(10);


    }

    private void initMonthlyTransfer(MoneyTransfer transfer) {
        RepaymentType repaymentType= new RepaymentType();
        repaymentType.setRepayment_type_id(RepaymentType.MONTH);
        repaymentType.setRepayment_type_name("Monthly");

        transfer.setMoney_transfer_repayment_type(repaymentType);
        transfer.setTransfer_amount(100);
        transfer.setExpected_return_amount(113);
        transfer.setMoneytransfer_investment_time_period_month(10);


    }


    @Test
    public void getPaymentsWeekly_CheckPaymentsNumber() throws Exception {
        LoanOfferStub offer = new LoanOfferStub(transferWeekly);
        Assert.assertEquals(40, offer.getPayments().size());
    }

    @Test
    public void getPaymentsWeekly_CheckPaymentAmount() throws Exception {
        LoanOfferStub offer = new LoanOfferStub(transferWeekly);
        Assert.assertEquals( 2.825f , offer.getPayments().get(0).getAmount() , epsilon );
    }


    @Test
    public void getPaymentsWeekly_CheckFirstDeadlines() throws Exception {
        LoanOfferStub offer = new LoanOfferStub(transferWeekly);
        List<RepaymentUnitStub> units = offer.getPayments();
        Date expectedFirstPaymentDate = getDate(new Date(),7);
        int deltaHour = getHoursBeetweenDates(units.get(0).getDeadline(), expectedFirstPaymentDate);
        Assert.assertTrue(deltaHour < 1);
    }

    @Test
    public void getPaymentsWeekly_CheckLastDeadline() throws Exception {
        LoanOfferStub offer = new LoanOfferStub(transferWeekly);
        List<RepaymentUnitStub> units = offer.getPayments();
        Date expectedLastPaymentDate = getDate(new Date(),7 * units.size());
        int deltaHour = getHoursBeetweenDates(units.get(units.size()-1).getDeadline(), expectedLastPaymentDate);
        Assert.assertTrue(deltaHour < 1);
    }


    @Test
    public void getPaymentsMonthly_CheckPaymentsNumber() throws Exception {
        LoanOfferStub offer = new LoanOfferStub(transferMonthly);
        Assert.assertEquals(10, offer.getPayments().size());
    }

    @Test
    public void getPaymentsMonthly_CheckPaymentAmount() throws Exception {
        LoanOfferStub offer = new LoanOfferStub(transferMonthly);
        Assert.assertEquals(11.3f, offer.getPayments().get(0).getAmount() , epsilon);
    }


    @Test
    public void getPaymentsMonthly_CheckFirstDeadline() throws Exception {
        LoanOfferStub offer = new LoanOfferStub(transferMonthly);
        List<RepaymentUnitStub> units = offer.getPayments();
        Date expectedFirstPaymentDate = getDate(new Date(),30);
        int deltaHour = getHoursBeetweenDates(units.get(0).getDeadline(), expectedFirstPaymentDate);
        Assert.assertTrue(deltaHour < 1);
    }

    @Test
    public void getPaymentsMonthly_CheckLastDeadline() throws Exception {
        LoanOfferStub offer = new LoanOfferStub(transferMonthly);
        List<RepaymentUnitStub> units = offer.getPayments();
        Date expectedLastPaymentDate = getDate(new Date(),30 * units.size());
        int deltaHour = getHoursBeetweenDates(units.get(units.size()-1).getDeadline(), expectedLastPaymentDate);
        Assert.assertTrue(deltaHour < 1);
    }



    private Date getDate(Date date, int plusDay){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, plusDay);
        return calendar.getTime();
    }

    private int getHoursBeetweenDates(Date startDate, Date endDate){
        long secs = (endDate.getTime() - startDate.getTime()) / 1000;
        int hours = (int)(secs / 3600);
        return hours;
    }



}