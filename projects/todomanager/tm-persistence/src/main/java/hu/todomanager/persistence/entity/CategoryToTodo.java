package hu.todomanager.persistence.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import hu.todomanager.persistence.query.CategoryToTodoQuery;

@Entity
@Table(name = "category_to_todo")
@NamedQueries(value = {
		@NamedQuery(name = CategoryToTodoQuery.GET_ALL, query = "SELECT c FROM CategoryToTodo c"),
})

public class CategoryToTodo implements Serializable {
	
	@Id
	@SequenceGenerator(name = "generatorCategoryToTodo", sequenceName = "category_to_todo_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorCategoryToTodo")
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "category_id", nullable = false)
	private Long categoryId;
	
	@Column(name = "todo_id", nullable = false)
	private Long todoId;
	
	public CategoryToTodo() {}
	
	public CategoryToTodo(Long categoryId, Long todoId){
		this.categoryId = categoryId;
		this.todoId = todoId;
	}
	
	public long getId(){
		return this.id;
	}
	
	public long getCategoryId(){
		return this.categoryId;
	}
	
	public long getTodoId(){
		return this.todoId;
	}
}