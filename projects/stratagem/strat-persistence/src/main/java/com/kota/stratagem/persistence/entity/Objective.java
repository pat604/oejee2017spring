package com.kota.stratagem.persistence.entity;

import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kota.stratagem.persistence.entity.trunk.ObjectiveStatus;
import com.kota.stratagem.persistence.parameter.ObjectiveParameter;
import com.kota.stratagem.persistence.query.ObjectiveQuery;

@Entity
@Table(name = "objectives")
@NamedQueries(value = { //
		@NamedQuery(name = ObjectiveQuery.COUNT_BY_ID, query = "SELECT COUNT(o) FROM Objective o WHERE o.id=:" + ObjectiveParameter.ID),
		@NamedQuery(name = ObjectiveQuery.GET_ALL_OBJECTIVES, query = "SELECT o FROM Objective o ORDER BY o.name"),
		@NamedQuery(name = ObjectiveQuery.GET_BY_ID, query = "SELECT o FROM Objective o WHERE o.id=:" + ObjectiveParameter.ID),
		@NamedQuery(name = ObjectiveQuery.REMOVE_BY_ID, query = "DELETE FROM Objective o WHERE o.id=:" + ObjectiveParameter.ID)
		//
})
@SequenceGenerator(name = "objectiveGenerator", sequenceName = "objectives_objective_id_seq", allocationSize = 1)
public class Objective {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "objectiveGenerator")
	@Column(name = "objective_id", nullable = false, updatable = false, insertable = false)
	private Long id;

	@Column(name = "objective_name", nullable = false)
	private String name;

	@Column(name = "objective_description", nullable = true)
	private String description;
	
	@Column(name = "objective_priority", nullable = false)
	private int priority;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "objective_status_id", nullable = false)
	private ObjectiveStatus status;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Task.class)
	@JoinTable(name = "objective_projects", joinColumns = @JoinColumn(name = "objective_project_project"), inverseJoinColumns = @JoinColumn(name = "objective_project_objective"))
	private Set<Project> projects;

	public Objective() {
		this.projects = new HashSet<>();
	}
	
	public Objective(Long id, String name, String description, int priority, ObjectiveStatus status, Set<Project> projects) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.status = status;
		this.projects = projects;
	}

	public Objective(String name, String description, int priority, ObjectiveStatus status, Set<Project> projects) {
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.status = status;
		this.projects = projects;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public ObjectiveStatus getStatus() {
		return status;
	}

	public void setStatus(ObjectiveStatus status) {
		this.status = status;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Objective [id=" + id + ", name=" + name + ", description=" + description + ", priority=" + priority + ", status=" + status + ", projects="
				+ projects + "]";
	}
		
}
