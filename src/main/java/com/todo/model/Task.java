package com.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name="todo_list")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="todoid")
	private int id;
	
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	
	@Column(name="status")
	private String status;
	
	@Column(name="archived")
	private int archived = 0;

	public int getTodoId() {
		return id;
	}

	public void setTodoId(int todoId) {
		this.id = todoId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getStatus() {
		return status;
	}

	public int getArchived() {
		return archived;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setArchived(int archived) {
		this.archived = archived;
	}

	@Override
	public String toString() {
		return "ToDoTask [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status
				+ ", archived=" + archived + "]";
	}

	
	
}

