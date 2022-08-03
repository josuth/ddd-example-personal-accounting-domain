package com.joseatorralba.ddd.personalaccounting.domain.entities;

import static com.joseatorralba.ddd.personalaccounting.domain.objectvalues.Category.MARKET;
import static com.joseatorralba.ddd.personalaccounting.domain.objectvalues.Category.RENTS;
import static com.joseatorralba.ddd.personalaccounting.domain.objectvalues.Category.SALARY;
import static com.joseatorralba.ddd.personalaccounting.domain.objectvalues.EntryType.EXPENSE;
import static com.joseatorralba.ddd.personalaccounting.domain.objectvalues.EntryType.INCOME;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class BudgetTest {
	
	Budget budget;
	
	@BeforeEach
	public void init()	{
		budget = new Budget(2022);
	}
	
	@Test
	public void givenBudget_whenAddEntry_thenEntryListGrowing_test()	{
		budget.addEntry(MARKET, 7500.0, EXPENSE);
		
		assertEquals(7500.0, budget.getTotalBalance());
	}
	
	@Test
	public void givenBudget_whenGetIncomes_thenIncomesReturned_test()	{
		
		budget.addEntry(SALARY, 1000, INCOME);
		budget.addEntry(MARKET, 700, EXPENSE);
		budget.addEntry(RENTS, 500, INCOME);
		
		assertEquals(1500, budget.getTotalIncomes());
	}
	
	@Test
	public void givenBudget_whenGetExpenses_thenExpensesReturned_test()	{
		
		budget.addEntry(SALARY, 1000, INCOME);
		budget.addEntry(MARKET, 700, EXPENSE);
		budget.addEntry(RENTS, 500, INCOME);
		
		assertEquals(700, budget.getTotalExpenses());
	}
	
	@Test
	public void givenBudget_whenGetCategoryAmount_thenAmountReturned_test()	{
		budget.addEntry(SALARY, 1000, INCOME);
		budget.addEntry(MARKET, 700, EXPENSE);
		budget.addEntry(RENTS, 500, INCOME);
		
		assertEquals(700, budget.getAmount(MARKET));
	}

}
