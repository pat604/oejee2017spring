package hu.gyigorpeter.anglerregistry.ejbservice.pojo;

import java.sql.Date;

public class Fish {

	private final long id;
	private String fishName;
	private int minimumSize;
	private int dailyCount;
	private Date startEmbargoTime;
	private Date endEmbargoTime;
	private int destruction;

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

	public long getId() {
		return this.id;
	}

	public Fish(long id, String fishName, int minimumSize, int dailyCount, Date startEmbargoTime, Date endEmbargoTime, int destruction) {
		this.id = id;
		this.fishName = fishName;
		this.minimumSize = minimumSize;
		this.dailyCount = dailyCount;
		this.startEmbargoTime = startEmbargoTime;
		this.endEmbargoTime = endEmbargoTime;
		this.destruction = destruction;
	}

}
