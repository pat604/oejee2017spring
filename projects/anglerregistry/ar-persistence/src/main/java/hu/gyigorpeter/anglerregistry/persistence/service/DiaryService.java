package hu.gyigorpeter.anglerregistry.persistence.service;

import java.sql.Timestamp;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.persistence.entity.DiaryEntity;
import hu.gyigorpeter.anglerregistry.persistence.exception.PersistenceServiceException;

@Local
public interface DiaryService {
	DiaryEntity readAll() throws PersistenceServiceException;

	DiaryEntity create(long licenseId, long lakeId, long fishId, Timestamp timestamp, int quantity) throws PersistenceServiceException;

	DiaryEntity update(long licenseId, long lakeId, long fishId, Timestamp timestamp, int quantity) throws PersistenceServiceException;

	void delete(long id) throws PersistenceServiceException;

}
