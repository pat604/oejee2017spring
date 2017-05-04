package hu.qwaevisz.tickethandling.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;

import hu.qwaevisz.tickethandling.ejbserviceclient.domain.ComponentStub;
import hu.qwaevisz.tickethandling.persistence.entity.Component;

@PermitAll
@Stateless
public class ComponentConverterImpl implements ComponentConverter {

	@Override
	public ComponentStub to(Component comp) {
		return new ComponentStub(comp.getId(), comp.getDescription());
	}

	@Override
	public List<ComponentStub> to(List<Component> comps) {
		final List<ComponentStub> result = new ArrayList<ComponentStub>();
		for (final Component comp : comps) {
			result.add(this.to(comp));
		}
		return result;
	}

}
