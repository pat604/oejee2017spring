package hu.smiklos.stmm.pers.entity;

import hu.smiklos.stmm.pers.parameter.WalletParameter;
import hu.smiklos.stmm.pers.query.WalletQuery;

import javax.persistence.*;

/**
 * Created by SebestyenMiklos on 2017. 04. 14..
 */
@Entity
@Table(name = "wallet")
@NamedQueries(value = {
        @NamedQuery(name = WalletQuery.GET_WALLET_BY_ID, query = "SELECT w FROM Wallet w WHERE w.wallet_id=:" + WalletParameter.WALLET_ID)
})
public class Wallet {


    private String wallet_id;

    private double amount;

    private AppUser walletOwner;


    @Id
    @Column(name = "wallet_id")
    public String getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(String wallet_id) {
        this.wallet_id = wallet_id;
    }

    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @OneToOne(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
    @JoinColumn(name = "wallet_id", referencedColumnName = "appuser_wallet_id")
    public AppUser getWalletOwner() {
        return walletOwner;
    }

    public void setWalletOwner(AppUser walletOwner) {
        this.walletOwner = walletOwner;
    }
}
