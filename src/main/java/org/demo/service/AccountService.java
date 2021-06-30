package org.demo.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.demo.ApplicationException;
import org.demo.model.Account;
import org.demo.repository.IAccountRepository;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

	private static final Logger LOG = Logger.getLogger(AccountService.class);
	
	@Autowired
	IAccountRepository repository;

	@Override
	public Account find(long id) {

		Account account = repository.findById(id).orElse(null);
		if (account == null) {
			throw new ApplicationException(String.format("Failed to Find Account with ID='%s'", id));
		}
	
		return account;

	}
	
	@Override
	@Transactional
	public Account deposit(long id, BigDecimal amount) {
		LOG.debug(String.format("Depositing %s to Account %s", amount, id));
		if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
			throw new ApplicationException("Amount must be greater than 0");
		}
		Account account = repository.findById(id).orElse(null);
		if (account == null) {
			throw new ApplicationException("Cannot find account");
		}
		BigDecimal newAmount = account.getBalance().add(amount);
		account.setBalance(newAmount);
		LOG.debug(String.format("Deposited %s to Account %s", amount, id));
		return account;
	}
	
}
