package hu.mitro.ejbservice.domain;

public class GuitarInputStub {

	private String guitarBrand;
	private String guitarType;
	private String color;
	private String serialNumber;
	private Integer vintage;
	private double price;
	private String owner;

	public GuitarInputStub() {
	}

	public GuitarInputStub(String guitarBrand, String guitarType, String color, String serialNumber, Integer vintage,
			double price, String owner) {
		super();
		this.guitarBrand = guitarBrand;
		this.guitarType = guitarType;
		this.color = color;
		this.serialNumber = serialNumber;
		this.vintage = vintage;
		this.price = price;
		this.owner = owner;
	}

	public String getGuitarBrand() {
		return this.guitarBrand;
	}

	public void setGuitarBrand(String guitarBrand) {
		this.guitarBrand = guitarBrand;
	}

	public String getGuitarType() {
		return this.guitarType;
	}

	public void setGuitarType(String guitarType) {
		this.guitarType = guitarType;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Integer getVintage() {
		return this.vintage;
	}

	public void setVintage(Integer vintage) {
		this.vintage = vintage;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "GuitarInputStub [guitarBrand=" + this.guitarBrand + ", guitarType=" + this.guitarType + ", color="
				+ this.color + ", serialNumber=" + this.serialNumber + ", vintage=" + this.vintage + ", price="
				+ this.price + ", owner=" + this.owner + "]";
	}

}
