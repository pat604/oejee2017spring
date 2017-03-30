package hu.qwaevisz.tickethandling.ejbservice.converter;

import java.util.List;

import javax.ejb.Stateless;

import hu.qwaevisz.tickethandling.ejbservice.domain.SystemStub;
import hu.qwaevisz.tickethandling.persistence.entity.Customer;

@Stateless
public class CustomerConverterImpl implements CustomerConverter {

	@Override
	public SystemStub to(Customer customer) {
		return null;
		// new SystemStub(customer.getId());
	}

	@Override
	public List<SystemStub> to(List<Customer> customers) { // TODO Auto-generated method stub return null;
		return null;
	}

}
