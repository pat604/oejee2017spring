package hu.qwaevisz.tickethandling.ejbserviceclient.domain;

import java.io.Serializable;

public class ComponentStub implements Serializable {

	private static final long serialVersionUID = 4743633315322604281L;

	private String id;
	private String description;

	public ComponentStub() {
		this("", "");
	}

	public ComponentStub(String id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ComponentStub [id=" + this.id + ", description=" + this.description + "]";
	}
}
