package hu.mitro.persistence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "guitarowner")
public class GuitarOwner implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "guitarowner_id", nullable = false)
	private Long ownerId;

	@Column(name = "guitarowner_username", nullable = false)
	private String ownerUsername;

	@Column(name = "guitarowner_email", nullable = false)
	private String ownerEmail;

	@Column(name = "guitarowner_password", nullable = false)
	private String ownerPassword;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Guitar.class, mappedBy = "guitarOwner")
	// @JoinColumn(name = "guitarowner_guitar_id", referencedColumnName = "guitar_guitarowner_id")
	private List<Guitar> guitars = new ArrayList<Guitar>();

	public GuitarOwner() {
		super();
	}

	public GuitarOwner(Long ownerId, String ownerUsername, String ownerEmail, String ownerPassword,
			List<Guitar> guitars) {
		super();
		this.ownerId = ownerId;
		this.ownerUsername = ownerUsername;
		this.ownerEmail = ownerEmail;
		this.ownerPassword = ownerPassword;
		this.guitars = guitars;
	}

	public Long getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerUsername() {
		return this.ownerUsername;
	}

	public void setOwnerUsername(String ownerUsername) {
		this.ownerUsername = ownerUsername;
	}

	public String getOwnerEmail() {
		return this.ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getOwnerPassword() {
		return this.ownerPassword;
	}

	public void setOwnerPassword(String ownerPassword) {
		this.ownerPassword = ownerPassword;
	}

	public List<Guitar> getGuitars() {
		return this.guitars;
	}

	public void setGuitars(List<Guitar> guitars) {
		this.guitars = guitars;
	}

	@Override
	public String toString() {
		return "GuitarOwner [ownerId=" + this.ownerId + ", ownerUsername=" + this.ownerUsername + ", ownerEmail="
				+ this.ownerEmail + ", ownerPassword=" + this.ownerPassword + ", guitars=" + this.guitars + "]";
	}

}
