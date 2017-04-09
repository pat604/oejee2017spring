package hu.mitro.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "guitarowner_guitar_id", referencedColumnName = "guitar_id", nullable = false)
	private Guitar guitarOfOwner;

	public GuitarOwner() {
		super();
	}

	public GuitarOwner(Long ownerId, String ownerUsername, String ownerEmail, String ownerPassword,
			Guitar guitarOfOwner) {
		super();
		this.ownerId = ownerId;
		this.ownerUsername = ownerUsername;
		this.ownerEmail = ownerEmail;
		this.ownerPassword = ownerPassword;
		this.guitarOfOwner = guitarOfOwner;
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

	public Guitar getGuitarOfOwner() {
		return this.guitarOfOwner;
	}

	public void setGuitarOfOwner(Guitar guitarOfOwner) {
		this.guitarOfOwner = guitarOfOwner;
	}

	@Override
	public String toString() {
		return "GuitarOwner [ownerId=" + this.ownerId + ", ownerUsername=" + this.ownerUsername + ", ownerEmail="
				+ this.ownerEmail + ", ownerPassword=" + this.ownerPassword + ", guitarOfOwner=" + this.guitarOfOwner
				+ "]";
	}

}
