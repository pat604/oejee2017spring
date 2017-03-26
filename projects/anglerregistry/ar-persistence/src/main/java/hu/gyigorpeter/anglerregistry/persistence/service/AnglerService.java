package hu.gyigorpeter.anglerregistry.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.persistence.entity.AnglerEntity;
import hu.gyigorpeter.anglerregistry.persistence.exception.PersistenceServiceException;

@Local
public interface AnglerService {

	void addAngler(AnglerEntity anglerEntity) throws PersistenceServiceException;

	AnglerEntity readById(long id) throws PersistenceServiceException;

	AnglerEntity readByNationalTicketId(long id) throws PersistenceServiceException;

	List<AnglerEntity> readAll() throws PersistenceServiceException;

}
