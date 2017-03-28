package com.kota.stratagem.ejbservice.protocol;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.kota.stratagem.ejbservice.converter.TaskConverter;
import com.kota.stratagem.ejbservice.domain.ProjectRepresentor;
import com.kota.stratagem.ejbservice.domain.TaskRepresentor;
import com.kota.stratagem.ejbservice.exception.AdaptorException;
import com.kota.stratagem.persistence.exception.PersistenceServiceException;
import com.kota.stratagem.persistence.service.TaskService;

@Stateless(mappedName = "ejb/taskProtocol")
public class TaskProtocolImplementation implements TaskProtocol {

	private static final Logger LOGGER = Logger.getLogger(TaskProtocolImplementation.class);

	@EJB
	private TaskService taskService;

	@EJB
	private TaskConverter converter;

	@Override
	public TaskRepresentor getTask(Long id) throws AdaptorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskRepresentor> getAllTasks() {
		List<TaskRepresentor> representors = new ArrayList<>();
		try {
			representors = this.converter.to(this.taskService.readAll());
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug("Fetch all tasks --> " + representors.size() + " item(s)");
			}
		} catch(final PersistenceServiceException e) {
			LOGGER.error(e, e);
		}
		return representors;
	}

	@Override
	public TaskRepresentor saveTask(Long id, String description, double completion, ProjectRepresentor project) throws AdaptorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeTask(Long id) throws AdaptorException {
		// TODO Auto-generated method stub

	}

}