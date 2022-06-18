package com.sankha.splitewise.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Expense extends BaseModel{
	
	private double amount;
	
	@ManyToOne
	private User createdBy;
	private String description;
	private Date createdAt;
	
	@ManyToOne
	private Currency baseCurrency;
	
	@ManyToMany
	private List<User> participents;
}
