package hu.gyigorpeter.anglerregistry.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import hu.gyigorpeter.anglerregistry.persistence.query.AnglerQuery;

@Entity
@Table(name = "horgasz")
@NamedQueries(value = { @NamedQuery(name = AnglerQuery.GET_BY_ID, query = "SELECT angler FROM AnglerEntity angler WHERE angler.id=:id"),
		@NamedQuery(name = AnglerQuery.GET_ALL, query = "SELECT angler FROM AnglerEntity angler ORDER BY angler.name") })
public class AnglerEntity implements Serializable {

	@Transient
	private static final long serialVersionUID = -4705781742838571940L;

	@Id
	// @SequenceGenerator(name = " generatorHorgasz", sequenceName = "horgasz_id_seq", allocationSize = 1)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorHorgasz")
	@Column(name = "id", nullable = false)
	private long id;

	@Column(name = "nev", nullable = false)
	private String name;

	@Column(name = "anyjaneve", nullable = false)
	private String motherName;

	@Column(name = "szuletesiido", nullable = false)
	private Date birthDay;

	@Column(name = "szuletesihely", nullable = false)
	private String birthPlace;

	@Column(name = "irsz")
	private int zipCode;

	@Column(name = "varos")
	private String city;

	@Column(name = "cim")
	private String address;

	@Column(name = "tarsadalmimunka")
	private int socialWork;

	@Column(name = "eltiltas")
	@Temporal(TemporalType.DATE)
	private Date banTime;

	@Column(name = "tage", nullable = false)
	private boolean isMember;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Date getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getBirthPlace() {
		return this.birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public int getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSocialWork() {
		return this.socialWork;
	}

	public void setSocialWork(int socialWork) {
		this.socialWork = socialWork;
	}

	public Date getBanTime() {
		return this.banTime;
	}

	public void setBanTime(Date banTime) {
		this.banTime = banTime;
	}

	public boolean isMember() {
		return this.isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
