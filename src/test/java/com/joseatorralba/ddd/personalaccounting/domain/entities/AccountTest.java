package com.joseatorralba.ddd.personalaccounting.domain.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.joseatorralba.ddd.personalaccounting.domain.objectvalues.Account;

@ExtendWith(MockitoExtension.class)
public class AccountTest {
	
	private Account account;
	
	@BeforeEach
	public void init()	{
		account = Account.builder()
				.name("Savings")
				.initialBalance(100.0)
				.accountNumber("12341234001234567890")
				.build();		
	}
	
	@Test
	public void givenNewAccount_whenAccountIsCreated_thenMinInfoIsRequired_test()	{
		assertEquals("Savings", account.getName());
		assertEquals(100, account.getInitialBalance());
	}
	
}
