package com.example.demo.tasks.exceptions;

public class TaskNotFoundException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	public TaskNotFoundException(Long id) { super("Task with id="+id+" not found");}

}
