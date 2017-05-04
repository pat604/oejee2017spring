package com.kota.stratagem.ejbservice.protocol;

import java.util.List;

import javax.ejb.Local;

import com.kota.stratagem.ejbservice.exception.AdaptorException;
import com.kota.stratagem.ejbserviceclient.domain.ObjectiveRepresentor;
import com.kota.stratagem.ejbserviceclient.exception.ServiceException;

@Local
public interface ObjectiveProtocol {

	ObjectiveRepresentor getObjective(Long id) throws ServiceException;

	List<ObjectiveRepresentor> getAllObjectives() throws AdaptorException;

}