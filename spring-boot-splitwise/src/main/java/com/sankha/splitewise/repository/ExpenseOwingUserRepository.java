package com.sankha.splitewise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sankha.splitewise.model.Expense;
import com.sankha.splitewise.model.ExpenseOwingUser;

@Repository
public interface ExpenseOwingUserRepository extends JpaRepository<ExpenseOwingUser, Long> {
	List<ExpenseOwingUser> findAllByExpense(Expense expense);
}
