package com.example.demo.tasks;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.tasks.dtos.CreateTaskDto;
import com.example.demo.tasks.dtos.TaskResponseDto;
import com.example.demo.tasks.exceptions.TaskNotFoundException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class TasksService {
	@Autowired
	private  TasksRepository tasksRepository;
	@Autowired
	private  ModelMapper modelMapper;
	
//	 public TasksService(TasksRepository tasksRepository, ModelMapper modelMapper) {
//	        this.tasksRepository = tasksRepository;
//	        this.modelMapper = modelMapper;
//	    }
//	

	public TaskResponseDto creatTask(CreateTaskDto newTask) {
		if(newTask.getDueDate().before(new Date())) {
			throw new IllegalArgumentException("Due date is from past,live in the present please");
		}
		TaskEntity task= modelMapper.map(newTask, TaskEntity.class);
		//task.setIsCompleted(false);
		TaskEntity savedTask= tasksRepository.save(task);
		return modelMapper.map(savedTask, TaskResponseDto.class);
		
	}
	
	public TaskResponseDto getAllTaskById(Long id) {
		TaskEntity task = tasksRepository.findById(id).
				orElseThrow(()->new TaskNotFoundException(id));
		return modelMapper.map(task, TaskResponseDto.class);
	}
	
	public List<TaskEntity> getAllTasks() {
		List<TaskEntity> tasks = tasksRepository.findAll();
		return modelMapper.map(tasks, List.class);
	}

	public List<TaskEntity> getAllTasksFiltered(Boolean flag) {
		// TODO Auto-generated method stub
		List<TaskEntity> tasks = tasksRepository.findByIsCompleted(flag);
		return modelMapper.map(tasks, List.class);
	}
	
//	public TaskResponseDto updateTask(CreateTaskDto newTask) {
//		if(newTask.getDueDate().before(new Date())) {
//			throw new IllegalArgumentException("Due date is from past,live in the present please");
//		}
//		TaskEntity task= modelMapper.map(newTask, TaskEntity.class);
//		//task.setIsCompleted(false);
//		TaskEntity savedTask= tasksRepository.save(task);
//		return modelMapper.map(savedTask, TaskResponseDto.class);
//		
//	}

	public TaskResponseDto updateTask(CreateTaskDto updateTask,Long id) {
		// TODO Auto-generated method stub
//		if(updateTask.getDueDate().before(new Date())) {
//			throw new IllegalArgumentException("Due date is from past,live in the present please");
//		}
		ObjectMapper objectMapper = new ObjectMapper();
		
		TaskEntity task= tasksRepository.findById(id).
				orElseThrow(()->new TaskNotFoundException(id));
		try {
			objectMapper.updateValue(task, updateTask);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelMapper.map(task, TaskEntity.class);
		//task.setIsCompleted(false);
		TaskEntity savedTask= tasksRepository.save(task);
		return modelMapper.map(savedTask, TaskResponseDto.class);
	}
	
	
	
	
	
}
