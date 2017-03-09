package hu.gyigorpeter.anglerregistry.persistence.service;

import java.util.Date;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.persistence.entity.FishEntity;
import hu.gyigorpeter.anglerregistry.persistence.exception.PersistenceServiceException;

@Local
public interface FishService {

	FishEntity readAll() throws PersistenceServiceException;

	FishEntity create(String fishName, int minimumSize, int dailyCount, Date startEmbargoTime, Date endEmbargoTime, int destruction)
			throws PersistenceServiceException;

	FishEntity update(String fishName, int minimumSize, int dailyCount, Date startEmbargoTime, Date endEmbargoTime, int destruction)
			throws PersistenceServiceException;

	void delete(long id) throws PersistenceServiceException;

}
