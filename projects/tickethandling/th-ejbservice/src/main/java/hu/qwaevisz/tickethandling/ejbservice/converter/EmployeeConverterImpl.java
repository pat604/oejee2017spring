package hu.qwaevisz.tickethandling.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hu.qwaevisz.tickethandling.ejbservice.domain.EmployeeStub;
import hu.qwaevisz.tickethandling.persistence.entity.Employee;

@Stateless
public class EmployeeConverterImpl implements EmployeeConverter {

	@Override
	public EmployeeStub to(Employee emp) {
		return new EmployeeStub(emp.getId(), emp.getName(), emp.getLevel(), emp.getEmail());
	}

	@Override
	public List<EmployeeStub> to(List<Employee> emps) {
		final List<EmployeeStub> result = new ArrayList<EmployeeStub>();
		for (final Employee emp : emps) {
			result.add(this.to(emp));
		}
		return result;
	}

}
