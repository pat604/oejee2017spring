package hu.mitro.domain;

public class GuitarStub {

	private Long guitarId;
	private GuitarBrandStub guitarbrand;
	private String guitarType;
	private String color;
	private int vintage;
	private double price;
	private GuitarOwnerStub owner;

	public GuitarStub(Long guitarId, GuitarBrandStub guitarbrand, String guitarType, String color,
			int vintage, double price, GuitarOwnerStub owner) {
		super();
		this.guitarId = guitarId;
		this.guitarbrand = guitarbrand;
		this.guitarType = guitarType;
		this.color = color;
		this.vintage = vintage;
		this.price = price;
		this.owner = owner;
	}

	public Long getGuitarId() {
		return this.guitarId;
	}

	public void setGuitarId(Long guitarId) {
		this.guitarId = guitarId;
	}

	public GuitarBrandStub getGuitarbrand() {
		return this.guitarbrand;
	}

	public void setGuitarbrand(GuitarBrandStub guitarbrand) {
		this.guitarbrand = guitarbrand;
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

	public int getVintage() {
		return this.vintage;
	}

	public void setVintage(int vintage) {
		this.vintage = vintage;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public GuitarOwnerStub getOwner() {
		return this.owner;
	}

	public void setOwner(GuitarOwnerStub owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "GuitarStub [guitarId=" + this.guitarId + ", guitarbrand=" + this.guitarbrand
				+ ", guitarType=" + this.guitarType + ", color=" + this.color + ", vintage="
				+ this.vintage + ", price=" + this.price + ", owner=" + this.owner + "]";
	}

}
