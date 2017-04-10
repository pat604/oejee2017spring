package com.kota.stratagem.ejbservice.domain;

import java.util.ArrayList;
import java.util.List;

public class ProjectRepresentor {
	private Long id;
	private final String name;
	private final String description;
	private final ProjectStatusRepresentor status;
	private final List<TaskRepresentor> tasks;
	private final Boolean visible;

	public ProjectRepresentor() {
		this(null, "", "", ProjectStatusRepresentor.PROPOSED, true);
	}

	public ProjectRepresentor(Long id, String name, String description, ProjectStatusRepresentor status, Boolean visible) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
		this.tasks = new ArrayList<>();
		this.visible = visible;
	}

	public ProjectRepresentor(String name, String description, ProjectStatusRepresentor status, Boolean visible) {
		this.name = name;
		this.description = description;
		this.status = status;
		this.tasks = new ArrayList<>();
		this.visible = visible;
	}

	public Long getId() {
		return id;
	}

	public String getStringId() {
		return id.toString();
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
		return "ProjectRepresentor [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status + ", tasks=" + tasks + ", visible=" + visible + "]";
	}

}