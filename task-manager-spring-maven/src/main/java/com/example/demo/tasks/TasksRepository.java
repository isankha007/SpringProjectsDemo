package com.example.demo.tasks;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<TaskEntity,Long> {
	public List<TaskEntity> findByIsCompleted(Boolean isCompleted); 
}
