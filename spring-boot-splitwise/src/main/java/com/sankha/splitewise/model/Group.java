package com.sankha.splitewise.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group extends BaseModel{
 private String name;
 
 @ManyToMany
 private List<User> participants;
 
 @ManyToMany
 private List<User> admins;
 private String description;
 
 @ManyToOne
 private User createdBy;
 
 @OneToMany
 private List<Expense> expenses;

@Override
public String toString() {
	return "Group [name=" + name + "]";
}
 
 
}
