package com.guilttrip.entitymodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.guilttrip.viewmodel.TaskViewModel;

@Entity
@Table(name = "task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "ACTIVITY")
	private String activity;

	@Column(name = "MOTIVATION")
	private String motivation;

	@Column(name = "REMINDER_TIME")
	private int reminderTime;

	public Task() {
	}
	
	public Task(TaskViewModel vm) {
		this.id = vm.getId();
		this.activity = vm.getActivity();
		this.motivation = vm.getMotivation();
		this.reminderTime = vm.getReminderTime();
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
