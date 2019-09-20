package com.springboot.expencemanager.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.expencemanager.Conversion.ConversionInterface;
import com.springboot.expencemanager.Entity.Expenses;
import com.springboot.expencemanager.Entity.User;
import com.springboot.expencemanager.dto.ExpenseViewDto;
import com.springboot.expencemanager.dto.ExpensesDto;
import com.springboot.expencemanager.dto.SummaryDto;
import com.springboot.expencemanager.exceptions.RecordNotFoundException;

@Repository
@Transactional
public class ExpenseDaoImpl implements ExpenseDAO {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	UserDaoImpl userDao;

	@Override
	public void addExpenses(Expenses exp) {
		entityManager.persist(exp);
	}
	@Override
	public Expenses findExpense(int expId) {
		return entityManager.find(Expenses.class, expId);
	}


	@Override
	public SummaryDto displayExpenses(int id) throws RecordNotFoundException {
		Query query1 = entityManager.createQuery(
		"select DATE_FORMAT(Date,'%b %Y') as " + "MonthAndYear,sum(amount) as Sum from "+ "Expenses"
		+ " where user.id ="+ id + " group by month(Date), year(Date)");

		Query query = entityManager.createQuery("select sum(amount) from Expenses where user.id=" 
		+ id);
		// query1.setFirstResult(num);
		// query1.setMaxResults(2);
		List<ExpenseViewDto> expense = query1.getResultList();
		SummaryDto summary = new SummaryDto();
		if (expense != null) {
			summary.setSum((Long) query.getResultList().get(0));
			summary.setExpenses(expense);
		}
		return summary;
	}

	@Override
	public List<Expenses> showAllExpense(int id) {
	        Query query = (Query) entityManager.createQuery("select expensetitle,date,amount,"
	        		+ "description,category,eid from Expenses where user.id = " + id);
	        List<Expenses> expenseList = query.getResultList();
	        return expenseList;
	    }

	@Override
	public void delete(int id) {
		Expenses exp= entityManager.find(Expenses.class,id);
		entityManager.remove(exp);
		
	}

}
