package hu.mitro.ejbservice.domain;

public class GuitarOwnerUpdateStub {

	private String serialNumber;
	private String newOwnerName;

	public GuitarOwnerUpdateStub() {
	}

	public GuitarOwnerUpdateStub(String serialNumber, String newOwnerName) {
		super();
		this.serialNumber = serialNumber;
		this.newOwnerName = newOwnerName;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getNewOwnerName() {
		return this.newOwnerName;
	}

	public void setNewOwnerName(String newOwnerName) {
		this.newOwnerName = newOwnerName;
	}

}
