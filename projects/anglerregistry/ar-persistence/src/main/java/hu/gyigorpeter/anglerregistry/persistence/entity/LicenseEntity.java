package hu.gyigorpeter.anglerregistry.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "engedely")
public class LicenseEntity implements Serializable {

	@Transient
	private static final long serialVersionUID = -5767572163046328854L;

	@Id
	// @SequenceGenerator(name = " generatorEngedely", sequenceName = "engedely_id_seq", allocationSize = 1)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorEngedely")
	@Column(name = "id", nullable = false)
	private long id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "horgaszid", referencedColumnName = "id", nullable = false)
	private AnglerEntity anglerEntity;

	@Column(name = "allamijegyid")
	private String nationalTicketId;

	@Column(name = "engedely_tipusa")
	private String licenseType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public AnglerEntity getAnglerEntity() {
		return anglerEntity;
	}

	public void setAnglerEntity(AnglerEntity anglerEntity) {
		this.anglerEntity = anglerEntity;
	}

	public String getNationalTicketId() {
		return nationalTicketId;
	}

	public void setNationalTicketId(String nationalTicketId) {
		this.nationalTicketId = nationalTicketId;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public LicenseEntity() {
		// TODO Auto-generated constructor stub
	}

}
