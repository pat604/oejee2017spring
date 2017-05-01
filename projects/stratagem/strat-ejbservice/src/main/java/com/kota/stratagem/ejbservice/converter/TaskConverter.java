package com.kota.stratagem.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import com.kota.stratagem.ejbserviceclient.domain.TaskRepresentor;
import com.kota.stratagem.persistence.entity.Task;

@Local
public interface TaskConverter {

	TaskRepresentor to(Task task);

	List<TaskRepresentor> to(List<Task> tasks);

}