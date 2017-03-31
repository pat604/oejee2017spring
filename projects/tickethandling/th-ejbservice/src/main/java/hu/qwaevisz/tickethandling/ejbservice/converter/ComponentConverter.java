package hu.qwaevisz.tickethandling.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.tickethandling.ejbservice.domain.ComponentStub;
import hu.qwaevisz.tickethandling.persistence.entity.Component;

@Local
public interface ComponentConverter {

	ComponentStub to(Component comp);

	List<ComponentStub> to(List<Component> comps);

}
