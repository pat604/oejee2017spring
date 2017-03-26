package hu.mitro.domain;

public class GuitarOwnerStub {

	private Long ownerId;
	private String username;
	private String email;
	private String password;

	public GuitarOwnerStub(Long ownerId, String username, String email, String password) {
		super();
		this.ownerId = ownerId;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Long getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "GuitarOwnerStub [ownerId=" + this.ownerId + ", username=" + this.username
				+ ", email=" + this.email + ", password=" + this.password + "]";
	}

}
