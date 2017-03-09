package hu.gyigorpeter.anglerregistry.persistence.service;

import java.util.Date;

import javax.ejb.Stateless;

import hu.gyigorpeter.anglerregistry.persistence.entity.SettlementEntity;
import hu.gyigorpeter.anglerregistry.persistence.exception.PersistenceServiceException;

@Stateless
public class SettlementServiceImpl implements SettlementService {

	@Override
	public SettlementEntity readAll() throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SettlementEntity create(long lakeId, long fishId, Date date, int age, int quantity, int numberOfBanDays) throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SettlementEntity update(long lakeId, long fishId, Date date, int age, int quantity, int numberOfBanDays) throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) throws PersistenceServiceException {
		// TODO Auto-generated method stub

	}

}
