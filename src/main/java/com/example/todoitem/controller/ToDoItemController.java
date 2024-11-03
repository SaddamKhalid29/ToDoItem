package com.example.todoitem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("title/{title}")
	public List<ToDoItem> getTaskByTitle(@PathVariable String title) {
		
		return todoService.getTaskByTitle(title);
	}
	
	
	@PostMapping("add")
	public String addNewTask(@RequestBody ToDoItem toDoItem) {
		
		ToDoItem newToDo = todoService.addNewTask(toDoItem);
		
		return "New Task Added Successfully having id!" +newToDo.getTaskId();
		
	}
	
	@PutMapping("update/{id}")
	public String updateTaskById(@PathVariable int id,  @RequestBody ToDoItem toDoItem) {
		
		Optional<ToDoItem> existingItem = getTaskById(id);
		if(existingItem.isPresent()) {
			existingItem.get().setTaskTitle(toDoItem.getTaskTitle());
			existingItem.get().setTaskDescription(toDoItem.getTaskDescription());
			existingItem.get().setCompleted(toDoItem.isCompleted());
			
			todoService.updateTaskById(existingItem);

			return "Task is updated successfully!";
		}else {
			return "Task is not found with this id";
		}
		
	}
	
	@PutMapping("updateTaskByTitle/{title}")
	public String updateTaskByTitle(@PathVariable String title, @RequestBody ToDoItem toDoItem) {
		List<ToDoItem> existingItems = getTaskByTitle(title);
		if(existingItems!=null) {
			for (ToDoItem toDo : existingItems) {
				toDo.setTaskTitle(toDoItem.getTaskTitle());
				toDo.setTaskDescription(toDoItem.getTaskDescription());
				toDo.setCompleted(toDoItem.isCompleted());
				
				todoService.updateTaskByTitle(toDo);
			}
			
			return "All tasks are updated successfully had a title : " + title;
		}
		else {
			return "Task is not found with this title";
		}
			
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteTaskById(@PathVariable int id) {
		Optional<ToDoItem> toDoItem = getTaskById(id);
		if(toDoItem.isPresent()) {
		todoService.deleteTaskById(toDoItem.get());
		return "Task is deleted";
		}
		else {
			return "No task is found with this id";
		}
	}
	
	@DeleteMapping("deleteByTitle/{title}")
	public String deleteByTaskTitle(@PathVariable String title) {
		List<ToDoItem> toDos = getTaskByTitle(title);
		   // Debug statement to check the list contents
	    System.out.println("Tasks found: " + toDos);
	    
		if(toDos!=null && !toDos.isEmpty()) {
		for (ToDoItem toDo : toDos) {
			todoService.deleteTaskById(toDo);			
		}
			return "All tasks with this title:\" " + title + " \" are deleted.";
		}else {
			return "No tasks with this "+ title + " is found.";
		}
	}
}
