package com.joseatorralba.ddd.personalaccounting.domain.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.joseatorralba.ddd.personalaccounting.domain.exceptions.AccountDoesNotExistException;
import com.joseatorralba.ddd.personalaccounting.domain.objectvalues.Account;
import com.joseatorralba.ddd.personalaccounting.domain.objectvalues.Category;
import com.joseatorralba.ddd.personalaccounting.domain.objectvalues.Entry;
import com.joseatorralba.ddd.personalaccounting.domain.objectvalues.EntryType;

public class CashFlow {

	List<Account> accountList;
	
	List<Entry> entries;
	
	
	public CashFlow(List<Account> accounts) {
		this.accountList = accounts;
		this.entries = new ArrayList<Entry>();
	}

	public void addEntry(String description, double amount, Category category, String accountNumber) throws AccountDoesNotExistException {
		Account account = getAccountInfo(accountNumber);
		entries.add(Entry.builder()
				.date(LocalDate.now())
				.amount(amount)
				.category(category)
				.account(account)
				.build());
	}

	public Double getBalance() {
		double initialBalance = this.accountList.stream()
				.mapToDouble(Account::getInitialBalance)
				.sum();
		
		return initialBalance + entries.stream()
				.mapToDouble(Entry::getAmount)
				.sum();
	}

	public Double getBalance(Category category) {
		return entries.stream()
			.filter(e -> e.getCategory().equals(category))
			.mapToDouble(Entry::getAmount)
			.sum();
	}
	
	public Double getBalance(EntryType type) {
		return entries.stream()
				.filter(e -> e.getCategory().getType().equals(type))
				.mapToDouble(Entry::getAmount)
				.sum();
	}

	public Double getBalance(String accountNumber) throws AccountDoesNotExistException {
		Account account = getAccountInfo(accountNumber);
		return account.getInitialBalance() + entries.stream()
				.mapToDouble(Entry::getAmount)
				.sum();
	}
	
	public Account getAccountInfo(String accountNumber) throws AccountDoesNotExistException	{
		Optional<Account> op = accountList.stream()
				.filter(a -> a.getAccountNumber().equals(accountNumber))
				.findFirst();
		if (op.isPresent())	{
			return op.get();
		}
		throw new AccountDoesNotExistException(accountNumber);
	}

}
