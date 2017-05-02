package com.kota.stratagem.ejbserviceclient.domain;

import java.util.ArrayList;
import java.util.List;

public class TeamRepresentor {
	private Long id;
	private final String name;
	private final AppUserRepresentor leader;
	private final List<AppUserRepresentor> members;
	private final List<ObjectiveRepresentor> objectives;
	private final List<ProjectRepresentor> projects;
	private final List<TaskRepresentor> tasks;

	public TeamRepresentor() {
		this(null, "", null);
	}

	public TeamRepresentor(Long id, String name, AppUserRepresentor leader) {
		this.id = id;
		this.name = name;
		this.leader = leader;
		this.members = new ArrayList<>();
		this.objectives = new ArrayList<>();
		this.projects = new ArrayList<>();
		this.tasks = new ArrayList<>();
	}

	public TeamRepresentor(String name, AppUserRepresentor leader) {
		this.name = name;
		this.leader = leader;
		this.members = new ArrayList<>();
		this.objectives = new ArrayList<>();
		this.projects = new ArrayList<>();
		this.tasks = new ArrayList<>();
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

	public AppUserRepresentor getLeader() {
		return leader;
	}

	public List<AppUserRepresentor> getMembers() {
		return members;
	}

	public void addMember(AppUserRepresentor user) {
		this.members.add(user);
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

	@Override
	public String toString() {
		return "TeamRepresentor [id=" + id + ", name=" + name + ", leader=" + leader + ", members=" + members + ", objectives=" + objectives + ", projects=" + projects + ", tasks=" + tasks + "]";
	}

}
