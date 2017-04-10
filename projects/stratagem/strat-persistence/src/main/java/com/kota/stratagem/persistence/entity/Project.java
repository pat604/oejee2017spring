package com.kota.stratagem.persistence.entity;

import java.io.Serializable;
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

import com.kota.stratagem.persistence.entity.trunk.ProjectStatus;
import com.kota.stratagem.persistence.parameter.ProjectParameter;
import com.kota.stratagem.persistence.query.ProjectQuery;

@Entity
@Table(name = "projects")
@NamedQueries(value = { //
		@NamedQuery(name = ProjectQuery.COUNT_BY_ID, query = "SELECT COUNT(p) FROM Project p WHERE p.id=:" + ProjectParameter.ID),
		@NamedQuery(name = ProjectQuery.GET_ALL_PROJECTS, query = "SELECT p FROM Project p ORDER BY p.name"),
		@NamedQuery(name = ProjectQuery.GET_ALL_BY_STATUS, query = "SELECT p FROM Project p WHERE p.status=:" + ProjectParameter.STATUS + " ORDER BY p.name"),
		@NamedQuery(name = ProjectQuery.GET_BY_ID, query = "SELECT p FROM Project p WHERE p.id=:" + ProjectParameter.ID),
		@NamedQuery(name = ProjectQuery.REMOVE_BY_ID, query = "DELETE FROM Project p WHERE p.id=:" + ProjectParameter.ID)
		//
})
@SequenceGenerator(name = "projectGenerator", sequenceName = "projects_project_id_seq", allocationSize = 1)
public class Project implements Serializable {

	private static final long serialVersionUID = -6784523546510114561L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projectGenerator")
	@Column(name = "project_id", nullable = false, updatable = false, insertable = false)
	private Long id;

	@Column(name = "project_name", nullable = false)
	private String name;

	@Column(name = "project_description", nullable = true)
	private String description;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "project_status_id", nullable = false)
	private ProjectStatus status;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Task.class)
	@JoinTable(name = "project_tasks", joinColumns = @JoinColumn(name = "project_task_task_id"), inverseJoinColumns = @JoinColumn(name = "project_task_project_id"))
	private Set<Task> tasks;

	@Column(name = "project_visibility", nullable = false)
	private Boolean visible;

	public Project() {
		this.tasks = new HashSet<>();
	}

	public Project(Long id, String name, String description, ProjectStatus status, Set<Task> tasks, Boolean visible) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
		this.tasks = tasks;
		this.visible = visible;
	}
	
	public Project(String name, String description, ProjectStatus status, Set<Task> tasks, Boolean visible) {
		this.name = name;
		this.description = description;
		this.status = status;
		this.tasks = tasks;
		this.visible = visible;
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

	public ProjectStatus getStatus() {
		return status;
	}

	public void setStatus(ProjectStatus status) {
		this.status = status;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status + ", tasks=" + tasks + ", visible=" + visible + "]";
	}

}