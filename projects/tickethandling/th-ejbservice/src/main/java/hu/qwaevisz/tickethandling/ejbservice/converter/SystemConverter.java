package hu.qwaevisz.tickethandling.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.tickethandling.ejbserviceclient.domain.SystemStub;
import hu.qwaevisz.tickethandling.persistence.entity.Customer;

@Local
public interface SystemConverter {

	SystemStub to(Customer customer);

	List<SystemStub> to(List<Customer> customers);

}
