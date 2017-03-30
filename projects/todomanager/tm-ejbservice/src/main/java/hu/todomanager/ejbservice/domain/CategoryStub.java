package hu.todomanager.ejbservice.domain;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import hu.todomanager.ejbservice.domain.*;


public class CategoryStub {
	
	private String name;
	private String description;
	
	public CategoryStub() {
    	
    }
    
    public CategoryStub(String name, String description) {
        super();
        this.name = name;
        this.description = description;
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
}
