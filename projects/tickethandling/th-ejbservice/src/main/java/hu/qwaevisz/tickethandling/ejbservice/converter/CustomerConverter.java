package hu.qwaevisz.tickethandling.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.tickethandling.ejbservice.domain.SystemStub;
import hu.qwaevisz.tickethandling.persistence.entity.Customer;

@Local
public interface CustomerConverter {

	SystemStub to(Customer customer);

	List<SystemStub> to(List<Customer> customers);

}
