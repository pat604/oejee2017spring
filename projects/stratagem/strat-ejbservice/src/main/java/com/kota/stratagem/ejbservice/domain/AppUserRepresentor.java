package com.kota.stratagem.ejbservice.domain;

import java.util.ArrayList;
import java.util.List;

public class AppUserRepresentor {

	private Long id;
	private final String name;
	private final String passwordHash;
	private final String email;
	private final RoleRepresentor role;
	private final List<ObjectiveRepresentor> objectives;
	private final List<ProjectRepresentor> projects;
	private final List<TaskRepresentor> tasks;
	private final List<ImpedimentRepresentor> reportedImpediments;
	private final List<ImpedimentRepresentor> processedImpediments;
	private final List<TeamRepresentor> supervisedTeams;
	private final List<TeamRepresentor> teamMemberships;

	public AppUserRepresentor() {
		this(null, "", "", "", RoleRepresentor.PRISTINE_USER, null, null, null, null, null, null, null);
	}

	public AppUserRepresentor(Long id, String name, String passwordHash, String email, RoleRepresentor role, List<ObjectiveRepresentor> objectives, List<ProjectRepresentor> projects,
			List<TaskRepresentor> tasks, List<ImpedimentRepresentor> reportedImpediments, List<ImpedimentRepresentor> processedImpediments, List<TeamRepresentor> supervisedTeams,
			List<TeamRepresentor> teamMemberships) {
		this.id = id;
		this.name = name;
		this.passwordHash = passwordHash;
		this.email = email;
		this.role = role;
		this.objectives = new ArrayList<>();
		this.projects = new ArrayList<>();
		this.tasks = new ArrayList<>();
		this.reportedImpediments = new ArrayList<>();
		this.processedImpediments = new ArrayList<>();
		this.supervisedTeams = new ArrayList<>();
		this.teamMemberships = new ArrayList<>();
	}

	public AppUserRepresentor(String name, String passwordHash, String email, RoleRepresentor role, List<ObjectiveRepresentor> objectives, List<ProjectRepresentor> projects,
			List<TaskRepresentor> tasks, List<ImpedimentRepresentor> reportedImpediments, List<ImpedimentRepresentor> processedImpediments, List<TeamRepresentor> supervisedTeams,
			List<TeamRepresentor> teamMemberships) {
		this.name = name;
		this.passwordHash = passwordHash;
		this.email = email;
		this.role = role;
		this.objectives = new ArrayList<>();
		this.projects = new ArrayList<>();
		this.tasks = new ArrayList<>();
		this.reportedImpediments = new ArrayList<>();
		this.processedImpediments = new ArrayList<>();
		this.supervisedTeams = new ArrayList<>();
		this.teamMemberships = new ArrayList<>();
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

	public String getPasswordHash() {
		return passwordHash;
	}

	public String getEmail() {
		return email;
	}

	public RoleRepresentor getRole() {
		return role;
	}

	public List<ObjectiveRepresentor> getObjectives() {
		return objectives;
	}

	public void addObjective(ObjectiveRepresentor objective) {
		this.objectives.add(objective);
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

	public List<ImpedimentRepresentor> getReportedImpediments() {
		return reportedImpediments;
	}

	public void addReportedImpediment(ImpedimentRepresentor impediment) {
		this.reportedImpediments.add(impediment);
	}

	public List<ImpedimentRepresentor> getProcessedImpediments() {
		return processedImpediments;
	}

	public void addProcessingImpediment(ImpedimentRepresentor impediment) {
		this.processedImpediments.add(impediment);
	}

	public List<TeamRepresentor> getSupervisedTeams() {
		return supervisedTeams;
	}

	public void addSupervisedTeam(TeamRepresentor team) {
		this.supervisedTeams.add(team);
	}

	public List<TeamRepresentor> getTeamMemberships() {
		return teamMemberships;
	}

	public void addTeamMembership(TeamRepresentor team) {
		this.teamMemberships.add(team);
	}

	@Override
	public String toString() {
		return "AppUserRepresentor [id=" + id + ", name=" + name + ", passwordHash=" + passwordHash + ", email=" + email + ", role=" + role + ", objectives=" + objectives + ", projects=" + projects
				+ ", tasks=" + tasks + ", reportedImpediments=" + reportedImpediments + ", processedImpediments=" + processedImpediments + ", supervisedTeams=" + supervisedTeams + ", teamMemberships="
				+ teamMemberships + "]";
	}

}
