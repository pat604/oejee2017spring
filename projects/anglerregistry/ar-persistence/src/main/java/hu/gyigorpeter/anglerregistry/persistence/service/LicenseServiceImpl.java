package hu.gyigorpeter.anglerregistry.persistence.service;

import java.util.Date;

import javax.ejb.Stateless;

import hu.gyigorpeter.anglerregistry.persistence.entity.LicenseEntity;
import hu.gyigorpeter.anglerregistry.persistence.exception.PersistenceServiceException;

@Stateless
public class LicenseServiceImpl implements LicenseService {

	@Override
	public LicenseEntity readAll() throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LicenseEntity create(long lakeId, long fishId, Date date, int kor, int quantity) throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LicenseEntity update(long lakeId, long fishId, Date DATE, int kor, int quantity) throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) throws PersistenceServiceException {
		// TODO Auto-generated method stub

	}

}
