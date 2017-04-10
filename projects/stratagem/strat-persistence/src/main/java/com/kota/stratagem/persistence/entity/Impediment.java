package com.kota.stratagem.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.kota.stratagem.persistence.entity.trunk.ImpedimentStatus;
import com.kota.stratagem.persistence.entity.trunk.Priority;
import com.kota.stratagem.persistence.parameter.ImpedimentParameter;
import com.kota.stratagem.persistence.query.ImpedimentQuery;

@Entity
@Table(name = "impediments")
@NamedQueries(value = { //
		@NamedQuery(name = ImpedimentQuery.COUNT_BY_ID, query = "SELECT COUNT(i) FROM Impediment i WHERE i.id=:" + ImpedimentParameter.ID),
		@NamedQuery(name = ImpedimentQuery.GET_ALL_IMPEDIMENTS, query = "SELECT i FROM Impediment i ORDER BY i.name"),
		@NamedQuery(name = ImpedimentQuery.GET_BY_ID, query = "SELECT i FROM Impediment i WHERE i.id=:" + ImpedimentParameter.ID),
		@NamedQuery(name = ImpedimentQuery.REMOVE_BY_ID, query = "DELETE FROM Impediment i WHERE i.id=:" + ImpedimentParameter.ID)
		//
})
@SequenceGenerator(name = "impedimentGenerator", sequenceName = "impediments_impediment_id_seq", allocationSize = 1)
public class Impediment implements Serializable {

	private static final long serialVersionUID = -8501472567228998129L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "impedimentGenerator")
	@Column(name = "impediment_id", nullable = false)
	private Long id;
	
	@Column(name = "impediment_name", nullable = false)
	private String name;
	
	@Column(name = "impediment_description", nullable = true)
	private String description;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "impediment_priority_id", nullable = false)
	private Priority priority;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "impediment_status_id", nullable = false)
	private ImpedimentStatus status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "impediment_report_date", nullable = false)
	private Date reportDate;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = AppUser.class)
	@Column(name = "impediment_reporter", nullable = false)
	private AppUser reporter;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = AppUser.class)
	@Column(name = "impediment_processor", nullable = false)
	private AppUser processor;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Remedy.class, mappedBy = "remedy_impediment_id")
	private Set<Remedy> remedies;

	public Impediment() {
		remedies = new HashSet<>();
	}
	
	public Impediment(Long id, String name, String description, Priority priority, ImpedimentStatus status, Date reportDate, AppUser reporter, AppUser processor, Set<Remedy> remedies) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.status = status;
		this.reportDate = reportDate;
		this.reporter = reporter;
		this.processor = processor;
		this.remedies = remedies;
	}

	public Impediment(String name, String description, Priority priority, ImpedimentStatus status, Date reportDate, AppUser reporter, AppUser processor, Set<Remedy> remedies) {
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.status = status;
		this.reportDate = reportDate;
		this.reporter = reporter;
		this.processor = processor;
		this.remedies = remedies;
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

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public ImpedimentStatus getStatus() {
		return status;
	}

	public void setStatus(ImpedimentStatus status) {
		this.status = status;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public AppUser getReporter() {
		return reporter;
	}

	public void setReporter(AppUser reporter) {
		this.reporter = reporter;
	}

	public AppUser getProcessor() {
		return processor;
	}

	public void setProcessor(AppUser processor) {
		this.processor = processor;
	}

	public Set<Remedy> getRemedies() {
		return remedies;
	}

	public void setRemedies(Set<Remedy> remedies) {
		this.remedies = remedies;
	}

	@Override
	public String toString() {
		return "Impediment [id=" + id + ", name=" + name + ", description=" + description + ", priority=" + priority + ", status=" + status + ", reportDate="
				+ reportDate + ", reporter=" + reporter + ", processor=" + processor + ", remedies=" + remedies + "]";
	}
	
}
