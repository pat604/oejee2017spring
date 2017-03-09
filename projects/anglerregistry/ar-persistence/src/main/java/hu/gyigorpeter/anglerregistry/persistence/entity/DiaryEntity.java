package hu.gyigorpeter.anglerregistry.persistence.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "fogasinaplo")
public class DiaryEntity implements Serializable {

	@Transient
	private static final long serialVersionUID = -3406588429003984346L;

	@Id
	// @SequenceGenerator(name = " generatorFogasiNaplo", sequenceName = "fogasinaplo_id_seq", allocationSize = 1)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorFogasiNaplo")
	@Column(name = "id", nullable = false)
	private long id;

	@OneToOne(fetch = FetchType.EAGER)
	// @JoinColumn(name = "engedelyid", referencedColumnName = "id", nullable = false)
	private LicenseEntity licenseEntity;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = LakeEntity.class)
	// @JoinColumn(name = "toid", referencedColumnName = "id", nullable = false)
	private Set<LakeEntity> lakeEntity;

	@Column(name = "idopont")
	private Timestamp timestamp;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = FishEntity.class)
	@JoinColumn(name = "fishid", referencedColumnName = "id", nullable = false)
	private FishEntity fishEntity;

	@Column(name = "mennyiseg")
	private int quantity;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LicenseEntity getLicenseEntity() {
		return licenseEntity;
	}

	public void setLicenseEntity(LicenseEntity licenseEntity) {
		this.licenseEntity = licenseEntity;
	}

	public Set<LakeEntity> getLakeEntity() {
		return lakeEntity;
	}

	public void setLakeEntity(Set<LakeEntity> lakeEntity) {
		this.lakeEntity = lakeEntity;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public FishEntity getFishEntity() {
		return fishEntity;
	}

	public void setFishEntity(FishEntity fishEntity) {
		this.fishEntity = fishEntity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
public DiaryEntity() {
	// TODO Auto-generated constructor stub
}

}
