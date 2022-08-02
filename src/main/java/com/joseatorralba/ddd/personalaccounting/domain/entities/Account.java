package com.joseatorralba.ddd.personalaccounting.domain.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.joseatorralba.ddd.personalaccounting.domain.exceptions.BalanceIsNotEnoughException;
import com.joseatorralba.ddd.personalaccounting.domain.objectvalues.Category;
import com.joseatorralba.ddd.personalaccounting.domain.objectvalues.Entry;

import lombok.Getter;

@Getter
public class Account {

	String name;
	
	double initialBalance;
	
	List<Entry> entries;
	
	public Account(String name, double initialBalance) {
		this.name = name;
		this.initialBalance = initialBalance;
		this.entries = new ArrayList<Entry>();
	}

	public void addEntry(String description, double amount, Category category) throws BalanceIsNotEnoughException {
		entries.add(Entry.builder()
				.date(LocalDate.now())
				.amount(amount)
				.category(category)
				.build());
		Double balance = getBalance();
		if (balance < 0.0)	{
			throw new BalanceIsNotEnoughException(this.name, balance);
		}
	}

	public Double getBalance() {
		return this.initialBalance + entries.stream()
			.mapToDouble(Entry::getAmount)
			.sum();
	}

	public Double getBalance(Category category) {
		return entries.stream()
			.filter(e -> e.getCategory().equals(category))
			.mapToDouble(Entry::getAmount)
			.sum();
	}

}
