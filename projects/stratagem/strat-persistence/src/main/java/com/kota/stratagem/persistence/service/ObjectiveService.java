package com.kota.stratagem.persistence.service;

import java.util.List;

import javax.ejb.Local;

import com.kota.stratagem.persistence.entity.Objective;
import com.kota.stratagem.persistence.exception.PersistenceServiceException;

@Local
public interface ObjectiveService {

	Objective read(Long id) throws PersistenceServiceException;
	
	List<Objective> readAll() throws PersistenceServiceException;

}
