package com.springboot.expencemanager.dao;

import java.util.List;
import java.util.Optional;

import com.springboot.expencemanager.Entity.Expenses;
import com.springboot.expencemanager.Entity.User;
import com.springboot.expencemanager.dto.ExpensesDto;
import com.springboot.expencemanager.dto.SummaryDto;

public interface ExpenseDAO {

	/**
	 * 
	 * @param exp Expense EntityObject
	 */
	public void addExpenses(Expenses exp);
	/**
	 * Description:SummaryDto has Sum of all expanses and  monthwise summation for user
	 * @param id
	 * @return SummaryDto
	 */
	
	public SummaryDto displayExpenses(int id);
	/**
	 * 
	 * @param id User id
	 * @return list of expenses for that user
	 */
	
	public List<Expenses> showAllExpense(int id);
	/**
	 * 
	 * @param id ExpenseId
	 */
	public void delete(int id);
	
	public Expenses findExpense(int expId);
}
