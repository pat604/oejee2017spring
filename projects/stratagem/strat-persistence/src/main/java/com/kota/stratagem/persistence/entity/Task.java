package com.kota.stratagem.persistence.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kota.stratagem.persistence.parameter.TaskParameter;
import com.kota.stratagem.persistence.query.TaskQuery;

@Entity
@Table(name = "tasks")
@NamedQueries(value = { //
		@NamedQuery(name = TaskQuery.COUNT_BY_ID, query = "SELECT COUNT(t) FROM Task t WHERE t.id=:" + TaskParameter.ID),
		@NamedQuery(name = TaskQuery.GET_ALL_TASKS, query = "SELECT t FROM Task t ORDER BY t.completion"),
		@NamedQuery(name = TaskQuery.GET_BY_ID, query = "SELECT t FROM Task t WHERE t.id=:" + TaskParameter.ID),
		@NamedQuery(name = TaskQuery.REMOVE_BY_ID, query = "DELETE FROM Task t WHERE t.id=:" + TaskParameter.ID)
		//
})
public class Task implements Serializable {

	private static final long serialVersionUID = -6357816746519911429L;

	@Id
	@SequenceGenerator(name = "taskGenerator", sequenceName = "task_task_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskGenerator")
	@Column(name = "task_id", nullable = false)
	private Long id;

	@Column(name = "task_name", nullable = false)
	private String name;

	@Column(name = "task_description", nullable = true)
	private String description;

	@Column(name = "task_completion_percentage", nullable = false)
	private double completion;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Team.class)
	@JoinTable(name = "team_task_assignments", joinColumns = @JoinColumn(name = "assignment_recipient"), inverseJoinColumns = @JoinColumn(name = "assignment_task"))
	private Set<Team> assignedTeams;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = AppUser.class)
	@JoinTable(name = "user_task_assignments", joinColumns = @JoinColumn(name = "assignment_recipient"), inverseJoinColumns = @JoinColumn(name = "assignment_task"))
	private Set<AppUser> assignedUsers;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Impediment.class)
	@JoinTable(name = "project_impediments", joinColumns = @JoinColumn(name = "project_impediment_impediment_id"), inverseJoinColumns = @JoinColumn(name = "project_impediment_project_id"))
	private Set<Impediment> impediments;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Task.class)
	@JoinTable(name = "task_dependencies", joinColumns = @JoinColumn(name = "dependency_dependent"), inverseJoinColumns = @JoinColumn(name = "dependency_maintainer"))
	private Set<Task> dependantTasks;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Task.class)
	@JoinTable(name = "task_dependencies", joinColumns = @JoinColumn(name = "dependency_maintainer"), inverseJoinColumns = @JoinColumn(name = "dependency_dependent"))
	private Set<Task> taskDependencies;

	public Task() {
		this.assignedTeams = new HashSet<>();
		this.assignedUsers = new HashSet<>();
		this.impediments = new HashSet<>();
		this.dependantTasks = new HashSet<>();
		this.taskDependencies = new HashSet<>();
	}

	public Task(Long id, String name, String description, double completion, Set<Team> assignedTeams, Set<AppUser> assignedUsers, Set<Impediment> impediments, Set<Task> dependantTasks,
			Set<Task> taskDependencies) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.completion = completion;
		this.assignedTeams = assignedTeams;
		this.assignedUsers = assignedUsers;
		this.impediments = impediments;
		this.dependantTasks = dependantTasks;
		this.taskDependencies = taskDependencies;
	}

	public Task(String name, String description, double completion, Set<Team> assignedTeams, Set<AppUser> assignedUsers, Set<Impediment> impediments, Set<Task> dependantTasks,
			Set<Task> taskDependencies) {
		this.name = name;
		this.description = description;
		this.completion = completion;
		this.assignedTeams = assignedTeams;
		this.assignedUsers = assignedUsers;
		this.impediments = impediments;
		this.dependantTasks = dependantTasks;
		this.taskDependencies = taskDependencies;
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

	public double getCompletion() {
		return completion;
	}

	public void setCompletion(double completion) {
		this.completion = completion;
	}

	public Set<Team> getAssignedTeams() {
		return assignedTeams;
	}

	public void setAssignedTeams(Set<Team> assignedTeams) {
		this.assignedTeams = assignedTeams;
	}

	public Set<AppUser> getAssignedUsers() {
		return assignedUsers;
	}

	public void setAssignedUsers(Set<AppUser> assignedUsers) {
		this.assignedUsers = assignedUsers;
	}

	public Set<Impediment> getImpediments() {
		return impediments;
	}

	public void setImpediments(Set<Impediment> impediments) {
		this.impediments = impediments;
	}

	public Set<Task> getDependantTasks() {
		return dependantTasks;
	}

	public void setDependantTasks(Set<Task> dependantTasks) {
		this.dependantTasks = dependantTasks;
	}

	public Set<Task> getTaskDependencies() {
		return taskDependencies;
	}

	public void setTaskDependencies(Set<Task> taskDependencies) {
		this.taskDependencies = taskDependencies;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", completion=" + completion + ", assignedTeams=" + assignedTeams + ", assignedUsers=" + assignedUsers
				+ ", impediments=" + impediments + ", dependantTasks=" + dependantTasks + ", taskDependencies=" + taskDependencies + "]";
	}

}