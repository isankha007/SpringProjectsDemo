package com.example.demo.tasks;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.ErrorResponseDto;
import com.example.demo.tasks.dtos.CreateTaskDto;
import com.example.demo.tasks.dtos.TaskResponseDto;
import com.example.demo.tasks.exceptions.TaskNotFoundException;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
	private TasksService tasksService;
	
	@GetMapping("")
	public List<TaskEntity> getTask() {
		return tasksService.getAllTasks();
		// TODO: tasksService.getTasks();
	}
	
	@GetMapping("filter/{flag}")
	public List<TaskEntity> getTaskFiltered(@PathVariable("flag") Boolean flag) {
		return tasksService.getAllTasksFiltered(flag);
		// TODO: tasksService.getTasks();
	}
	
	@PostMapping("")
	public ResponseEntity<TaskResponseDto> createTask(@RequestBody CreateTaskDto createTask){
		TaskResponseDto savedTask = tasksService.creatTask(createTask);
		return ResponseEntity
				.created(URI.create("/tasks"+savedTask.getId())).body(savedTask);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable("id") Long id){
		return ResponseEntity.ok(tasksService.getAllTaskById(id));
		
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<TaskResponseDto> updateTask(@PathVariable("id") Long id, @RequestBody CreateTaskDto createTask){
		TaskResponseDto savedTask = tasksService.updateTask(createTask,id);
		return ResponseEntity
				.created(URI.create("/tasks"+savedTask.getId())).body(savedTask);
	}
	
	@ExceptionHandler({IllegalArgumentException.class
	,TaskNotFoundException.class})
	public ResponseEntity<ErrorResponseDto> handleException(Exception e){
		if(e instanceof TaskNotFoundException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ErrorResponseDto(e.getMessage()));
		}
		
		
		return ResponseEntity
		.badRequest()
		.body(new ErrorResponseDto(e.getMessage()));
	}
	
	
}
