package com.example.todoitem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ToDoItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskId;
	
	@Column(name = "task_title")
	private String taskTitle;
	
	@Column(name = "task_description")
	private String taskDescription;
	
	@Column(name = "is_completed")
	private boolean isCompleted;
	
	
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	public ToDoItem() {
		
	}
	
	public ToDoItem(String taskTitle, String taskDescription, boolean isCompleted) {
		super();
		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
		this.isCompleted = isCompleted;
	}
	
	@Override
	public String toString() {
		return "ToDoItem [taskId=" + taskId + ", taskTitle=" + taskTitle + ", taskDescription=" + taskDescription
				+ ", isCompleted=" + isCompleted + "]";
	}
	
	
	
	

	
}
