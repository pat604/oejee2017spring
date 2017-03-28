package com.kota.stratagem.ejbservice.domain;

public enum ProjectStatusRepresentor {

	PROPOSED("Proposed"), PENDING("Pending"), INITIATED("Initiated"), UNDER_ANALYSIS("Under analysis"), IN_DESIGN("In design"), IN_DEVELOPMENT("In development"), CANCELED("Canceled"), TESTING(
			"Testing"), VALIDATING("Validating"), DEPLOYING("Deploying"), IMPLEMENTING(
					"Implementing"), INTEGRATING("Integrating"), LIVE("Live"), MAINTAINED_BY_OPERATIONS("Maintained by operations"), UPGRADING("Upgrading"), DISPOSED("Disposed");

	private final String label;

	private ProjectStatusRepresentor(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

	public String getName() {
		return this.name();
	}

}