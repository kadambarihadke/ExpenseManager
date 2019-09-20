package com.springboot.expencemanager.dto;

import java.sql.Date;

import com.springboot.expencemanager.Entity.User;

public class ExpensesDto {
	
	private int eid;
	private String expenseTitle;
	private String category;
	private Date date;
	private int amount;
	private String description;
	private int userId;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getExpenseTitle() {
		return expenseTitle;
	}
	public void setExpenseTitle(String expenseTitle) {
		this.expenseTitle = expenseTitle;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		description = description;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
