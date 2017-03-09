package hu.gyigorpeter.anglerregistry.ejbservice.pojo;

public class License {

	private final long id;
	private Angler angler;
	private final String nationalTicketId;
	private final String licenseType;

	public License(long id, Angler angler, String nationalTicketId, String licenseType) {
		this.id = id;
		this.angler = angler;
		this.nationalTicketId = nationalTicketId;
		this.licenseType = licenseType;

	}

	public long getId() {
		return id;
	}

	public Angler getAngler() {
		return angler;
	}

	public void setAngler(Angler angler) {
		this.angler = angler;
	}

	public String getNationalTicketId() {
		return nationalTicketId;
	}

	public String getLicenseType() {
		return licenseType;
	}

	
}
