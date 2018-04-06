package com.todo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.todo.model.Task;

@RepositoryRestResource
public interface TaskRepository extends CrudRepository<Task, Integer> {

	public List<Task> findByArchived(@Param("archivedfalse") int taskArchivedFalse);
	public List<Task> findByStatus(@Param("status") String taskStatus);

}
