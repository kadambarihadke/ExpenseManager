package com.springboot.expencemanager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.expencemanager.Conversion.ConversionInterface;
import com.springboot.expencemanager.Entity.Expenses;
import com.springboot.expencemanager.dao.ExpenseDAO;
import com.springboot.expencemanager.dao.UserDaoImpl;
import com.springboot.expencemanager.dto.ExpensesDto;
import com.springboot.expencemanager.dto.SummaryDto;
import com.springboot.expencemanager.exceptions.RecordNotFoundException;
/**
 * Description: Deals with expenses and conversion to Dto and Entity done as required
 * @author Kadambari
 *
 */
@Service
public class ExpenseServiceImpl implements ExpenseService,ConversionInterface
	<Expenses, ExpensesDto> {
	
	@Autowired
	private ExpenseDAO expenseDao;
	
	
	private SummaryDto summaryDto;
	
	@Autowired
	UserDaoImpl userDao;
	
	@Override
	public void addExpenses(ExpensesDto expDto) {
		Expenses exp=new Expenses();
		translateToEntity(exp, expDto);
		expenseDao.addExpenses(exp);
	
	}

	@Override
	public List<ExpensesDto> showAllExpense(int id) {
		
		List<Expenses> exp=expenseDao.showAllExpense(id);
		List<ExpensesDto> expDto=translateToDtos(exp);
		return expDto;
	}

	@Override
	public void deleteExpense(int id) {
		Expenses exp=expenseDao.findExpense(id);
		if(exp==null) {
			throw new RecordNotFoundException("Expense Id invalid : "+id);
		}
		expenseDao.delete(id);
		
	}
	
	@Override
	public SummaryDto display(int id){
		summaryDto=expenseDao.displayExpenses(id);
		if(summaryDto.getExpenses()==null) {
			throw new RecordNotFoundException("User Id invalid : "+id);
		}
		return summaryDto;
	}
	
	
	public SummaryDto usingMultithread(int id) {
		ExecutorService executorService=  Executors.newFixedThreadPool(2);
		Runnable task1=new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Thread name"+Thread.currentThread().getName());
				try {
					 summaryDto=expenseDao.displayExpenses(id);
				}
				catch(Exception e) {
					
				}
				
			}
		};
		executorService.submit(task1);
		return  summaryDto;
	}
	
	@Override
	public Expenses translateToEntity(Expenses expense, ExpensesDto dto) {
		expense.setUser(userDao.findUser(dto.getUserId()));
		expense.setExpensetitle(dto.getExpenseTitle());
		expense.setCategory(dto.getCategory());
		expense.setdescription(dto.getdescription());
		expense.setDate(dto.getDate());
		expense.setAmount(dto.getAmount());
        return expense;
		
	}
	
	@Override
	public ExpensesDto translateToDTO(Expenses entity, ExpensesDto dto) {
		 dto.setExpenseTitle(entity.getExpenseTitle());
	        dto.setCategory(entity.getCategory());
	        dto.setdescription(entity.getdescription());
	        dto.setDate(entity.getDate());
	        dto.setAmount(entity.getAmount());
	        return dto;
	}

	@Override
	public List<ExpensesDto> translateToDtos(List<Expenses> entity) {
		List<ExpensesDto> expDto=new ArrayList<ExpensesDto>();
		for (Object obj:entity) {
			 Object[] obj1 = (Object[])obj;
			ExpensesDto dto=new ExpensesDto();
			dto.setDate((java.sql.Date)obj1[1]);
			dto.setAmount((int)obj1[2]);
			dto.setExpenseTitle((String)obj1[0]);
			dto.setCategory((String)obj1[4]);
			dto.setdescription((String)obj1[3]);
			//dto.setdescription((String)obj1[5]);
			expDto.add(dto);
			}	
		return expDto;
	
	}
}
