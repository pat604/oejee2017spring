package hu.gyigorpeter.anglerregistry.persistence.service;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.persistence.entity.LakeEntity;
import hu.gyigorpeter.anglerregistry.persistence.exception.PersistenceServiceException;

@Local
public interface LakeService {

	LakeEntity readAll() throws PersistenceServiceException;

	LakeEntity create(String waterCode, int size, String typeOfLake, int maximumDepth, String owner, boolean anglerFarm) throws PersistenceServiceException;

	LakeEntity update(String waterCode, int size, String typeOfLake, int maximumDepth, String owner, boolean anglerFarm) throws PersistenceServiceException;

	void delete(long id) throws PersistenceServiceException;
}
