package com.joseatorralba.ddd.personalaccounting.domain.entities;

import java.util.ArrayList;
import java.util.List;

import com.joseatorralba.ddd.personalaccounting.domain.objectvalues.Category;
import com.joseatorralba.ddd.personalaccounting.domain.objectvalues.EntryBudget;
import com.joseatorralba.ddd.personalaccounting.domain.objectvalues.EntryBudgetType;

public class Budget {

	int year;
	
	List<EntryBudget> entries;
	
	public Budget(int year)	{
		this.year = year;
		this.entries = new ArrayList<>();
	}

	public void addEntry(Category category, double amount, EntryBudgetType type) {
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
		return getTotalBalanceOfType(EntryBudgetType.INCOME);
	}

	public double getTotalExpenses() {
		return getTotalBalanceOfType(EntryBudgetType.EXPENSE);
	}
	
	private double getTotalBalanceOfType(EntryBudgetType type) {
		return this.entries.stream()
				.filter(e -> type.equals(e.getType()))
				.mapToDouble(EntryBudget::getAmount)
				.sum();
	}
	
}
