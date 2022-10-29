package com.example.demo.tasks;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.demo.notes.NotesEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "task")
public class TaskEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	
	private String description;
	
	@Column(nullable = false)
	private Boolean isCompleted;
	
	@Column(nullable = false)
	private Date dueDate;
	
//	@OneToMany(targetEntity = NotesEntity.class,cascade = CascadeType.ALL,mappedBy = "task")

	@OneToMany(targetEntity = NotesEntity.class,cascade = CascadeType.ALL,mappedBy = "task")
	private List<NotesEntity> notes;
	
	
	

}
