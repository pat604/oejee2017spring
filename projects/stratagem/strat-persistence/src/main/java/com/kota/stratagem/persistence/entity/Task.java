package com.kota.stratagem.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kota.stratagem.persistence.parameter.TaskParameter;
import com.kota.stratagem.persistence.query.TaskQuery;

@Entity
@Table(name = "tasks")
@NamedQueries(value = { //
		@NamedQuery(name = TaskQuery.COUNT_BY_ID, query = "SELECT COUNT(t) FROM Task t WHERE t.id=:" + TaskParameter.ID),
		@NamedQuery(name = TaskQuery.GET_ALL_TASKS, query = "SELECT t FROM Task t ORDER BY t.completion"),
		@NamedQuery(name = TaskQuery.GET_BY_ID, query = "SELECT t FROM Task t WHERE t.id=:" + TaskParameter.ID),
		@NamedQuery(name = TaskQuery.REMOVE_BY_ID, query = "DELETE FROM Task t WHERE t.id=:" + TaskParameter.ID)
		//
})
public class Task implements Serializable {

	private static final long serialVersionUID = -6357816746519911429L;

	@Id
	@SequenceGenerator(name = "taskGenerator", sequenceName = "task_task_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskGenerator")
	@Column(name = "task_id", nullable = false)
	private Long id;

	@Column(name = "task_name", nullable = false)
	private String name;

	@Column(name = "task_description", nullable = true)
	private String description;

	@Column(name = "task_completion_percentage", nullable = false)
	private double completion;

	public Task() {
		this(null, null, null, 0);
	}

	public Task(Long id, String name, String description, double completion) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.completion = completion;
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

	public double getCompletion() {
		return completion;
	}

	public void setCompletion(double completion) {
		this.completion = completion;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", completion=" + completion + "]";
	}

}