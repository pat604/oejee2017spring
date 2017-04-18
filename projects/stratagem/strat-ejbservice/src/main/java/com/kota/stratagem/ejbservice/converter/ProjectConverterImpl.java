package com.kota.stratagem.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.kota.stratagem.ejbservice.domain.ObjectiveRepresentor;
import com.kota.stratagem.ejbservice.domain.ObjectiveStatusRepresentor;
import com.kota.stratagem.ejbservice.domain.ProjectRepresentor;
import com.kota.stratagem.ejbservice.domain.ProjectStatusRepresentor;
import com.kota.stratagem.persistence.entity.Objective;
import com.kota.stratagem.persistence.entity.Project;

@Stateless
public class ProjectConverterImpl implements ProjectConverter {

	private static final Logger LOGGER = Logger.getLogger(ProjectConverterImpl.class);
	
	@EJB
	private ObjectiveConverter objectiveConverter;

	@EJB
	private TaskConverter taskConverter;

	@EJB
	private TeamConverter teamConverter;

	@EJB
	private AppUserConverter appUserConverter;

	@EJB
	private ImpedimentConverter impedimentConverter;

	@Override
	public ProjectRepresentor to(Project project) {
		
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("ProjectConverter method called");
		}
		
		final ProjectStatusRepresentor status = ProjectStatusRepresentor.valueOf(project.getStatus().toString());
		final ProjectRepresentor representor = project.getId() != null
				? new ProjectRepresentor(project.getId(), project.getName(), project.getDescription(), status, project.getDeadline(), project.getVisible(), this.to(project.getObjective()))
				: new ProjectRepresentor(project.getName(), project.getDescription(), status, project.getDeadline(), project.getVisible(), this.to(project.getObjective()));
		/*
				if(project.getTasks() != null) {
			for(Task task : project.getTasks()) {
				representor.addTask(taskConverter.to(task));
			}
		}
		if(project.getAssignedTeams() != null) {
			for(Team team : project.getAssignedTeams()) {
				representor.addTeam(teamConverter.to(team));
			}
		}
		if(project.getAssignedUsers() != null) {
			for(AppUser user : project.getAssignedUsers()) {
				representor.addUser(appUserConverter.to(user));
			}
		}
		if(project.getImpediments() != null) {
			for(Impediment impediment : project.getImpediments()) {
				representor.addImpediment(impedimentConverter.to(impediment));
			}
		}
		*/
		return representor;
	}
	
	private ObjectiveRepresentor to(Objective objective) {
		return new ObjectiveRepresentor(objective.getId(), objective.getName(), objective.getDescription(), objective.getPriority(), ObjectiveStatusRepresentor.valueOf(objective.getStatus().toString()));
	}

	@Override
	public List<ProjectRepresentor> to(List<Project> projects) {
		final List<ProjectRepresentor> representors = new ArrayList<>();
		for(final Project project : projects) {
			representors.add(this.to(project));
		}
		return representors;
	}

}