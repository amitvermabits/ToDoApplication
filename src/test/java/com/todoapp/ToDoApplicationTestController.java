package com.todoapp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.todo.model.Task;
import com.todo.repository.TaskRepository;




@ContextConfiguration
@ComponentScan({"com.todo.repository"})
@EnableJpaRepositories(basePackages = {"com.todo.repository"})
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = "classpath:application.properties")
public class ToDoApplicationTestController {
	
	 private Config config;
     
	    @Test
	    public void verifyBeansConfigured() {
	        assertNotNull(config);
	    }
	     
	    @Configuration
	    static class Config {
	    	
	    }
	
	@Autowired
	TaskRepository taskRepository;
	
	@Test
	public void findArchived(){
		List<Task> tasks = taskRepository.findByArchived(0);
		for(Task task:tasks){
			System.out.println(task.getName());
		}
	}

}
