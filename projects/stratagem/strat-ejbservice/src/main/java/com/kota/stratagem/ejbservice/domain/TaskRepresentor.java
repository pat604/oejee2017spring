package com.kota.stratagem.ejbservice.domain;

import java.util.ArrayList;
import java.util.List;

public class TaskRepresentor {
	private Long id;
	private final String name;
	private final String description;
	private final double comlpetion;
	private final List<TeamRepresentor> assignedTeams;
	private final List<AppUserRepresentor> assignedUsers;
	private final List<ImpedimentRepresentor> impediments;
	private final List<TaskRepresentor> dependantTasks;
	private final List<TaskRepresentor> taskDependencies;
	private final ObjectiveRepresentor objective;
	private final ProjectRepresentor project;

	public TaskRepresentor() {
		this(null, "", "", 0, null, null);
	}

	public TaskRepresentor(Long id, String name, String description, double comlpetion, ObjectiveRepresentor objective, ProjectRepresentor project) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.comlpetion = comlpetion;
		this.assignedTeams = new ArrayList<>();
		this.assignedUsers = new ArrayList<>();
		this.impediments = new ArrayList<>();
		this.dependantTasks = new ArrayList<>();
		this.taskDependencies = new ArrayList<>();
		this.objective = objective;
		this.project = project;
	}

	public TaskRepresentor(String name, String description, double comlpetion, ObjectiveRepresentor objective, ProjectRepresentor project) {
		this.name = name;
		this.description = description;
		this.comlpetion = comlpetion;
		this.assignedTeams = new ArrayList<>();
		this.assignedUsers = new ArrayList<>();
		this.impediments = new ArrayList<>();
		this.dependantTasks = new ArrayList<>();
		this.taskDependencies = new ArrayList<>();
		this.objective = objective;
		this.project = project;
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

	public String getDescription() {
		return description;
	}

	public double getComlpetion() {
		return comlpetion;
	}

	public List<TeamRepresentor> getAssignedTeams() {
		return assignedTeams;
	}

	public void addTeam(TeamRepresentor team) {
		this.assignedTeams.add(team);
	}

	public List<AppUserRepresentor> getAssignedUsers() {
		return assignedUsers;
	}

	public void addUser(AppUserRepresentor user) {
		this.assignedUsers.add(user);
	}

	public List<ImpedimentRepresentor> getImpediments() {
		return impediments;
	}

	public void addImpediment(ImpedimentRepresentor impediment) {
		this.impediments.add(impediment);
	}

	public List<TaskRepresentor> getDependantTasks() {
		return dependantTasks;
	}

	public void addDependantTask(TaskRepresentor task) {
		this.dependantTasks.add(task);
	}

	public List<TaskRepresentor> getTaskDependencies() {
		return taskDependencies;
	}

	public void addTaskDependency(TaskRepresentor task) {
		this.taskDependencies.add(task);
	}
	
	public ObjectiveRepresentor getObjective() {
		return objective;
	}

	public ProjectRepresentor getProject() {
		return project;
	}

	@Override
	public String toString() {
		return "TaskRepresentor [id=" + id + ", name=" + name + ", description=" + description + ", comlpetion=" + comlpetion + ", assignedTeams="
				+ assignedTeams + ", assignedUsers=" + assignedUsers + ", impediments=" + impediments + ", dependantTasks=" + dependantTasks
				+ ", taskDependencies=" + taskDependencies + ", objective=" + objective + ", project=" + project + "]";
	}

}