package com.joseatorralba.ddd.personalaccounting.domain.objectvalues;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Account {

	String name;
	
	String accountNumber;
	
	double initialBalance;

}
