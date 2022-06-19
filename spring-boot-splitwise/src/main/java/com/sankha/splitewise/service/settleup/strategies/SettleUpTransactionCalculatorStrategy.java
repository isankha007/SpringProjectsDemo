package com.sankha.splitewise.service.settleup.strategies;

import java.util.List;

import com.sankha.splitewise.model.ExpenseOwingUser;
import com.sankha.splitewise.model.ExpensePayingUser;
import com.sankha.splitewise.service.settleup.Transaction;

public interface SettleUpTransactionCalculatorStrategy {
	
	List<Transaction> getTransactions(List<ExpensePayingUser> expensePayingUsers,
            List<ExpenseOwingUser> expenseOwingUsers);

}
