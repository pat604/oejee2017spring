package hu.qwaevisz.tickethandling.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import hu.qwaevisz.tickethandling.persistence.entity.trunk.Component;
import hu.qwaevisz.tickethandling.persistence.parameter.CompInSystemParameter;
import hu.qwaevisz.tickethandling.persistence.query.CompInSystemQuery;

@Entity
@Table(name = "comp_in_system")
@NamedQueries(value = { //
		@NamedQuery(name = CompInSystemQuery.COUNT_BY_ID, query = "SELECT COUNT(c) FROM CompInSystem c WHERE c.id=:" + CompInSystemParameter.ID),
		@NamedQuery(name = CompInSystemQuery.GET_BY_ID, query = "SELECT c FROM CompInSystem c WHERE c.id=:" + CompInSystemParameter.ID),
		@NamedQuery(name = CompInSystemQuery.GET_BY_SYS_COMP, query = "SELECT cis FROM CompInSystem cis INNER JOIN cis.system sys WHERE cis.component=:"
				+ CompInSystemParameter.COMPONENT + " AND sys=:" + CompInSystemParameter.CUSTOMER),
		@NamedQuery(name = CompInSystemQuery.GET_ALL, query = "SELECT c FROM CompInSystem c ORDER BY c.id"),
		@NamedQuery(name = CompInSystemQuery.REMOVE_BY_ID, query = "DELETE FROM CompInSystem c WHERE c.id=:" + CompInSystemParameter.ID),
		@NamedQuery(name = CompInSystemQuery.REMOVE_BY_SYS, query = "DELETE FROM CompInSystem c WHERE c.system=:" + CompInSystemParameter.CUSTOMER),
		@NamedQuery(name = CompInSystemQuery.REMOVE_BY_SYS_COMP, query = "DELETE FROM CompInSystem c WHERE c.system=:" + CompInSystemParameter.CUSTOMER
				+ " AND c.component=:" + CompInSystemParameter.COMPONENT)
		//
})
public class CompInSystem implements Serializable {

	private static final long serialVersionUID = 1525352421414297015L;

	@Id
	@SequenceGenerator(name = "generatorCIS", sequenceName = "comp_in_system_cis_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorCIS")
	@Column(name = "cis_id", nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "cis_sys_id", referencedColumnName = "cust_sys_id", nullable = false)
	private Customer system;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "cis_comp_id", nullable = false)
	private Component component;

	@Column(name = "cis_description", nullable = false)
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "cis_creationdate", nullable = false)
	private Date creationdate;

	public CompInSystem() {
		this(null, null, "", new Date());
	}

	public CompInSystem(Customer system, Component component, String description, Date creationdate) {
		super();
		this.system = system;
		this.component = component;
		this.description = description;
		this.creationdate = creationdate;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getSystem() {
		return this.system;
	}

	public void setSystem(Customer system) {
		this.system = system;
	}

	public Component getComponent() {
		return this.component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationdate() {
		return this.creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	@Override
	public String toString() {
		return "CompInSystem [id=" + this.id + ", system=" + this.system + ", component=" + this.component + ", description=" + this.description
				+ ", creationdate=" + this.creationdate + "]";
	}
}
