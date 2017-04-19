package com.kota.stratagem.ejbservice.domain;

import java.util.Date;

public class RemedyRepresentor {
	private Long id;
	private final String description;
	private final ImpedimentRepresentor impediment;
	private final Date submissionDate;
	private final AppUserRepresentor provider;

	public RemedyRepresentor() {
		this(null, "", null, new Date(), null);
	}

	public RemedyRepresentor(Long id, String description, ImpedimentRepresentor impediment, Date submissionDate, AppUserRepresentor provider) {
		this.id = id;
		this.description = description;
		this.impediment = impediment;
		this.submissionDate = submissionDate;
		this.provider = provider;
	}

	public RemedyRepresentor(String description, ImpedimentRepresentor impediment, Date submissionDate, AppUserRepresentor provider) {
		this.description = description;
		this.impediment = impediment;
		this.submissionDate = submissionDate;
		this.provider = provider;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public ImpedimentRepresentor getImpediment() {
		return impediment;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public AppUserRepresentor getProvider() {
		return provider;
	}

	@Override
	public String toString() {
		return "RemedyRepresentor [id=" + id + ", description=" + description + ", impediment=" + impediment + ", submissionDate=" + submissionDate + ", provider=" + provider + "]";
	}

}
