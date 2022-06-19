package com.sankha.splitewise.service.settleup.strategies;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;

import com.sankha.splitewise.model.ExpenseOwingUser;
import com.sankha.splitewise.model.ExpensePayingUser;
import com.sankha.splitewise.model.User;
import com.sankha.splitewise.service.settleup.Transaction;

@Service
public class GiveToNextSettleUpTransactionsCalculatorStrategy implements SettleUpTransactionCalculatorStrategy {

	@Override
	public List<Transaction> getTransactions(List<ExpensePayingUser> expensePayingUsers,
			List<ExpenseOwingUser> expenseOwingUsers) {

		Map<User,Double> extraAmounts = new HashMap<>();
		for(ExpensePayingUser expensePayingUser:expensePayingUsers) {
			if (!extraAmounts.containsKey(expensePayingUser.getUser())) {
                extraAmounts.put(expensePayingUser.getUser(), 0.);
            }

            extraAmounts.put(
                    expensePayingUser.getUser(),
                    extraAmounts.get(expensePayingUser.getUser()) + expensePayingUser.getAmount()
            );
		}
		
		for(ExpenseOwingUser expenseOwingUser:expenseOwingUsers) {
			if (!extraAmounts.containsKey(expenseOwingUser.getUser())) {
                extraAmounts.put(expenseOwingUser.getUser(), 0.);
            }

            extraAmounts.put(
            		expenseOwingUser.getUser(),
                    extraAmounts.get(expenseOwingUser.getUser()) - expenseOwingUser.getAmount()
            );
		}
		return null;
	}

}
