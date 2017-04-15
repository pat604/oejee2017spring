package com.kota.stratagem.persistence.service;

import javax.ejb.Local;

import com.kota.stratagem.persistence.entity.Objective;
import com.kota.stratagem.persistence.exception.PersistenceServiceException;

@Local
public interface ObjectiveService {

	Objective read(Long id) throws PersistenceServiceException;

}
