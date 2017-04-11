package hu.todomanager.ejbservice.facade;

import javax.ejb.Local;
import java.util.Date;
import java.util.List;
import hu.todomanager.ejbservice.domain.PriorityStub;
import hu.todomanager.ejbservice.exception.FacadeException;

public interface PriorityFacade {
	
	PriorityStub getPriorityByName(String name) throws FacadeException;
	
	List<PriorityStub> getAllPriority() throws FacadeException;
	
	void addPriority(PriorityStub priority) throws FacadeException;
}
