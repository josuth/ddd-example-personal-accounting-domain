package com.joseatorralba.ddd.personalaccounting.domain.objectvalues;

import static com.joseatorralba.ddd.personalaccounting.domain.objectvalues.EntryType.EXPENSE;
import static com.joseatorralba.ddd.personalaccounting.domain.objectvalues.EntryType.INCOME;

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
	private EntryType type;
	
	private Category(EntryType type)	{
		this.type = type;
	}
	
}
