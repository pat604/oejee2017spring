package hu.gyigorpeter.anglerregistry.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.License;

@Local
public interface LicenseFacade {

	List<License> getAll();

	License edit(License license);

	void delete(long id);
}
