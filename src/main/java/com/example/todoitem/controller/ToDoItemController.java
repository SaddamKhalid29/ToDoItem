package com.example.todoitem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoitem.model.ToDoItem;
import com.example.todoitem.service.ToDoItemService;

@RestController
@RequestMapping("todos")
public class ToDoItemController {
	
	@Autowired
	ToDoItemService todoService;
	
	@GetMapping("alltasks")
	public List<ToDoItem> getAllTasks(){
		
		return todoService.getAllTasks();
		
	}
	
	@GetMapping("status/{status}")
	public List<ToDoItem> getAllTasksByStatus(@PathVariable boolean status){
		
		return todoService.getAllTasksByStatus(status);
	}
	@GetMapping("id/{id}")
	public Optional<ToDoItem>  getTaskById(@PathVariable int id){
		
		return todoService.getTaskById(id);
	}

}
