package com.example.todoitem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todoitem.model.ToDoItem;

@Repository
public interface ToDoItemDao extends JpaRepository<ToDoItem, Integer> {
	
	List<ToDoItem> findByisCompleted(boolean isCompleted);

	List<ToDoItem> findBytaskTitle(String taskTitle );

}
