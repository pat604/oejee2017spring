package hu.smiklos.stmm.pers.entity;

import hu.smiklos.stmm.pers.parameter.RegPerDayParameter;
import hu.smiklos.stmm.pers.query.RegPerDayQuery;
import hu.smiklos.stmm.pers.query.UsertypesQuery;

import javax.persistence.*;

/**
 * Created by SebestyenMiklos on 2017. 04. 02..
 */
@Entity
@Table(name = "registration_per_day")
@NamedQueries( value = {
        @NamedQuery(name = RegPerDayQuery.EXISTS, query = "SELECT COUNT(a) FROM RegistrationPerDay a WHERE a.day=:" + RegPerDayParameter.DAY),
        @NamedQuery(name = RegPerDayQuery.GET_DAY, query = "SELECT a FROM RegistrationPerDay a WHERE a.day=:" + RegPerDayParameter.DAY),
})
public class RegistrationPerDay {
    @Id
    @Column(name = "day", nullable = false)
    String day;
    @Column(name = "count", nullable = false)
    int count;

    public RegistrationPerDay() {
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
