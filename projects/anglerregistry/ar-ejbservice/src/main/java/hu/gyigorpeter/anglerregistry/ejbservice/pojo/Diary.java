package hu.gyigorpeter.anglerregistry.ejbservice.pojo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Diary {

	private final long id;
	private final License license;
	private final List<Lake> lake;
	private final Timestamp timestamp;
	private final List<Fish> fish;
	private final int quantity;

	public long getId() {
		return this.id;
	}

	public License getLicense() {
		return this.license;
	}

	public List<Lake> getLake() {
		return this.lake;
	}

	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	public List<Fish> getFish() {
		return this.fish;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public Diary(long id, License license, Timestamp timestamp, int quantity) {
		this.id = id;
		this.license = license;
		this.lake = new ArrayList<Lake>();
		this.timestamp = timestamp;
		this.fish = new ArrayList<Fish>();
		this.quantity = quantity;
	}

}
