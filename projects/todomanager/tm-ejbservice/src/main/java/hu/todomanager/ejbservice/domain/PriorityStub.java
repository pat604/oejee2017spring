package hu.todomanager.ejbservice.domain;

import hu.todomanager.ejbservice.domain.*;

public class PriorityStub {
	
	private String name;
	private int priorityValue;
	
	public PriorityStub() {
    	
    }
    
    public PriorityStub(String name, int priorityValue) {
        super();
        this.name = name;
        this.priorityValue = priorityValue;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getPriorityValue(){
    	return this.priorityValue;
    }
    
    public void setPriorityValue(int priorityValue){
    	this.priorityValue = priorityValue;
    }
}
