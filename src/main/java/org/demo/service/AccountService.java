package org.demo.service;

import org.demo.ApplicationException;
import org.demo.model.Account;
import org.demo.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

	@Autowired
	IAccountRepository repository;
	
	@Override
	public Account find(long id) {

		Account account = repository.findById(id)
				.orElseThrow(() -> new ApplicationException());
	
		return account;

	}
	
}
