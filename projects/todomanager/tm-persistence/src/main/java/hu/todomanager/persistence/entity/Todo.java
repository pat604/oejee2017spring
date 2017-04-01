package hu.todomanager.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

import hu.todomanager.persistence.parameter.TodoParameter;
import hu.todomanager.persistence.query.TodoQuery;

@Entity
@Table(name = "todo")
@NamedQueries(value = {
		@NamedQuery(name = TodoQuery.GET_BY_ID, query = "SELECT t FROM Todo t WHERE t.id=:" + TodoParameter.ID),
		@NamedQuery(name = TodoQuery.GET_BY_NAME, query = "SELECT t FROM Todo t WHERE t.name=:" + TodoParameter.NAME),
		@NamedQuery(name = TodoQuery.GET_ALL, query = "SELECT t FROM Todo t"),
})

public class Todo implements Serializable {
	
	@Id
	@SequenceGenerator(name = "generatorTodo", sequenceName = "todo_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorTodo")
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "state", nullable = false)
	private int state;
	
	@Column(name = "deadline", nullable = false)
	private Date deadline;
	
	public Todo() {}
	
	public Todo(String name, String description, int state, Date deadline){
		this.name = name;
		this.description = description;
		this.state = state;
		this.deadline = deadline;
	}
	
	public long getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public int getState(){
		return this.state;
	}
	
	public Date getDeadline(){
		return this.deadline;
	}
}