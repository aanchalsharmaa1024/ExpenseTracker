package com.aanchal.ExpenseTracker.dto;

import com.aanchal.ExpenseTracker.entity.Expense;
import com.aanchal.ExpenseTracker.entity.Income;
import lombok.Data;

import java.util.List;

@Data
public class GraphDTO {

    private List<Expense> expenseList;
    private List<Income> incomeList;
}
