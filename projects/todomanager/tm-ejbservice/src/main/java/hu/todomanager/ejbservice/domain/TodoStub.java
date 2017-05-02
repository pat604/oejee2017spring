package hu.todomanager.ejbservice.domain;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import hu.todomanager.ejbservice.domain.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Todo")
@XmlAccessorType(XmlAccessType.FIELD)
public class TodoStub {

	@XmlAttribute(name = "name")
    private String name;
	
	@XmlAttribute(name = "description")
    private String description;
	
	@XmlAttribute(name = "state")
    private int state;
	
	@XmlAttribute(name = "deadline")
    private Date deadline;
	
    private PriorityStub priority;
    private List<SubTodoStub> subTodos;

    public TodoStub() {
    	this.subTodos = new ArrayList<SubTodoStub>();
    }
    
    public TodoStub(String name, String description, int state, Date deadline) {
        super();
        this.name = name;
        this.description = description;
        this.state = state;
        this.deadline = deadline;
        this.priority = null;
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

    public PriorityStub getPriority(){
        return this.priority;
    }

    public void setPriority(PriorityStub priority){
        this.priority = priority;
    }

    public List<SubTodoStub> getSubTodos(){
        return this.subTodos;
    }

    public void setSubTodos(List<SubTodoStub> subTodos){
        this.subTodos = subTodos;
    }

    public void addSubTodo(SubTodoStub subTodo){
        this.subTodos.add(subTodo);
    }

    @Override
    public String toString() {
        return "TodoStub [name=" + this.name + ", description=" + this.description + 
        		", deadline=" + this.deadline.toString() + ", priority=" + this.priority.getPriorityValue() + "]";
    }

}
