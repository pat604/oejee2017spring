package com.kota.stratagem.ejbservice.domain;

import java.util.ArrayList;
import java.util.List;

public class ObjectiveRepresentor {
	private Long id;
	private final String name;
	private final String description;
	private final int priority;
	private final ObjectiveStatusRepresentor status;
	private final List<ProjectRepresentor> projects;
	private final List<TaskRepresentor> tasks;
	private final List<TeamRepresentor> assignedTeams;
	private final List<AppUserRepresentor> assignedUsers;

	public ObjectiveRepresentor() {
		this(null, "", "", 10, ObjectiveStatusRepresentor.PLANNED);
	}

	public ObjectiveRepresentor(Long id, String name, String description, int priority, ObjectiveStatusRepresentor status) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.status = status;
		this.projects = new ArrayList<>();
		this.tasks = new ArrayList<>();
		this.assignedTeams = new ArrayList<>();
		this.assignedUsers = new ArrayList<>();
	}

	public ObjectiveRepresentor(String name, String description, int priority, ObjectiveStatusRepresentor status) {
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.status = status;
		this.projects = new ArrayList<>();
		this.tasks = new ArrayList<>();
		this.assignedTeams = new ArrayList<>();
		this.assignedUsers = new ArrayList<>();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public int getPriority() {
		return this.priority;
	}

	public ObjectiveStatusRepresentor getStatus() {
		return this.status;
	}

	public List<ProjectRepresentor> getProjects() {
		return this.projects;
	}

	public void addProject(ProjectRepresentor project) {
		this.projects.add(project);
	}

	public List<TaskRepresentor> getTasks() {
		return this.tasks;
	}

	public void addTask(TaskRepresentor task) {
		this.tasks.add(task);
	}

	public List<TeamRepresentor> getAssignedTeams() {
		return this.assignedTeams;
	}

	public void addTeam(TeamRepresentor team) {
		this.assignedTeams.add(team);
	}

	public List<AppUserRepresentor> getAssignedUsers() {
		return this.assignedUsers;
	}

	public void addUser(AppUserRepresentor user) {
		this.assignedUsers.add(user);
	}

	@Override
	public String toString() {
		return "ObjectiveRepresentor [id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", priority=" + this.priority + ", status="
				+ this.status + ", projects=" + this.projects + ", tasks=" + this.tasks + ", assignedTeams=" + this.assignedTeams + ", assignedUsers="
				+ this.assignedUsers + "]\n";
	}

}