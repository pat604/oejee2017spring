package com.kota.stratagem.ejbservice.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectRepresentor {
	private Long id;
	private final String name;
	private final String description;
	private final ProjectStatusRepresentor status;
	private final Date deadline;
	private final Boolean visible;
	private final List<TaskRepresentor> tasks;
	private final List<TeamRepresentor> assignedTeams;
	private final List<AppUserRepresentor> assignedUsers;
	private final List<ImpedimentRepresentor> impediments;
	private final ObjectiveRepresentor objective;

	public ProjectRepresentor() {
		this(null, "", "", ProjectStatusRepresentor.PROPOSED, new Date(), true, null, null, null, null, null);
	}

	public ProjectRepresentor(Long id, String name, String description, ProjectStatusRepresentor status, Date deadline, Boolean visible, List<TaskRepresentor> tasks,
			List<TeamRepresentor> assignedTeams, List<AppUserRepresentor> assignedUsers, List<ImpedimentRepresentor> impediments, ObjectiveRepresentor objective) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
		this.deadline = deadline;
		this.visible = visible;
		this.tasks = new ArrayList<>();
		this.assignedTeams = new ArrayList<>();
		this.assignedUsers = new ArrayList<>();
		this.impediments = new ArrayList<>();
		this.objective = objective;
	}

	public ProjectRepresentor(String name, String description, ProjectStatusRepresentor status, Date deadline, Boolean visible, List<TaskRepresentor> tasks, List<TeamRepresentor> assignedTeams,
			List<AppUserRepresentor> assignedUsers, List<ImpedimentRepresentor> impediments, ObjectiveRepresentor objective) {
		this.name = name;
		this.description = description;
		this.status = status;
		this.deadline = deadline;
		this.visible = visible;
		this.tasks = new ArrayList<>();
		this.assignedTeams = new ArrayList<>();
		this.assignedUsers = new ArrayList<>();
		this.impediments = new ArrayList<>();
		this.objective = objective;
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

	public ProjectStatusRepresentor getStatus() {
		return status;
	}

	public Date getDeadline() {
		return deadline;
	}

	public Boolean getVisible() {
		return visible;
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

	public List<ImpedimentRepresentor> getImpediments() {
		return impediments;
	}

	public void addImpediment(ImpedimentRepresentor impediment) {
		this.impediments.add(impediment);
	}

	public ObjectiveRepresentor getObjective() {
		return objective;
	}

	@Override
	public String toString() {
		return "ProjectRepresentor [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status + ", deadline=" + deadline + ", visible=" + visible + ", tasks=" + tasks
				+ ", assignedTeams=" + assignedTeams + ", assignedUsers=" + assignedUsers + ", impediments=" + impediments + ", objective=" + objective + "]";
	}

}