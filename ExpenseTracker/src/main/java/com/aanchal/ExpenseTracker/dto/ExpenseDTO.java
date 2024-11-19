package com.aanchal.ExpenseTracker.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Data
public class ExpenseDTO
{
    private Long id;
    private String title;
    private String description;
    private  String category;
    private LocalDate date;
    private Integer amount;

}
