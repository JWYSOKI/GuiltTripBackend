package com.guilttrip.viewmodel;

import com.guilttrip.entitymodel.Task;

public class TaskViewModel {

	
	private int id;

	private String activity;

	private String motivation;

	private int reminderTime;

	public TaskViewModel() {
	}
	
	public TaskViewModel(Task entity) {
		this.id = entity.getId();
		this.activity = entity.getActivity();
		this.motivation = entity.getMotivation();
		this.reminderTime = entity.getReminderTime();
	}
	
	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getMotivation() {
		return motivation;
	}

	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}

	public int getReminderTime() {
		return reminderTime;
	}

	public void setReminderTime(int reminderTime) {
		this.reminderTime = reminderTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
