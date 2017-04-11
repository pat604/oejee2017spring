package com.kota.stratagem.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.kota.stratagem.ejbservice.domain.TaskRepresentor;
import com.kota.stratagem.persistence.entity.Task;

@Stateless
public class TaskConverterImpl implements TaskConverter {

	@Override
	public TaskRepresentor to(Task task) {
		return new TaskRepresentor(task.getId(), task.getName(), task.getDescription(), task.getCompletion());
	}

	@Override
	public List<TaskRepresentor> to(List<Task> tasks) {
		final List<TaskRepresentor> representors = new ArrayList<>();
		for(final Task task : tasks) {
			representors.add(this.to(task));
		}
		return representors;
	}

}