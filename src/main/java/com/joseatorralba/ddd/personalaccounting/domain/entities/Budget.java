package com.joseatorralba.ddd.personalaccounting.domain.entities;

import java.util.ArrayList;
import java.util.List;

import com.joseatorralba.ddd.personalaccounting.domain.objectvalues.Category;
import com.joseatorralba.ddd.personalaccounting.domain.objectvalues.EntryBudget;
import com.joseatorralba.ddd.personalaccounting.domain.objectvalues.EntryType;

public class Budget {

	int year;
	
	List<EntryBudget> entries;
	
	public Budget(int year)	{
		this.year = year;
		this.entries = new ArrayList<>();
	}

	public void addEntry(Category category, double amount, EntryType type) {
		this.entries.add(EntryBudget.builder()
				.category(category)
				.amount(amount)
				.type(type)
				.build());
	}

	public double getTotalBalance() {
		return this.entries.stream()
			.mapToDouble(EntryBudget::getAmount)
			.sum();
	}

	public double getTotalIncomes() {
		return getTotalBalanceOfType(EntryType.INCOME);
	}

	public double getTotalExpenses() {
		return getTotalBalanceOfType(EntryType.EXPENSE);
	}
	
	
	
	private double getTotalBalanceOfType(EntryType type) {
		return this.entries.stream()
				.filter(e -> type.equals(e.getType()))
				.mapToDouble(EntryBudget::getAmount)
				.sum();
	}

	public double getAmount(Category category) {
		return this.entries.stream()
				.filter(e -> category.equals(e.getCategory()))
				.mapToDouble(EntryBudget::getAmount)
				.sum();
	}
	
}
