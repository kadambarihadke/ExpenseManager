package com.springboot.expencemanager.dto;

import java.util.List;

public class SummaryDto {

	private List<ExpenseViewDto> expenses;
	private Long sum;
    public List<ExpenseViewDto> getExpenses() {
        return expenses;
    }
    public void setExpenses(List<ExpenseViewDto> expenses) {
        this.expenses = expenses;
    }
    public long getSum() {
        return sum;
    }
    public void setSum(Long sum) {
        this.sum = sum;
    }

}
