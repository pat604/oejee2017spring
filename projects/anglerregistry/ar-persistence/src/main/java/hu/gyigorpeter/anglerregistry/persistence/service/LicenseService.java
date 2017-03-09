package hu.gyigorpeter.anglerregistry.persistence.service;

import java.util.Date;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.persistence.entity.LicenseEntity;
import hu.gyigorpeter.anglerregistry.persistence.exception.PersistenceServiceException;

@Local
public interface LicenseService {

	LicenseEntity readAll() throws PersistenceServiceException;

	LicenseEntity create(long lakeId, long fishId, Date date, int kor, int quantity) throws PersistenceServiceException;

	LicenseEntity update(long lakeId, long fishId, Date date, int kor, int quantity) throws PersistenceServiceException;

	void delete(long id) throws PersistenceServiceException;

}
