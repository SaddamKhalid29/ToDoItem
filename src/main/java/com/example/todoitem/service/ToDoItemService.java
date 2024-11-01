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
	}
