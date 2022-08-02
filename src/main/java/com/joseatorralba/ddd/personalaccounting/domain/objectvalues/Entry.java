package com.joseatorralba.ddd.personalaccounting.domain.objectvalues;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Entry {

	LocalDate date;
	String description;
	double amount;
	Category category;
	Account account;
	
}
