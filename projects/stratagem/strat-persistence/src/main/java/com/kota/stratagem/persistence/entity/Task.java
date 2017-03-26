package com.kota.stratagem.persistence.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kota.stratagem.persistence.query.TaskQuery;
import com.kota.stratagem.persistence.entity.Project;

@Entity
@Table(name = "tasks")
@NamedQueries(value = {
		@NamedQuery(name = TaskQuery.GET_ALL_TASKS, query = "SELECT t FROM Task t ORDER BY t.completion")
})
public class Task implements Serializable {
	
	private static final long serialVersionUID = -6357816746519911429L;
	
	@Id
	@SequenceGenerator(name = "taskGenerator", sequenceName = "task_task_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskGenerator")
	@Column(name = "task_id", nullable = false)
	private Long id;
	
	@Column(name = "task_description", nullable = false)
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "task_project_id", referencedColumnName = "project_id", nullable = false)
	private Project project;
	
	@Column(name = "task_completion_percentage", nullable = false)
	private double completion;

	public Task() {
	
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

	public void setDescription(String description) {
		this.description = description;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public double getCompletion() {
		return completion;
	}

	public void setCompletion(double completion) {
		this.completion = completion;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", project=" + project + ", completion=" + completion + "]";
	}
	
}