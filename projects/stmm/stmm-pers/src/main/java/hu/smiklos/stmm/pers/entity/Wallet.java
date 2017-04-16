package hu.smiklos.stmm.pers.entity;

import hu.smiklos.stmm.pers.parameter.WalletParameter;
import hu.smiklos.stmm.pers.query.WalletQuery;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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


    private Set<MoneyTransfer> investments;

    private Set<MoneyTransfer> debts;

    public Wallet() {
        investments = new HashSet<MoneyTransfer>();
        debts = new HashSet<MoneyTransfer>();
    }

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

    @OneToMany(fetch = FetchType.EAGER,targetEntity = MoneyTransfer.class, mappedBy = "wallet_from")
    public Set<MoneyTransfer> getInvestments() {
        return investments;
    }

    public void setInvestments(Set<MoneyTransfer> investments){
        this.investments = investments;
    }

    @OneToMany(fetch = FetchType.EAGER,targetEntity = MoneyTransfer.class, mappedBy = "wallet_to")
    public Set<MoneyTransfer> getDebts() {
        return debts;
    }

    public void setDebts(Set<MoneyTransfer> debts) {
        this.debts = debts;
    }
}
