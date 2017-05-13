package hu.mitro.ejbservice.domain;

public class GuitarPriceUpdateStub {

	private String serialNumber;
	private double newPrice;

	public GuitarPriceUpdateStub() {
	}

	public GuitarPriceUpdateStub(String serialNumber, double newPrice) {
		this.serialNumber = serialNumber;
		this.newPrice = newPrice;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public double getNewPrice() {
		return this.newPrice;
	}

	public void setNewPrice(double newPrice) {
		this.newPrice = newPrice;
	}

}
