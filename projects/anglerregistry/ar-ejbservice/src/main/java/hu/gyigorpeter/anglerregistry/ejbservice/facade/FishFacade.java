package hu.gyigorpeter.anglerregistry.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Fish;

@Local
public interface FishFacade {

	List<Fish> getAll();

	Fish edit(Fish fish);

	void delete(long id);
}
