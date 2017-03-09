package hu.gyigorpeter.anglerregistry.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "fish")
public class FishEntity implements Serializable {

	@Transient
	private static final long serialVersionUID = -2650585615626806254L;

	@Id
	// @SequenceGenerator(name = " generatorHal", sequenceName = "fish_id_seq", allocationSize = 1)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorHal")
	@Column(name = "id", nullable = false)
	private long id;

	@Column(name = "fishnev", nullable = false)
	private String fishName;

	@Column(name = "minimummeret")
	private int minimumSize;

	@Column(name = "napidarabszam", nullable = false)
	private int dailyCount;

	@Column(name = "tilalmiidoszakkezdete")
	@Temporal(TemporalType.DATE)
	private Date startEmbargoTime;

	@Temporal(TemporalType.DATE)
	@Column(name = "tilalmiidoszakvege")
	private Date endEmbargoTime;

	@Column(name = "pusztulas")
	private int destruction;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFishName() {
		return this.fishName;
	}

	public void setFishName(String fishName) {
		this.fishName = fishName;
	}

	public int getMinimumSize() {
		return this.minimumSize;
	}

	public void setMinimumSize(int minimumSize) {
		this.minimumSize = minimumSize;
	}

	public int getDailyCount() {
		return this.dailyCount;
	}

	public void setDailyCount(int dailyCount) {
		this.dailyCount = dailyCount;
	}

	public Date getStartEmbargoTime() {
		return this.startEmbargoTime;
	}

	public void setStartEmbargoTime(Date startEmbargoTime) {
		this.startEmbargoTime = startEmbargoTime;
	}

	public Date getEndEmbargoTime() {
		return this.endEmbargoTime;
	}

	public void setEndEmbargoTime(Date endEmbargoTime) {
		this.endEmbargoTime = endEmbargoTime;
	}

	public int getDestruction() {
		return this.destruction;
	}

	public void setDestruction(int destruction) {
		this.destruction = destruction;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public FishEntity() {
		// TODO Auto-generated constructor stub
	}
}
