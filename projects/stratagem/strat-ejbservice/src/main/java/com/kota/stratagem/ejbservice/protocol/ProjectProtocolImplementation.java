package com.kota.stratagem.ejbservice.protocol;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.kota.stratagem.ejbservice.domain.ProjectRepresentor;
import com.kota.stratagem.ejbservice.converter.ProjectConverter;
import com.kota.stratagem.persistence.exception.PersistenceServiceException;
import com.kota.stratagem.persistence.service.ProjectService;

@Stateless(mappedName = "ejb/projectProtocol")
public class ProjectProtocolImplementation implements ProjectProtocol {

	private static final Logger LOGGER = Logger.getLogger(ProjectProtocolImplementation.class);
	
	@EJB
	private ProjectService projectService;
	
	@EJB
	private ProjectConverter converter;
	
	@Override
	public List<ProjectRepresentor> getAllProjects() {
		List<ProjectRepresentor> representors = new ArrayList<>();
		try {
			representors = this.converter.to(this.projectService.readAll());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Fetch all projects --> " + representors.size() + " item(s)");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
		}
		return representors;
	}
	
}