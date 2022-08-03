package com.joseatorralba.ddd.personalaccounting.domain.entities;

import static com.joseatorralba.ddd.personalaccounting.domain.objectvalues.Category.MARKET;
import static com.joseatorralba.ddd.personalaccounting.domain.objectvalues.EntryType.EXPENSE;
import static com.joseatorralba.ddd.personalaccounting.domain.objectvalues.EntryType.INCOME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.joseatorralba.ddd.personalaccounting.domain.domainservices.BudgetTracking;

@ExtendWith(MockitoExtension.class)
public class BudgetTrackingTest {

	@InjectMocks
	private BudgetTracking tracking;
	
	@Mock 
	private Budget budget;
	
	@Mock
	private CashFlow cashFlow;
	
	@Test
	public void givenBudget_whenGetComplianceByCategory_thenComplianceReturned_test()	{
		when(budget.getAmount(MARKET)).thenReturn(1000.0);
		when(cashFlow.getBalance(MARKET)).thenReturn(800.0);
				
		assertEquals(0.8, tracking.getComplianceStatus(budget, cashFlow, MARKET));
	}
	
	@Test
	public void givenBudget_whenGetComplianceByIncomes_thenComplianceReturned_test()	{
		when(budget.getTotalIncomes()).thenReturn(1000.0);
		when(cashFlow.getBalance(INCOME)).thenReturn(800.0);
				
		assertEquals(0.8, tracking.getComplianceStatus(budget, cashFlow, INCOME));
	}
	
	@Test
	public void givenBudget_whenGetComplianceByExpenses_thenComplianceReturned_test()	{
		when(budget.getTotalExpenses()).thenReturn(1000.0);
		when(cashFlow.getBalance(EXPENSE)).thenReturn(800.0);
				
		assertEquals(0.8, tracking.getComplianceStatus(budget, cashFlow, EXPENSE));
	}
}
