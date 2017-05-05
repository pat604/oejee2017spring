package hu.qwaevisz.tickethandling.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;

import hu.qwaevisz.tickethandling.ejbserviceclient.domain.ComponentStub;
import hu.qwaevisz.tickethandling.ejbserviceclient.domain.SystemStub;
import hu.qwaevisz.tickethandling.persistence.entity.CompInSystem;
import hu.qwaevisz.tickethandling.persistence.entity.Customer;

@PermitAll
@Stateless
public class SystemConverterImpl implements SystemConverter {

	@Override
	public SystemStub to(Customer customer) {
		final String id = customer.getId();
		final String company_name = customer.getName();

		final List<ComponentStub> components = new ArrayList<ComponentStub>();
		final Set<CompInSystem> compinsyss = customer.getComponents();

		for (final CompInSystem compinsys : compinsyss) {
			components.add(ComponentStub.valueOf(compinsys.getComponent().toString()));
		}

		return new SystemStub(id, company_name, components);
	}

	@Override
	public List<SystemStub> to(List<Customer> customers) {
		final List<SystemStub> result = new ArrayList<SystemStub>();
		for (final Customer customer : customers) {
			result.add(this.to(customer));
		}
		return result;
	}

}
