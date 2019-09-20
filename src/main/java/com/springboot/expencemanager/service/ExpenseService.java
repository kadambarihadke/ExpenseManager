package com.springboot.expencemanager.service;

import java.util.List;

import org.springframework.scheduling.annotation.AsyncResult;

import com.springboot.expencemanager.Entity.Expenses;
import com.springboot.expencemanager.dto.ExpensesDto;
import com.springboot.expencemanager.dto.SummaryDto;

public interface ExpenseService {
	/**
	 *  
	 * Description: will add expenses for particular user
	 * @param expDto ExpenseDto Object
	 */
	public void addExpenses(ExpensesDto expDto);
	
	/**
	 * 
	 * @param id User id
	 * @return Summary in SummaryDto object
	 */
	public SummaryDto display(int id);
	
	/**
	 * @param id User id
	 * @return List of Expenses for particular user 
	 */
	public List<ExpensesDto> showAllExpense(int id);
	
	/**
	 * Description:  will delete expense of specified id
	 * @param id Expense ID
	 */
	public void deleteExpense(int id);
	
	public SummaryDto  usingMultithread(int id);
}
