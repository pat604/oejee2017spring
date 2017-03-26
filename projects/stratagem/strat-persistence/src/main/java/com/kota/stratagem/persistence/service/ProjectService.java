package com.kota.stratagem.persistence.service;

import java.util.List;
import javax.ejb.Local;
import com.kota.stratagem.persistence.entity.Project;
import com.kota.stratagem.persistence.exception.PersistenceServiceException;

@Local
public interface ProjectService {
	
	List<Project> readAll() throws PersistenceServiceException;
	
}