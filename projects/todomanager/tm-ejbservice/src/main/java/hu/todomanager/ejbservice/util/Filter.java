package hu.todomanager.ejbservice.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import hu.todomanager.ejbservice.domain.*;
import hu.todomanager.ejbservice.converter.*;
import hu.todomanager.persistence.entity.*;
import org.apache.log4j.Logger;


public class Filter {
	
	private static final Logger LOGGER = Logger.getLogger(Filter.class);
	
	
	public List<TodoStub> filterByCategory(List<TodoStub> todos, String category){
		if(category.equals("")){
			return todos;
		}
		List<TodoStub> categoryTodos = new ArrayList<TodoStub>();
		for(TodoStub todo : todos){
			if(todo.getCategories() != null){
				for(CategoryStub c : todo.getCategories()){
					if(c.getName().equals(category)){
						categoryTodos.add(todo);
					}
				}
			}
		}
		if(categoryTodos.size() == 0){
			return todos;
		}
		return categoryTodos;
	}
}
