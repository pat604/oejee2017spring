package hu.gyigorpeter.anglerregistry.persistence.service;

import java.util.Date;

import javax.ejb.Stateless;

import hu.gyigorpeter.anglerregistry.persistence.entity.FishEntity;
import hu.gyigorpeter.anglerregistry.persistence.exception.PersistenceServiceException;

@Stateless
public class FishServiceImpl implements FishService {

	@Override
	public FishEntity readAll() throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FishEntity create(String fishName, int minimumSize, int dailyCount, Date startEmbargoTime, Date endEmbargoTime, int destruction)
			throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FishEntity update(String fishName, int minimumSize, int dailyCount, Date startEmbargoTime, Date endEmbargoTime, int destruction)
			throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) throws PersistenceServiceException {
		// TODO Auto-generated method stub

	}

}
