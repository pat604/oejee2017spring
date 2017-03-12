package com.kota.stratagem.ejbservice.protocol;

import java.util.List;

import javax.ejb.Local;

import com.kota.stratagem.ejbservice.domain.TaskRepresentor;

@Local
public interface TaskProtocol {
	
	List<TaskRepresentor> getAllTasks();
	
}