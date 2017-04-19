package hu.todomanager.persistence.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import hu.todomanager.persistence.query.PriorityQuery;
import hu.todomanager.persistence.parameter.TodoParameter;

@Entity
@Table(name = "priority")
@NamedQueries(value = {
		@NamedQuery(name = PriorityQuery.GET_ALL, query = "SELECT p FROM Priority p"),
		@NamedQuery(name = PriorityQuery.GET_BY_NAME, query = "SELECT p FROM Priority p WHERE p.name=:" + TodoParameter.NAME),
})

public class Priority implements Serializable {
	
	@Id
	@SequenceGenerator(name = "generatorPriority", sequenceName = "priority_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorPriority")
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "priority_value", nullable = false)
	private int priorityValue;
	
	public Priority() {}
	
	public Priority(String name, int priorityValue){
		this.name = name;
		this.priorityValue = priorityValue;
	}
	
	public long getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getPriorityValue(){
		return this.priorityValue;
	}
}