package hu.qwaevisz.tickethandling.ejbservice.domain;

public class EmployeeStub {

	private String id;
	private String name;
	private Integer level;
	private String email;

	public EmployeeStub() {
		this("", "", 0, "");
	}

	public EmployeeStub(String id, String name, Integer level, String email) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.email = email;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmployeeStub [id=" + this.id + ", name=" + this.name + ", level=" + this.level + ", email=" + this.email + "]";
	}
}
