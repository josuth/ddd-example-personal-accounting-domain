package com.joseatorralba.ddd.personalaccounting.domain.objectvalues;

import static com.joseatorralba.ddd.personalaccounting.domain.objectvalues.EntryBudgetType.EXPENSE;
import static com.joseatorralba.ddd.personalaccounting.domain.objectvalues.EntryBudgetType.INCOME;

import lombok.Getter;

public enum Category {
	
	// INCOMES
	SALARY(INCOME),
	RENTS(INCOME),
	TAX_REFUNDS(INCOME),
	PRICES(INCOME),
	
	// EXPENSES
	MARKET(EXPENSE),
	HOUSE(EXPENSE),
	CAR(EXPENSE),
	SUPPLIES(EXPENSE),
	CLOTHING(EXPENSE),
	ELECTRONICS(EXPENSE),
	HEALTH(EXPENSE),
	SPORT(EXPENSE),
	LEISURE(EXPENSE),
	HOLLIDAYS(EXPENSE),
	GIFTS(EXPENSE);
	
	@Getter
	private EntryBudgetType type;
	
	private Category(EntryBudgetType type)	{
		this.type = type;
	}
	
}
