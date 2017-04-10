package com.kota.stratagem.ejbservice.domain;

import java.util.ArrayList;
import java.util.List;

public class AppUserRepresentor {

	private Long id;
	private final String name;
	private final String passwordHash;
	private final String email;
	private final RoleRepresentor role;
	private final List<ProjectRepresentor> projects;

	public AppUserRepresentor() {
		this(null, "", "", "", RoleRepresentor.PRISTINE_USER);
	}

	public AppUserRepresentor(String name, String passwordHash, String email, RoleRepresentor role) {
		this.name = name;
		this.passwordHash = passwordHash;
		this.email = email;
		this.role = role;
		this.projects = new ArrayList<>();
	}

	public AppUserRepresentor(Long id, String name, String passwordHash, String email, RoleRepresentor role) {
		this.id = id;
		this.name = name;
		this.passwordHash = passwordHash;
		this.email = email;
		this.role = role;
		this.projects = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public String getEmail() {
		return email;
	}

	public RoleRepresentor getRole() {
		return role;
	}

	public List<ProjectRepresentor> getProjects() {
		return projects;
	}

	public void addProject(ProjectRepresentor project) {
		this.projects.add(project);
	}

	@Override
	public String toString() {
		return "AppUserRepresentor [id=" + id + ", name=" + name + ", passwordHash=" + passwordHash + ", email=" + email + ", role=" + role + ", projects=" + projects + "]";
	}

}
