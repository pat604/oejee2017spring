package hu.gyigorpeter.anglerregistry.ejbservice.pojo;

import java.util.Date;

public class Angler {

	private long id;
	private String name;
	private String mothersName;
	private Date birthDay;
	private String birthPlace;
	private int zipCode;
	private String city;
	private String address;
	private int socialWork;
	private Date banTime;
	private boolean isMember;

	public long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMothersName() {
		return this.mothersName;
	}

	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
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

	public boolean isIsMember() {
		return this.isMember;
	}

	public void setIsMember(boolean isMember) {
		this.isMember = isMember;
	}

	public Angler(long id, String name, String mothersName, Date birthDay, String birthPlace, int zipCode, String city, String address, int socialWork,
			Date banTime, boolean isMember) {
		this.id = id;
		this.name = name;
		this.mothersName = mothersName;
		this.birthDay = birthDay;
		this.birthPlace = birthPlace;
		this.zipCode = zipCode;
		this.city = city;
		this.address = address;
		this.socialWork = socialWork;
		this.banTime = banTime;
		this.isMember = isMember;
	}

}
