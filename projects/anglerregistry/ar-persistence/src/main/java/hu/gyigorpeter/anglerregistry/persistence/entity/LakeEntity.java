package hu.gyigorpeter.anglerregistry.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "lake")
public class LakeEntity implements Serializable {

	@Transient
	private static final long serialVersionUID = 49619221020832690L;

	@Id
	// @SequenceGenerator(name = " generatorHorgaszto", sequenceName = "lake_id_seq", allocationSize = 1)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorHorgaszto")
	@Column(name = "id", nullable = false)
	private long id;

	@Column(name = "vizterkod", nullable = false)
	private String waterCode;

	@Column(name = "terulet", nullable = false)
	private int size;

	@Column(name = "to_tipusa")
	private String toTipus;

	@Column(name = "legnagyobbvizmelyseg")
	private int maxDepth;

	@Column(name = "tulajdonos", nullable = false)
	private String owner;

	@Column(name = "horgasztanya", nullable = false)
	private boolean anglerFarm;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWaterCode() {
		return waterCode;
	}

	public void setWaterCode(String waterCode) {
		this.waterCode = waterCode;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getToTipus() {
		return toTipus;
	}

	public void setToTipus(String toTipus) {
		this.toTipus = toTipus;
	}

	public int getMaxDepth() {
		return maxDepth;
	}

	public void setMaxDepth(int maxDepth) {
		this.maxDepth = maxDepth;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public boolean isAnglerFarm() {
		return anglerFarm;
	}

	public void setAnglerFarm(boolean anglerFarm) {
		this.anglerFarm = anglerFarm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LakeEntity() {
		// TODO Auto-generated constructor stub
	}
	
}
