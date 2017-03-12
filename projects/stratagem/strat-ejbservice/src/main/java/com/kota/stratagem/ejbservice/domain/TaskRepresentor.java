package com.kota.stratagem.ejbservice.domain;

public class TaskRepresentor {
	private final String description;
	private final double comlpetion;
	private final ProjectRepresentor project;
	
	public TaskRepresentor(String description, double completion, ProjectRepresentor project) {
		this.description = description;
		this.comlpetion = completion;
		this.project = project;
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