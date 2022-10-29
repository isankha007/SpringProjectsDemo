package com.example.demo.tasks.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class TaskResponseDto {
    private Long id;
    private String title;
    private String description;
    private Boolean completed;
    private Date dueDate;

}
