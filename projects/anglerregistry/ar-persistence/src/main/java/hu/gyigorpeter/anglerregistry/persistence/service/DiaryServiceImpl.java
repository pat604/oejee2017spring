package hu.gyigorpeter.anglerregistry.persistence.service;

import java.sql.Timestamp;

import javax.ejb.Stateless;

import hu.gyigorpeter.anglerregistry.persistence.entity.DiaryEntity;
import hu.gyigorpeter.anglerregistry.persistence.exception.PersistenceServiceException;

@Stateless
public class DiaryServiceImpl implements DiaryService {

	@Override
	public DiaryEntity readAll() throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiaryEntity create(long licenseId, long lakeId, long fishId, Timestamp timestamp, int quantity) throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiaryEntity update(long licenseId, long lakeId, long fishId, Timestamp timestamp, int quantity) throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) throws PersistenceServiceException {
		// TODO Auto-generated method stub

	}

}
