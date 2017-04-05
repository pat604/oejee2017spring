package com.kota.stratagem.ejbservice.domain;

import java.util.ArrayList;
import java.util.List;

public class ProjectRepresentor {
	private final Long id;
	private final String name;
	private final ProjectStatusRepresentor status;
	private final List<TaskRepresentor> tasks;
	private final Boolean visible;

	public ProjectRepresentor() {
		this(null, null, ProjectStatusRepresentor.PROPOSED, true);
	}

	public ProjectRepresentor(Long id, String name, ProjectStatusRepresentor status, Boolean visible) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.tasks = new ArrayList();
		this.visible = visible;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ProjectStatusRepresentor getStatus() {
		return status;
	}

	public List<TaskRepresentor> getTasks() {
		return tasks;
	}

	public void addTask(TaskRepresentor task) {
		tasks.add(task);
	}

	public Boolean getVisible() {
		return visible;
	}

	@Override
	public String toString() {
		return "ProjectRepresentor [id=" + id + ", name=" + name + ", status=" + status + ", tasks=" + tasks + ", visible=" + visible + "]";
	}

}