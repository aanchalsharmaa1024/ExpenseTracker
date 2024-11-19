package com.aanchal.ExpenseTracker.services.expense;


import com.aanchal.ExpenseTracker.dto.ExpenseDTO;
import com.aanchal.ExpenseTracker.entity.Expense;
import com.aanchal.ExpenseTracker.entity.Income;
import com.aanchal.ExpenseTracker.repository.ExpenseRepository;
import com.aanchal.ExpenseTracker.repository.IncomeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.EnumUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

   private  final ExpenseRepository expenseRepository;


   @Override
    public Expense postExpense(ExpenseDTO expenseDTO){
        return saveOrUpdateExpense(new Expense() , expenseDTO);
    }


    private Expense saveOrUpdateExpense(Expense expense , ExpenseDTO expenseDTO){
       //set properties from dto to entity
        expense.setTitle(expenseDTO.getTitle());
        expense.setDate(expenseDTO.getDate());
        expense.setAmount(expenseDTO.getAmount());
        expense.setCategory(expenseDTO.getCategory());
        expense.setDescription(expenseDTO.getDescription());


        //save the entity to thr database
        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses(){
       return  expenseRepository.findAll().stream()
               .sorted(Comparator.comparing(Expense::getDate).reversed())
               .collect(Collectors.toList());
    }

    public Expense getExpenseById(Long id){
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()){
            return  optionalExpense.get();
        }
        else{
            throw new EntityNotFoundException("Expense is not present with id " + id);
        }
    }

    public Expense updateExpense(Long id , ExpenseDTO expenseDTO){
       Optional<Expense> optionalExpense = expenseRepository.findById( id);
       if(optionalExpense.isPresent()){
           return saveOrUpdateExpense(optionalExpense.get() , expenseDTO);
       }
       else{
           throw  new EntityNotFoundException("Expense is not present with id" + id);
       }
    }

    public void deleteExpense(Long id){
       Optional<Expense> optionalExpense = expenseRepository.findById(id);
       if(optionalExpense.isPresent()){
           expenseRepository.deleteById(id);
       }
       else{
           throw new EntityNotFoundException("Expense is not present with id "+ id);
       }
    }
}
