package hu.qwaevisz.tickethandling.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import hu.qwaevisz.tickethandling.persistence.parameter.ComponentParameter;
import hu.qwaevisz.tickethandling.persistence.query.ComponentQuery;

@Entity
@Table(name = "component")
@NamedQueries(value = { //
		@NamedQuery(name = ComponentQuery.COUNT_BY_ID, query = "SELECT COUNT(c) FROM Component c WHERE c.id=:" + ComponentParameter.ID),
		@NamedQuery(name = ComponentQuery.GET_BY_ID, query = "SELECT c FROM Component c WHERE c.id=:" + ComponentParameter.ID),
		@NamedQuery(name = ComponentQuery.GET_ALL, query = "SELECT c FROM Component c ORDER BY c.id"),
		@NamedQuery(name = ComponentQuery.REMOVE_BY_ID, query = "DELETE FROM Component c WHERE c.id=:" + ComponentParameter.ID)
		//
})
public class Component implements Serializable {

	private static final long serialVersionUID = 1525352421414297015L;

	@Id
	@Column(name = "comp_id", nullable = false)
	private String id;

	@Column(name = "comp_description", nullable = false)
	private String description;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = CompInSystem.class, mappedBy = "component")
	private final Set<CompInSystem> systems;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "comp_creationdate", nullable = false)
	private Date creationdate;

	public Component() {
		this("", "", new Date());
	}

	public Component(String id, String description, Date creationdate) {
		super();
		this.id = id;
		this.description = description;
		this.creationdate = creationdate;
		this.systems = new HashSet<>();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Set<CompInSystem> getSystems() {
		return this.systems;
	}

	@Override
	public String toString() {
		return "Component [id=" + this.id + ", description=" + this.description + ", systems=" + this.systems + ", creationdate=" + this.creationdate + "]";
	}

}
