package com.joseatorralba.ddd.personalaccounting.domain.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.joseatorralba.ddd.personalaccounting.domain.exceptions.BalanceIsNotEnoughException;
import com.joseatorralba.ddd.personalaccounting.domain.objectvalues.Category;

@ExtendWith(MockitoExtension.class)
public class AccountTest {
	
	private Account account;
	
	@BeforeEach
	public void init()	{
		account = new Account("Account Name", 100.0);		
	}
	
	@Test
	public void givenNewAccount_whenAccountIsCreated_thenMinInfoIsRequired_test()	{
		assertNotNull(account.getName());
		assertNotNull(account.getInitialBalance());
		assertEquals(100, account.getInitialBalance());
		assertNotNull(account.getEntries());
		assertEquals(0, account.getEntries().size());		
		assertEquals(100, account.getBalance());
	}
	
	@Test
	public void givenAccount_whenAddEntry_thenBalancesAreChanged_test() throws BalanceIsNotEnoughException	{
		account.addEntry("apples", -10.5, Category.MARKET);
		assertEquals(89.5, account.getBalance());		
		
		account.addEntry("gift received", -5.5, Category.GIFTS);
		assertEquals(84.0, account.getBalance());
		
		assertEquals(-10.5, account.getBalance(Category.MARKET));
		assertEquals(-5.5, account.getBalance(Category.GIFTS));
	}
	
	@Test
	public void givenAccount_whenAddNegativeEntryAndBalanceIsNotEnough_thenThrowsException_test()	{
		assertThrows(BalanceIsNotEnoughException.class, () -> {
			account.addEntry("buy a phone", -200, Category.ELECTRONICS);
		});
	}
	
}
