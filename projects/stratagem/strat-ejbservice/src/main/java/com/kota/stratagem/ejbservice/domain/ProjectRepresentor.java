package com.kota.stratagem.ejbservice.domain;

public class ProjectRepresentor {
	private final Long id;
	private final String name;
	private final ProjectStatusRepresentor status;
	private final Boolean visible;

	public ProjectRepresentor() {
		this(null, null, ProjectStatusRepresentor.PROPOSED, true);
	}

	public ProjectRepresentor(Long id, String name, ProjectStatusRepresentor status, Boolean visible) {
		this.id = id;
		this.name = name;
		this.status = status;
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

	public Boolean getVisible() {
		return visible;
	}

	@Override
	public String toString() {
		return "ProjectRepresentor [name=" + name + ", status=" + status + ", visible=" + visible + "]";
	}

}