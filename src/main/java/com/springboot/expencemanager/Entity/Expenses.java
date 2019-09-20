package com.springboot.expencemanager.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "expenses_details")
public class Expenses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;

	private String expensetitle;
	private Date date;
	private int amount;
	private String description;
	private String category;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private User user;
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getEid() {
		return eid;
	}



	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	public String getExpenseTitle() {
		return expensetitle;
	}

	public void setExpensetitle(String expenseTitle) {
		this.expensetitle = expenseTitle;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
