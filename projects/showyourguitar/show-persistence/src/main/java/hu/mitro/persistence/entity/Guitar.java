package hu.mitro.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.mitro.persistence.parameter.GuitarParameter;
import hu.mitro.persistence.query.GuitarQuery;

@Entity
@Table(name = "guitar")
@NamedQueries(value = { //
		@NamedQuery(name = GuitarQuery.GET_BY_ID, query = "SELECT g FROM Guitar g WHERE g.id=:"
				+ GuitarParameter.ID),
		@NamedQuery(name = GuitarQuery.GET_BY_SERIALNUMBER, query = "SELECT g FROM Guitar g WHERE g.guitarSerialNumber=:"
				+ GuitarParameter.SERIALNUMBER),
		@NamedQuery(name = GuitarQuery.GET_ALL, query = "SELECT g FROM Guitar g ORDER BY g.guitarBrand") //
})
public class Guitar implements Serializable {

	@Id
	@SequenceGenerator(name = "generatorGuitar", sequenceName = "guitar_guitar_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorGuitar")
	@Column(name = "guitar_id", nullable = false)
	private Long id;

	@Column(name = "guitar_serialnumber", nullable = false)
	private String guitarSerialNumber;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "guitar_guitarbrand_id", nullable = false)
	private GuitarBrand guitarbrand;

	@Column(name = "guitar_type", nullable = false)
	private String guitartype;

	@Column(name = "guitar_color", nullable = false)
	private String guitarColor;

	@Column(name = "guitar_vintage", nullable = false)
	private int guitarVintage;

	@Column(name = "guitar_price", nullable = false)
	private double guitarPrice;

	@Column(name = "guitar_guitarowner_id", nullable = false)
	private GuitarOwner guitarOwner;

	public Guitar() {
		super();
	}

	public Guitar(Long id, String guitarSerialNumber, GuitarBrand guitarbrand, String guitartype,
			String guitarColor, int guitarVintage, double guitarPrice, GuitarOwner guitarOwner) {
		super();
		this.id = id;
		this.guitarSerialNumber = guitarSerialNumber;
		this.guitarbrand = guitarbrand;
		this.guitartype = guitartype;
		this.guitarColor = guitarColor;
		this.guitarVintage = guitarVintage;
		this.guitarPrice = guitarPrice;
		this.guitarOwner = guitarOwner;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGuitarSerialNumber() {
		return this.guitarSerialNumber;
	}

	public void setGuitarSerialNumber(String guitarSerialNumber) {
		this.guitarSerialNumber = guitarSerialNumber;
	}

	public GuitarBrand getGuitarbrand() {
		return this.guitarbrand;
	}

	public void setGuitarbrand(GuitarBrand guitarbrand) {
		this.guitarbrand = guitarbrand;
	}

	public String getGuitartype() {
		return this.guitartype;
	}

	public void setGuitartype(String guitartype) {
		this.guitartype = guitartype;
	}

	public String getGuitarColor() {
		return this.guitarColor;
	}

	public void setGuitarColor(String guitarColor) {
		this.guitarColor = guitarColor;
	}

	public int getGuitarVintage() {
		return this.guitarVintage;
	}

	public void setGuitarVintage(int guitarVintage) {
		this.guitarVintage = guitarVintage;
	}

	public double getGuitarPrice() {
		return this.guitarPrice;
	}

	public void setGuitarPrice(double guitarPrice) {
		this.guitarPrice = guitarPrice;
	}

	public GuitarOwner getGuitarOwner() {
		return this.guitarOwner;
	}

	public void setGuitarOwner(GuitarOwner guitarOwner) {
		this.guitarOwner = guitarOwner;
	}

	@Override
	public String toString() {
		return "Guitar [id=" + this.id + ", guitarSerialNumber=" + this.guitarSerialNumber
				+ ", guitarbrand=" + this.guitarbrand + ", guitartype=" + this.guitartype
				+ ", guitarColor=" + this.guitarColor + ", guitarVintage=" + this.guitarVintage
				+ ", guitarPrice=" + this.guitarPrice + ", guitarOwner=" + this.guitarOwner + "]";
	}

}
