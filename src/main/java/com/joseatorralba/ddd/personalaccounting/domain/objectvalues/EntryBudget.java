package com.joseatorralba.ddd.personalaccounting.domain.objectvalues;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EntryBudget {

	Category category;
	
	double amount;
	
	EntryBudgetType type;
	
}
