package com.guilttrip.dao;

import java.util.List;

import com.guilttrip.entitymodel.Task;

public interface TaskDao {

	List<Task> getTasks();

	Task updateTask(Task task);

	Task findById(int id);

	Boolean deleteTaskById(int id);

	Task persist(Task task);

}
