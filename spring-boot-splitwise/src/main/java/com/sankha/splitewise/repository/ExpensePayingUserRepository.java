package com.sankha.splitewise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sankha.splitewise.model.Expense;
import com.sankha.splitewise.model.ExpensePayingUser;

@Repository
public interface ExpensePayingUserRepository extends JpaRepository<ExpensePayingUser, Long> {
	List<ExpensePayingUser> findAllByExpense(Expense expense);
}
