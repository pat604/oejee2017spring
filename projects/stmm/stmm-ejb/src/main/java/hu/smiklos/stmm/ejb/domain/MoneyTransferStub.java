package hu.smiklos.stmm.ejb.domain;

import hu.smiklos.stmm.pers.entity.RepaymentType;
import hu.smiklos.stmm.pers.entity.Wallet;

import java.sql.Date;

/**
 * Created by SebestyenMiklos on 2017. 04. 15..
 */
public class MoneyTransferStub {
    private String moneytransfer_id;
    private Wallet wallet_from;
    private Wallet wallet_to;
    private Date transferdate;
    private Date returndate;
    private int transfer_amount;
    private int expected_return_amount;
    private RepaymentType money_transfer_repayment_type;
}
