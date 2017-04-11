package hu.todomanager.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import hu.todomanager.ejbservice.domain.PriorityStub;
import hu.todomanager.persistence.entity.Priority;

@Stateless
public class PriorityConverterImpl implements PriorityConverter {

	@Override
	public PriorityStub to(Priority priority) {
		return new PriorityStub(priority.getName(), priority.getPriorityValue());
	}
	
	@Override
	public List<PriorityStub> allTo(List<Priority> priorities) {
		List<PriorityStub> stubs = new ArrayList<PriorityStub>();
		for (Priority priority : priorities) {
			stubs.add(new PriorityStub(priority.getName(), priority.getPriorityValue()));
		}
		return stubs;
	}
}
