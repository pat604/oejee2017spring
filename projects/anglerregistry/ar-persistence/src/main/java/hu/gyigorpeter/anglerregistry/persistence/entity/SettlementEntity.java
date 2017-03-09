package hu.gyigorpeter.anglerregistry.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "telepites")
public class SettlementEntity implements Serializable {

	@Transient
	private static final long serialVersionUID = -1225740194904957262L;

	@Id
	// @SequenceGenerator(name = " generatorTelepites", sequenceName = "telepites_id_seq", allocationSize = 1)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorTelepites")
	@Column(name = "id", nullable = false)
	private long id;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = LakeEntity.class)
	@JoinColumn(name = "toid", referencedColumnName = "id", nullable = false)
	private Set<LakeEntity> lakeEntity;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = FishEntity.class)
	@JoinColumn(name = "halid", referencedColumnName = "id", nullable = false)
	private Set<FishEntity> fishEntity;

	@Column(name = "datum")
	private Date date;

	@Column(name = "kor")
	private int age;

	@Column(name = "mennyiseg")
	private int quantity;

	@Column(name = "tilalminapokszama")
	private int numberOfEmbargoDays;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<LakeEntity> getLakeEntity() {
		return lakeEntity;
	}

	public void setLakeEntity(Set<LakeEntity> lakeEntity) {
		this.lakeEntity = lakeEntity;
	}

	public Set<FishEntity> getFishEntity() {
		return fishEntity;
	}

	public void setFishEntity(Set<FishEntity> fishEntity) {
		this.fishEntity = fishEntity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getNumberOfEmbargoDays() {
		return numberOfEmbargoDays;
	}

	public void setNumberOfEmbargoDays(int numberOfEmbargoDays) {
		this.numberOfEmbargoDays = numberOfEmbargoDays;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
public SettlementEntity() {
	// TODO Auto-generated constructor stub
}
}
