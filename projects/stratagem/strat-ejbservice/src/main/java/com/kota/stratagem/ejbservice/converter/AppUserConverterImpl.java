package com.kota.stratagem.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.kota.stratagem.ejbservice.domain.AppUserRepresentor;
import com.kota.stratagem.ejbservice.domain.RoleRepresentor;
import com.kota.stratagem.persistence.entity.AppUser;
import com.kota.stratagem.persistence.entity.Impediment;
import com.kota.stratagem.persistence.entity.Objective;
import com.kota.stratagem.persistence.entity.Project;
import com.kota.stratagem.persistence.entity.Task;
import com.kota.stratagem.persistence.entity.Team;

@Stateless
public class AppUserConverterImpl implements AppUserConverter {

	private ObjectiveConverter objectiveConverter = new ObjectiveConverterImpl();
	private ProjectConverter projectConverter = new ProjectConverterImpl();
	private TaskConverter taskConverter = new TaskConverterImpl();
	private ImpedimentConverter impedimentConverter = new ImpedimentConverterImpl();
	private TeamConverter teamConverter = new TeamConverterImpl();

	@Override
	public AppUserRepresentor to(AppUser user) {
		final RoleRepresentor role = RoleRepresentor.valueOf(user.getRole().toString());
		final AppUserRepresentor representor = user.getId() != null ? new AppUserRepresentor(user.getId(), user.getName(), user.getPasswordHash(), user.getEmail(), role)
				: new AppUserRepresentor(user.getName(), user.getPasswordHash(), user.getEmail(), role);
		if(user.getObjectives() != null) {
			for(Objective objective : user.getObjectives()) {
				representor.addObjective(objectiveConverter.to(objective));
			}
		}
		if(user.getProjects() != null) {
			for(Project project : user.getProjects()) {
				representor.addProject(projectConverter.to(project));
			}
		}
		if(user.getTasks() != null) {
			for(Task task : user.getTasks()) {
				representor.addTask(taskConverter.to(task));
			}
		}
		if(user.getReportedImpediments() != null) {
			for(Impediment impediment : user.getReportedImpediments()) {
				representor.addReportedImpediment(impedimentConverter.to(impediment));
			}
		}
		if(user.getProcessedImpediments() != null) {
			for(Impediment impediment : user.getProcessedImpediments()) {
				representor.addProcessingImpediment(impedimentConverter.to(impediment));
			}
		}
		if(user.getSupervisedTeams() != null) {
			for(Team team : user.getSupervisedTeams()) {
				representor.addSupervisedTeam(teamConverter.to(team));
			}
		}
		if(user.getTeamMemberships() != null) {
			for(Team team : user.getTeamMemberships()) {
				representor.addSupervisedTeam(teamConverter.to(team));
			}
		}
		return representor;
	}

	@Override
	public List<AppUserRepresentor> to(List<AppUser> users) {
		final List<AppUserRepresentor> representors = new ArrayList<>();
		for(final AppUser user : users) {
			representors.add(this.to(user));
		}
		return representors;
	}

}
