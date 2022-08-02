package com.joseatorralba.ddd.personalaccounting.domain.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.joseatorralba.ddd.personalaccounting.domain.exceptions.AccountDoesNotExistException;
import com.joseatorralba.ddd.personalaccounting.domain.objectvalues.Account;
import com.joseatorralba.ddd.personalaccounting.domain.objectvalues.Category;

@ExtendWith(MockitoExtension.class)
public class ClassFlowTest {

	@InjectMocks
	CashFlow cashFlow;
	
	@Mock
	Account account;
	
	@BeforeEach
	public void init()	{
		cashFlow = new CashFlow(List.of(account));
	}
	
	@Test
	public void givenCashFlow_whenGetBalance_thenBalanceIsReturned_test()	{
		when(account.getInitialBalance()).thenReturn(100.0);
		
		assertEquals(100.0, cashFlow.getBalance());
	}
	
	@Test
	public void givenCashFlow_whenAddEntry_thenBalancesAreChanged_test() throws AccountDoesNotExistException	{
		when(account.getAccountNumber()).thenReturn("12341234001234567890");
		when(account.getInitialBalance()).thenReturn(100.0);
		
		cashFlow.addEntry("apples", -10.5, Category.MARKET, "12341234001234567890");
		assertEquals(89.5, cashFlow.getBalance());		
		
		cashFlow.addEntry("gift received", -5.5, Category.GIFTS, "12341234001234567890");
		assertEquals(84.0, cashFlow.getBalance());
		
		assertEquals(-10.5, cashFlow.getBalance(Category.MARKET));
		assertEquals(-5.5, cashFlow.getBalance(Category.GIFTS));
	}
	
	@Test
	public void givenCashFlow_whenAddEntry_thenAccountBalanceIsChanged_test() throws AccountDoesNotExistException	{
		when(account.getAccountNumber()).thenReturn("12341234001234567890");
		when(account.getInitialBalance()).thenReturn(100.0);
		
		cashFlow.addEntry("apples", -10.5, Category.MARKET, "12341234001234567890");
		
		assertEquals(89.5, cashFlow.getBalance("12341234001234567890"));		
	}

	@Test
	public void givenCashFlow_whenAddEntryWithUnknownAccount_thenThrowException_test() throws AccountDoesNotExistException	{
		when(account.getAccountNumber()).thenReturn("12341234001234567890");
		
		assertThrows(AccountDoesNotExistException.class, () -> {
			cashFlow.addEntry("apples", -10.5, Category.MARKET, "00000000000000000000");
		});

	}
}
