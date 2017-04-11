package com.kota.stratagem.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.kota.stratagem.ejbservice.domain.ProjectRepresentor;
import com.kota.stratagem.ejbservice.domain.ProjectStatusRepresentor;
import com.kota.stratagem.persistence.entity.AppUser;
import com.kota.stratagem.persistence.entity.Impediment;
import com.kota.stratagem.persistence.entity.Project;
import com.kota.stratagem.persistence.entity.Task;
import com.kota.stratagem.persistence.entity.Team;

@Stateless
public class ProjectConverterImpl implements ProjectConverter {

	private ObjectiveConverter objectiveConverter = new ObjectiveConverterImpl();
	private TaskConverter taskConverter = new TaskConverterImpl();
	private TeamConverter teamConverter = new TeamConverterImpl();
	private AppUserConverter appUserConverter = new AppUserConverterImpl();
	private ImpedimentConverter impedimentConverter = new ImpedimentConverterImpl();

	@Override
	public ProjectRepresentor to(Project project) {
		final ProjectStatusRepresentor status = ProjectStatusRepresentor.valueOf(project.getStatus().toString());
		final ProjectRepresentor representor = project.getId() != null
				? new ProjectRepresentor(project.getId(), project.getName(), project.getDescription(), status, project.getDeadline(), project.getVisible(),
						objectiveConverter.to(project.getObjective()))
				: new ProjectRepresentor(project.getName(), project.getDescription(), status, project.getDeadline(), project.getVisible(), objectiveConverter.to(project.getObjective()));
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
		return representor;
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