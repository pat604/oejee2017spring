package hu.gyigorpeter.anglerregistry.ejbservice.pojo;

public class Lake {

	private final long id;
	private final String waterCode;
	private final int size;
	private final int maxDepth;
	private String owner;
	private boolean anglerFarm;

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public boolean isAnglerFarm() {
		return this.anglerFarm;
	}

	public void setAnglerFarm(boolean anglerFarm) {
		this.anglerFarm = anglerFarm;
	}

	public long getId() {
		return this.id;
	}

	public String getWaterCode() {
		return this.waterCode;
	}

	public int getSize() {
		return this.size;
	}

	public int getMaxDepth() {
		return this.maxDepth;
	}

	public Lake(long id, String waterCode, int size, int maxDepth, String owner, boolean anglerFarm) {
		this.id = id;
		this.waterCode = waterCode;
		this.size = size;
		this.maxDepth = maxDepth;
		this.owner = owner;
		this.anglerFarm = anglerFarm;
	}

}
