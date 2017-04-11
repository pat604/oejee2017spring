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
		this(null, "", "", 10, ObjectiveStatusRepresentor.PLANNED, null, null, null, null);
	}

	public ObjectiveRepresentor(Long id, String name, String description, int priority, ObjectiveStatusRepresentor status, List<ProjectRepresentor> projects, List<TaskRepresentor> tasks,
			List<TeamRepresentor> assignedTeams, List<AppUserRepresentor> assignedUsers) {
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

	public ObjectiveRepresentor(String name, String description, int priority, ObjectiveStatusRepresentor status, List<ProjectRepresentor> projects, List<TaskRepresentor> tasks,
			List<TeamRepresentor> assignedTeams, List<AppUserRepresentor> assignedUsers) {
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

	public int getPriority() {
		return priority;
	}

	public ObjectiveStatusRepresentor getStatus() {
		return status;
	}

	public List<ProjectRepresentor> getProjects() {
		return projects;
	}

	public void addProject(ProjectRepresentor project) {
		this.projects.add(project);
	}

	public List<TaskRepresentor> getTasks() {
		return tasks;
	}

	public void addTask(TaskRepresentor task) {
		this.tasks.add(task);
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

	@Override
	public String toString() {
		return "ObjectiveRepresentor [id=" + id + ", name=" + name + ", description=" + description + ", priority=" + priority + ", status=" + status + ", projects=" + projects + ", tasks=" + tasks
				+ ", assignedTeams=" + assignedTeams + ", assignedUsers=" + assignedUsers + "]";
	}

}
