package hu.todomanager.persistence.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import hu.todomanager.persistence.parameter.TodoParameter;
import hu.todomanager.persistence.query.CategoryQuery;

@Entity
@Table(name = "category")
@NamedQueries(value = {
		@NamedQuery(name = CategoryQuery.GET_ALL, query = "SELECT c FROM Category c"),
		@NamedQuery(name = CategoryQuery.GET_BY_NAME, query = "SELECT c FROM Category c WHERE c.name=:" + TodoParameter.NAME),
		//select c from category c where id in (select category_id from todo join category_to_todo on (todo.id = todo_id))
})

public class Category implements Serializable {
	
	@Id
	@SequenceGenerator(name = "generatorCategory", sequenceName = "category_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorCategory")
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	public Category() {}
	
	public Category(String name, String description){
		this.name = name;
		this.description = description;
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
}