package com.example.demo.tasks.dtos;

import java.util.Date;

import org.springframework.lang.Nullable;

import lombok.Data;
import lombok.NonNull;

@Data
public class CreateTaskDto {
	@NonNull
	String title;
	
	String description;
	
	@NonNull
	Date dueDate;
	
	@NonNull
	Boolean isCompleted;

}
