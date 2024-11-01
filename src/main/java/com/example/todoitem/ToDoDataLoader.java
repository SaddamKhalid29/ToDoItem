package com.example.todoitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.todoitem.dao.ToDoItemDao;
import com.example.todoitem.model.ToDoItem;

@Configuration
public class ToDoDataLoader {

	@Autowired
	ToDoItemDao toDoDao;
	
	
	@Bean
	public CommandLineRunner loadData() {
		return args ->{
			toDoDao.save(new ToDoItem("Bread", "To ready Brealfast", false));
			toDoDao.save(new ToDoItem("Homework Complete", "PMLS", true));
			toDoDao.save(new ToDoItem("Go for a run", "Morning jog in the park", true));
			
			
			System.out.println("Dummy data inserted into the database.");
			
		};
		
	}
}
