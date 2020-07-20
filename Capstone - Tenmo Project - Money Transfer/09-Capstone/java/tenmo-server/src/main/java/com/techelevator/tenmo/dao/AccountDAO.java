package com.techelevator.tenmo.dao;

import java.math.BigDecimal;

public interface AccountDAO {
	
	BigDecimal getAccountBalance(String userName);

	long getAccountNumber(long userId);
	
}
