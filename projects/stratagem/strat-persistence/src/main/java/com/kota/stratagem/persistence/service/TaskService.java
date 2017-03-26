package com.kota.stratagem.persistence.service;

import java.util.List;
import javax.ejb.Local;
import com.kota.stratagem.persistence.entity.Task;
import com.kota.stratagem.persistence.exception.PersistenceServiceException;

@Local
public interface TaskService {
	
	List<Task> readAll() throws PersistenceServiceException;
	
}