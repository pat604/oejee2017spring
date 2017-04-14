package hu.smiklos.stmm.ejb.domain;

import hu.smiklos.stmm.pers.entity.Wallet;

/**
 * Created by SebestyenMiklos on 2017. 04. 14..
 */
public class WalletStub {

    private String wallet_id;

    private double amount;

    public WalletStub() {
    }

    public WalletStub(Wallet wallet){
        this.setWallet_id(wallet.getWallet_id());
        this.setAmount(wallet.getAmount());
    }

    public String getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(String wallet_id) {
        this.wallet_id = wallet_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Wallet toWallet(){
        Wallet wallet=new Wallet();
        wallet.setWallet_id(this.wallet_id);
        wallet.setAmount(this.amount);
        return wallet;
    }
}
