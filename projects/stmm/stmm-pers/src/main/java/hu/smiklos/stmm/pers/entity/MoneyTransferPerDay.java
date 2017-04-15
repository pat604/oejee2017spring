package hu.smiklos.stmm.pers.entity;

import hu.smiklos.stmm.pers.parameter.MoneyTransferPerDayParameter;
import hu.smiklos.stmm.pers.parameter.RegPerDayParameter;
import hu.smiklos.stmm.pers.query.MoneyTransferPerDayQuery;
import hu.smiklos.stmm.pers.query.RegPerDayQuery;

import javax.persistence.*;

/**
 * Created by SebestyenMiklos on 2017. 04. 15..
 */
@Entity
@Table(name = "moneytransfer_per_day")
@NamedQueries( value = {
        @NamedQuery(name = MoneyTransferPerDayQuery.EXISTS, query = "SELECT COUNT(a) FROM MoneyTransferPerDay a WHERE a.day=:" + MoneyTransferPerDayParameter.DAY),
        @NamedQuery(name = MoneyTransferPerDayQuery.GET_DAY, query = "SELECT a FROM MoneyTransferPerDay a WHERE a.day=:" + MoneyTransferPerDayParameter.DAY),
})
public class MoneyTransferPerDay {

    @Id
    @Column(name = "day", nullable = false)
    String day;
    @Column(name = "count", nullable = false)
    int count;

    public MoneyTransferPerDay() {
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
