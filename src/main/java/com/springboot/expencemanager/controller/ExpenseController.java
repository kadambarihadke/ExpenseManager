package com.springboot.expencemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.expencemanager.dto.ExpensesDto;
import com.springboot.expencemanager.dto.SummaryDto;
import com.springboot.expencemanager.service.ExpenseService;

/**
 * Class Expense Controller
 * Will provide mapping between UI and service layer 
 * Maps to /expenses 
 */


@RestController
@RequestMapping("/expense")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;
	
	/**
	 * Method name:addExpenses
	 * @param ExpenseDto object as input
	 * @return String  message
	 */
	@PostMapping("/addexpenses")
	public String addExpense(@RequestBody ExpensesDto expenses)
	{
		expenseService.addExpenses(expenses);
		return "sucessfully added";
	}
	
	/**
	 * Method name:SummaryDto
	 * @param userid
	 * @return summary of expenses 
	 */
	@GetMapping("/dashboard/{id}")
	public SummaryDto displayExp(@PathVariable(value = "id") int id) {
		return expenseService.display(id);
	}
	
	@GetMapping("/displayExpenses/{id}")
	public List<ExpensesDto> displayAllExp(@PathVariable(value = "id") int id) {
		return expenseService.showAllExpense(id);
	}
	
	@GetMapping("/dashboard1/{id}")
	public SummaryDto asyncString(@PathVariable(value = "id") int id) {
		return expenseService.usingMultithread(id);
	}
	
	
	/**
	 * Method Name: deleteExpense
	 * @param Expense id
	 * @return status code
	 */
	@DeleteMapping("/deletebyId/{id}")
	public ResponseEntity<ExpensesDto> deleteExpense(@PathVariable(value = "id") int id) {
		expenseService.deleteExpense(id);
		return ResponseEntity.ok().build();
	}
}
