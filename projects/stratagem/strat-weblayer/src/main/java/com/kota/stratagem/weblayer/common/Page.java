package com.kota.stratagem.weblayer.common;

public enum Page {

	HOME("home.jsp", "Home"), //
	ERROR("error.jsp", "Error"), //
	OBJECTIVE_LIST("/control/objective/objective-list.jsp", "ObjectiveList"), //
	OBJECTIVE_VIEW("/control/objective/objective-detail.jsp", "Objective"), //
	OBJECTIVE_EDIT("/control/objective/objective-edit.jsp", "Objective"), //
	PROJECT_LIST("/control/project/project-list.jsp", "ProjectList"), //
	PROJECT_VIEW("/control/project/project-detail.jsp", "Project"), //
	PROJECT_EDIT("/control/project/project-edit.jsp", "Project"); //

	private final String jspName;
	private final String url;

	public String getJspName() {
		return this.jspName;
	}

	public String getUrl() {
		return this.url;
	}

	private Page(final String jspName, final String url) {
		this.jspName = jspName;
		this.url = url;
	}
}
