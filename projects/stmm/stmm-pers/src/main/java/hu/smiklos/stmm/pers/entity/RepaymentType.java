package hu.smiklos.stmm.pers.entity;

import hu.smiklos.stmm.pers.query.RepaymentTypeQuery;

import javax.persistence.*;

/**
 * Created by SebestyenMiklos on 2017. 04. 15..
 */
@Entity
@Table(name = "repayment_type")
@NamedQueries(value = {
        @NamedQuery(name = RepaymentTypeQuery.GET_ALL_REPAYMENT_TYPE, query = "SELECT a FROM RepaymentType a ORDER BY a.repayment_type_name")
})
public class RepaymentType {

    private String repayment_type_id;
    private String repayment_type_name;

    @Id
    @Column(name = "repayment_type_id")
    public String getRepayment_type_id() {
        return repayment_type_id;
    }

    public void setRepayment_type_id(String repayment_type_id) {
        this.repayment_type_id = repayment_type_id;
    }

    @Column(name = "repayment_type_name")
    public String getRepayment_type_name() {
        return repayment_type_name;
    }

    public void setRepayment_type_name(String repayment_type_name) {
        this.repayment_type_name = repayment_type_name;
    }
}
