package hu.qwaevisz.tickethandling.ejbservice.domain;

public class ComponentStub {

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
