package hu.gyigorpeter.anglerregistry.ejbservice.pojo;

import java.util.Date;

public class Settlement {

	private final long id;
	private final Lake lake;
	private final Fish fish;
	private final Date date;
	private final int age;
	private final int quantity;
	private final int numberOfEmbargoDays;

	public long getId() {
		return id;
	}


	public Lake getLake() {
		return lake;
	}


	public Fish getFish() {
		return fish;
	}


	public Date getDate() {
		return date;
	}


	public int getAge() {
		return age;
	}


	public int getQuantity() {
		return quantity;
	}


	public int getNumberOfEmbargoDays() {
		return numberOfEmbargoDays;
	}


	public Settlement(long id, Lake lake, Fish fish, Date date, int age, int quantity, int numberOfEmbargoDays) {
		this.id = id;
		this.lake = lake;
		this.fish = fish;
		this.date = date;
		this.age = age;
		this.quantity = quantity;
		this.numberOfEmbargoDays = numberOfEmbargoDays;
	}
}
