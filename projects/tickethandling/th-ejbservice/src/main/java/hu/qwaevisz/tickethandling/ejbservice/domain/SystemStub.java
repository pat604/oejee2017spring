package hu.qwaevisz.tickethandling.ejbservice.domain;

import java.util.Set;

public class SystemStub {

	private String id;
	private Set<ComponentStub> components;

	public SystemStub() {
		this("", null);
	}

	public SystemStub(String id, Set<ComponentStub> components) {
		super();
		this.id = id;
		this.components = components;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<ComponentStub> getComponents() {
		return this.components;
	}

	public void setComponents(Set<ComponentStub> components) {
		this.components = components;
	}

	@Override
	public String toString() {
		return "SystemStub [id=" + this.id + ", components=" + this.components + "]";
	}
}
