package com.joseatorralba.ddd.personalaccounting.domain.exceptions;

public class BalanceIsNotEnoughException extends Exception {

	private static final long serialVersionUID = 7693627276885375141L;
	
	public BalanceIsNotEnoughException(String account, double balance)	{
		super(String.format("Balance of %s is not enough. Balance = %f", account, balance));
	}

}
