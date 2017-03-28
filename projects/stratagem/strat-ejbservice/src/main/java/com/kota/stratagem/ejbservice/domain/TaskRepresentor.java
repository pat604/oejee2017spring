package com.kota.stratagem.ejbservice.domain;

public class TaskRepresentor {
	private final Long id;
	private final String description;
	private final double comlpetion;
	private final ProjectRepresentor project;

	public TaskRepresentor(Long id, String description, double completion, ProjectRepresentor project) {
		this.id = id;
		this.description = description;
		this.comlpetion = completion;
		this.project = project;
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public double getComlpetion() {
		return comlpetion;
	}

	public ProjectRepresentor getProject() {
		return project;
	}

	@Override
	public String toString() {
		return "TaskRepresentor [description=" + description + ", comlpetion=" + comlpetion + ", project=" + project + "]";
	}

}