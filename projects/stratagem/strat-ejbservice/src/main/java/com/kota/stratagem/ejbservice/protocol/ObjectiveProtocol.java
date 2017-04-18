package com.kota.stratagem.ejbservice.protocol;

import java.util.List;

import javax.ejb.Local;

import com.kota.stratagem.ejbservice.domain.AppUserRepresentor;
import com.kota.stratagem.ejbservice.domain.ObjectiveRepresentor;
import com.kota.stratagem.ejbservice.exception.AdaptorException;

@Local
public interface ObjectiveProtocol {

	ObjectiveRepresentor getObjective(Long id) throws AdaptorException;
	
	List<ObjectiveRepresentor> getAllObjectives() throws AdaptorException;
	
}
