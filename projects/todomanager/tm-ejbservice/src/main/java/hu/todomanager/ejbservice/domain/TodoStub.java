package hu.todomanager.ejbservice.domain;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import hu.todomanager.ejbservice.domain.*;

public class TodoStub {

    private String name;
    private String description;
    private int state;
    private Date deadline;
    private int priority;
    
    public List<SubTodoStub> subTodos;

    public TodoStub() {
    	this.subTodos = new ArrayList<SubTodoStub>();
    }
    
    public TodoStub(String name, String description, int state, Date deadline) {
        super();
        this.name = name;
        this.description = description;
        this.state = state;
        this.deadline = deadline;
        this.subTodos = new ArrayList<SubTodoStub>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription(){
    	return this.description;
    }
    
    public void setDescription(String description){
    	this.description = description;
    }
    
    public int getState(){
    	return this.state;
    }
    
    public void setState(int state){
    	this.state = state;
    }
    
    public Date getDeadline(){
		return this.deadline;
	}
    
    public void setDeadline(Date deadline){
    	this.deadline = deadline;
    }
    
    public int getPriority(){
    	return this.priority;
    }
    
    public void setPriority(int priority){
    	this.priority = priority;
    }

    @Override
    public String toString() {
        return "TodoStub [name=" + this.name + ", description=" + this.description + 
        		", deadline=" + this.deadline.toString() + ", priority=" + this.priority + "]";
    }

}
