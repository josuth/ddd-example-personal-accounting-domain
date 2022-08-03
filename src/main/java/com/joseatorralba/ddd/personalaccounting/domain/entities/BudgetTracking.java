package com.joseatorralba.ddd.personalaccounting.domain.entities;

import static com.joseatorralba.ddd.personalaccounting.domain.objectvalues.Category.MARKET;
import static com.joseatorralba.ddd.personalaccounting.domain.objectvalues.EntryBudgetType.INCOME;

import com.joseatorralba.ddd.personalaccounting.domain.objectvalues.Category;
import com.joseatorralba.ddd.personalaccounting.domain.objectvalues.EntryBudgetType;

public class BudgetTracking {

	public double getComplianceStatus(Budget budget, CashFlow cashFlow, Category category) {
		double provided = budget.getAmount(category);
		double current = cashFlow.getBalance(MARKET);
		return current / provided;
	}

	public double getComplianceStatus(Budget budget, CashFlow cashFlow, EntryBudgetType type) {
		double provided = INCOME.equals(type) 
				? budget.getTotalIncomes() 
				: budget.getTotalExpenses();
		double current = cashFlow.getBalance(INCOME);
		return current / provided;
	}

}
