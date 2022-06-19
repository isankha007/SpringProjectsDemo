package com.sankha.splitewise.service.settleup;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sankha.splitewise.model.Expense;
import com.sankha.splitewise.model.ExpenseOwingUser;
import com.sankha.splitewise.model.ExpensePayingUser;
import com.sankha.splitewise.model.Group;
import com.sankha.splitewise.repository.ExpenseOwingUserRepository;
import com.sankha.splitewise.repository.ExpensePayingUserRepository;
import com.sankha.splitewise.repository.GroupRepository;
import com.sankha.splitewise.service.settleup.strategies.SettleUpTransactionCalculatorStrategy;

@Service
public class SettleUpService {
	@Autowired
    private SettleUpTransactionCalculatorStrategy settleUpTransactionCalculatorStrategy;
    private GroupRepository groupRepository;
    private ExpenseOwingUserRepository expenseOwingUserRepository;
    private ExpensePayingUserRepository expensePayingUserRepository;
    
    public List<Transaction> settleUpUser(Long userId) {
        return null;
    }
    
    public List<Transaction> settleUpGroup(Long groupId){
    	Optional<Group> groupOptional = groupRepository.findById(groupId);

        if (!groupOptional.isPresent()) {
            // throw some exception
            System.out.println("No group with that id");
        }

        Group group = groupOptional.get();

        List<ExpensePayingUser> expensePayingUsers = new ArrayList<>();
        List<ExpenseOwingUser> expenseOwingUsers = new ArrayList<>();

        for (Expense expense: group.getExpenses()) {
            expensePayingUsers.addAll(expensePayingUserRepository.findAllByExpense(expense));
            expenseOwingUsers.addAll(expenseOwingUserRepository.findAllByExpense(expense));
        }
        return settleUpTransactionCalculatorStrategy.getTransactions(
                expensePayingUsers,
                expenseOwingUsers
        );
    }

}
