package com.example.todoitem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoitem.dao.ToDoItemDao;
import com.example.todoitem.model.ToDoItem;

@Service
public class ToDoItemService {

	@Autowired
	ToDoItemDao todoDao;
	
	public List<ToDoItem> getAllTasks() {
		// TODO Auto-generated method stub
		return todoDao.findAll();
	}

	public List<ToDoItem> getAllTasksByStatus(boolean status) {
		// TODO Auto-generated method stub
		return todoDao.findByisCompleted(status);
	}
	
	public Optional<ToDoItem> getTaskById(int id) {
		
		return todoDao.findById(id);
		}

	public List<ToDoItem> getTaskByTitle(String title) {
		
		return todoDao.findBytaskTitle(title);
	}

	public ToDoItem addNewTask(ToDoItem toDoItem) {
		// TODO Auto-generated method stub
		
		return todoDao.save(toDoItem);
	}

	public ToDoItem updateTaskById(Optional<ToDoItem> existingItem) {
		// TODO Auto-generated method stub
		
		return todoDao.save(existingItem.get());
		
	}

	public void updateTaskByTitle(ToDoItem toDo) {
		// TODO Auto-generated method stub
		
		todoDao.save(toDo);
		
	}

	public void deleteTaskById(ToDoItem toDoItem) {
		// TODO Auto-generated method stub
		todoDao.deleteById(toDoItem.getTaskId());
	}
	}
