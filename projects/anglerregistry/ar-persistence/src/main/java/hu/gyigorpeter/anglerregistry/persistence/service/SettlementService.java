package hu.gyigorpeter.anglerregistry.persistence.service;

import java.util.Date;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.persistence.entity.SettlementEntity;
import hu.gyigorpeter.anglerregistry.persistence.exception.PersistenceServiceException;

@Local
public interface SettlementService {

	SettlementEntity readAll() throws PersistenceServiceException;

	SettlementEntity create(long lakeId, long fishId, Date date, int age, int quantity, int numberOfBanDays) throws PersistenceServiceException;

	SettlementEntity update(long lakeId, long fishId, Date date, int age, int quantity, int numberOfBanDays) throws PersistenceServiceException;

	void delete(long id) throws PersistenceServiceException;
}
