package com.joseatorralba.ddd.personalaccounting.domain.exceptions;

public class AccountDoesNotExistException extends Exception {

	private static final long serialVersionUID = -5809039450058493937L;

	public AccountDoesNotExistException(String accountNumber)	{
		super(String.format("account %s does not exists", accountNumber));
	}
}
