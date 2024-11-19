package com.aanchal.ExpenseTracker.services.expense;

import com.aanchal.ExpenseTracker.dto.ExpenseDTO;
import com.aanchal.ExpenseTracker.entity.Expense;

import java.util.List;

public interface ExpenseService {

    public Expense postExpense(ExpenseDTO expenseDTO);

    List<Expense> getAllExpenses();

    Expense getExpenseById(Long id);

    Expense updateExpense(Long id , ExpenseDTO expenseDTO);

    void deleteExpense(Long id);

}
