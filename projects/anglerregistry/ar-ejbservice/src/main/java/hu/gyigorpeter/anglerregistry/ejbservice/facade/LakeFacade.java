package hu.gyigorpeter.anglerregistry.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Lake;

@Local
public interface LakeFacade {

	List<Lake> getAll();

	Lake edit(Lake lake);

	void delete(long id);
}
