package com.sankha.splitewise.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ExpensePayingUser extends BaseModel {
	
	private double amount;
	
	@ManyToOne
	private Expense expense;
	
	@ManyToOne
	private User user;
	
}
