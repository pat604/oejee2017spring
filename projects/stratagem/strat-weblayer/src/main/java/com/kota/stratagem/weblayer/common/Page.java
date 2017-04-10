package com.kota.stratagem.weblayer.common;

public enum Page {

	LOGIN("login.jsp", "Login"), //
	ERROR("error.jsp", "Error"), // 
	PROJECT_LIST("/project/project-list.jsp", "ProjectList"), //
	PROJECT_VIEW("/project/project-detail.jsp", "Project"), //
	PROJECT_EDIT("/project/project-edit.jsp", "Project"); //

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
