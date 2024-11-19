package com.aanchal.ExpenseTracker.services.income;

import com.aanchal.ExpenseTracker.dto.IncomeDTO;
import com.aanchal.ExpenseTracker.entity.Income;

import java.util.List;

public interface IncomeService{

    Income postIncome(IncomeDTO incomeDTO);

    public List<IncomeDTO> getAllIncomes();

    Income updateIncome(Long id , IncomeDTO incomeDTO);

    IncomeDTO getIncomeById(Long id);

    void deleteIncome(Long id);

}
