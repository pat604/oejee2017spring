package com.kota.stratagem.ejbservice.domain;

import com.kota.stratagem.ejbservice.domain.ProjectStatusRepresentor;

public class ProjectRepresentor {
	private final String name;
	private final ProjectStatusRepresentor status;
	
	public ProjectRepresentor(String name, ProjectStatusRepresentor status) {
		this.name = name;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public ProjectStatusRepresentor getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "ProjectRepresentor [name=" + name + ", status=" + status + "]";
	}
	
}