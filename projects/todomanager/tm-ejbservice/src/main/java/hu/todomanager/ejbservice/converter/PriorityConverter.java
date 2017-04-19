package hu.todomanager.ejbservice.converter;

import java.util.List;
import javax.ejb.Local;
import hu.todomanager.ejbservice.domain.PriorityStub;
import hu.todomanager.persistence.entity.Priority;

@Local
public interface PriorityConverter {

	PriorityStub to(Priority priority);
	
	List<PriorityStub> allTo(List<Priority> priorities);
}
