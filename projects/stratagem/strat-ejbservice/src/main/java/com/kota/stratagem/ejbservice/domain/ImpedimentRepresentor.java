package com.kota.stratagem.ejbservice.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImpedimentRepresentor {
	private Long id;
	private final String name;
	private final String description;
	private final PriorityRepresentor priority;
	private final ImpedimentStatusRepresentor status;
	private final Date reportDate;
	private final AppUserRepresentor reporter;
	private final AppUserRepresentor processor;
	private final List<RemedyRepresentor> remedies;
	private final ProjectRepresentor project;
	private final TaskRepresentor task;

	public ImpedimentRepresentor() {
		this(null, "", "", PriorityRepresentor.MEDIUM, ImpedimentStatusRepresentor.OPEN, new Date(), null, null, null, null);
	}

	public ImpedimentRepresentor(Long id, String name, String description, PriorityRepresentor priority, ImpedimentStatusRepresentor status, Date reportDate, AppUserRepresentor reporter,
			AppUserRepresentor processor, ProjectRepresentor project, TaskRepresentor task) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.status = status;
		this.reportDate = reportDate;
		this.reporter = reporter;
		this.processor = processor;
		this.remedies = new ArrayList<>();
		this.project = project;
		this.task = task;
	}

	public ImpedimentRepresentor(String name, String description, PriorityRepresentor priority, ImpedimentStatusRepresentor status, Date reportDate, AppUserRepresentor reporter,
			AppUserRepresentor processor, ProjectRepresentor project, TaskRepresentor task) {
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.status = status;
		this.reportDate = reportDate;
		this.reporter = reporter;
		this.processor = processor;
		this.remedies = new ArrayList<>();
		this.project = project;
		this.task = task;
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

	public String getDescription() {
		return description;
	}

	public PriorityRepresentor getPriority() {
		return priority;
	}

	public ImpedimentStatusRepresentor getStatus() {
		return status;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public AppUserRepresentor getReporter() {
		return reporter;
	}

	public AppUserRepresentor getProcessor() {
		return processor;
	}

	public List<RemedyRepresentor> getRemedies() {
		return remedies;
	}

	public void addRemedy(RemedyRepresentor remedy) {
		this.remedies.add(remedy);
	}

	public ProjectRepresentor getProject() {
		return project;
	}

	public TaskRepresentor getTask() {
		return task;
	}

	@Override
	public String toString() {
		return "ImpedimentRepresentor [id=" + id + ", name=" + name + ", description=" + description + ", priority=" + priority + ", status=" + status + ", reportDate=" + reportDate + ", reporter="
				+ reporter + ", processor=" + processor + ", remedies=" + remedies + ", project=" + project + ", task=" + task + "]";
	}

}
