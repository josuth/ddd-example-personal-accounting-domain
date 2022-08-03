package com.joseatorralba.ddd.personalaccounting.domain.domainservices;

import static com.joseatorralba.ddd.personalaccounting.domain.objectvalues.Category.MARKET;
import static com.joseatorralba.ddd.personalaccounting.domain.objectvalues.EntryType.INCOME;

import com.joseatorralba.ddd.personalaccounting.domain.entities.Budget;
import com.joseatorralba.ddd.personalaccounting.domain.entities.CashFlow;
import com.joseatorralba.ddd.personalaccounting.domain.objectvalues.Category;
import com.joseatorralba.ddd.personalaccounting.domain.objectvalues.EntryType;

public class BudgetTracking {

	public double getComplianceStatus(Budget budget, CashFlow cashFlow, Category category) {
		double provided = budget.getAmount(category);
		double current = cashFlow.getBalance(MARKET);
		return current / provided;
	}

	public double getComplianceStatus(Budget budget, CashFlow cashFlow, EntryType type) {
		double provided = INCOME.equals(type) 
				? budget.getTotalIncomes() 
				: budget.getTotalExpenses();
		double current = cashFlow.getBalance(type);
		return current / provided;
	}

}
