package org.demo.service;

import java.math.BigDecimal;

import org.demo.model.Account;

public interface IAccountService {
	
	Account find(long id);
	
	Account deposit(long id, BigDecimal amount);
	
}
