package hu.todomanager.ejbserviceclient.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubTodoStub implements Serializable {

    private String name;
    private String description;
    private int state;
    private Date deadline;

    public SubTodoStub() {}
    
    public SubTodoStub(String name, String description, int state) {
        super();
        this.name = name;
        this.description = description;
        this.state = state;
    }
    
    public SubTodoStub(String name, String description, int state, Date deadline) {
        super();
        this.name = name;
        this.description = description;
        this.state = state;
        this.deadline = deadline;
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

    @Override
    public String toString() {
        return "TodoStub [name=" + this.name + ", description=" + this.description + ", deadline=" + this.deadline.toString() + "]";
    }

}
