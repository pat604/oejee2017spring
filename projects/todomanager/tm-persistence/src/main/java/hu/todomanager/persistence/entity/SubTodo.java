package hu.todomanager.persistence.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import hu.todomanager.persistence.query.SubTodoQuery;

@Entity
@Table(name = "sub_todo")
@NamedQueries(value = {
		@NamedQuery(name = SubTodoQuery.GET_ALL, query = "SELECT s FROM SubTodo s"),
})

public class SubTodo implements Serializable {
	
	@Id
	@SequenceGenerator(name = "generatorSubTodo", sequenceName = "sub_todo_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorSubTodo")
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "todo_id", nullable = false)
	private int todoId;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "state", nullable = false)
	private int state;
	
	public SubTodo() {}
	
	public SubTodo(int todoId, String name, String description, int state){
		this.todoId = todoId;
		this.name = name;
		this.description = description;
		this.state = state;
	}
	
	public long getId(){
		return this.id;
	}
	
	public int getTodoId(){
		return this.todoId;
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
}