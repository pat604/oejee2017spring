package hu.todomanager.ejbserviceclient.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PriorityStub implements Serializable {
	
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
