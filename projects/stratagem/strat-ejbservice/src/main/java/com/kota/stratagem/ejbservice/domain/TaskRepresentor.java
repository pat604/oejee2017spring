package com.kota.stratagem.ejbservice.domain;

public class TaskRepresentor {
	private final Long id;
	private final String name;
	private final String description;
	private final double comlpetion;

	public TaskRepresentor(Long id, String name, String description, double completion) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.comlpetion = completion;
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

	@Override
	public String toString() {
		return "TaskRepresentor [id=" + id + ", name=" + name + ", description=" + description + ", comlpetion=" + comlpetion + "]";
	}

}