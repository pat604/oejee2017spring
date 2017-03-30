package hu.todomanager.persistence.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import hu.todomanager.persistence.query.PriorityToTodoQuery;

@Entity
@Table(name = "priority_to_todo")
@NamedQueries(value = {
		@NamedQuery(name = PriorityToTodoQuery.GET_ALL, query = "SELECT p FROM PriorityToTodo p"),
})

public class PriorityToTodo implements Serializable {
	
	@Id
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "priority_id", nullable = false)
	private Long priorityId;
	
	@Column(name = "todo_id", nullable = false)
	private Long todoId;
	
	public PriorityToTodo() {}
	
	public PriorityToTodo(Long priorityId, Long todoId){
		this.priorityId = priorityId;
		this.todoId = todoId;
	}
	
	public long getId(){
		return this.id;
	}
	
	public long getPriorityId(){
		return this.priorityId;
	}
	
	public long getTodoId(){
		return this.todoId;
	}
}