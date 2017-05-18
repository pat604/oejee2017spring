package com.kota.stratagem.ejbservice.converter;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.kota.stratagem.ejbserviceclient.domain.TaskRepresentor;
import com.kota.stratagem.persistence.entity.Task;

@Stateless
public class TaskConverterImpl implements TaskConverter {

	@EJB
	private AppUserConverter appUserConverter;

	@EJB
	private TeamConverter teamConverter;

	@EJB
	private ObjectiveConverter objectiveConverter;

	@EJB
	private ProjectConverter projectConverter;

	@EJB
	private ImpedimentConverter impedimentConverter;

	@Override
	public TaskRepresentor to(Task task) {
		final TaskRepresentor representor = task.getId() != null
				? new TaskRepresentor(task.getId(), task.getName(), task.getDescription(), task.getCompletion())
				: new TaskRepresentor(task.getName(), task.getDescription(), task.getCompletion());
		// if (task.getAssignedTeams() != null) {
		// for (final Team team : task.getAssignedTeams()) {
		// representor.addTeam(this.teamConverter.to(team));
		// }
		// }
		// if (task.getAssignedUsers() != null) {
		// for (final AppUser user : task.getAssignedUsers()) {
		// representor.addUser(this.appUserConverter.to(user));
		// }
		// }
		// if (task.getImpediments() != null) {
		// for (final Impediment impediment : task.getImpediments()) {
		// representor.addImpediment(this.impedimentConverter.to(impediment));
		// }
		// }
		// if (task.getDependantTasks() != null) {
		// for (final Task dependant : task.getDependantTasks()) {
		// representor.addDependantTask(this.to(dependant));
		// }
		// }
		// if (task.getTaskDependencies() != null) {
		// for (final Task dependencies : task.getTaskDependencies()) {
		// representor.addTaskDependency(this.to(dependencies));
		// }
		// }
		// if (task.getObjective() != null) {
		// representor.setObjective(this.objectiveConverter.to(task.getObjective()));
		// }
		// if(task.getProject() != null) {
		// representor.setProject(this.projectConverter.to(task.getProject()));
		// }
		return representor;
	}

	@Override
	public Set<TaskRepresentor> to(Set<Task> tasks) {
		final Set<TaskRepresentor> representors = new HashSet<>();
		for (final Task task : tasks) {
			representors.add(this.to(task));
		}
		return representors;
	}

}