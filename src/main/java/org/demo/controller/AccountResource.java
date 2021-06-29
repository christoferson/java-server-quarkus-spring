package org.demo.controller;

import org.demo.model.Account;
import org.demo.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/account", 
	produces = MediaType.APPLICATION_JSON_VALUE, 
	consumes = MediaType.APPLICATION_JSON_VALUE)
public class AccountResource {

	@Autowired
	IAccountRepository repository;
	
	@GetMapping("/{id}")
	public Account find(@PathVariable("id") long id) {

		Account account = repository.findById(id).orElse(null);
		if (account == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Account with ID=%s not found.", id));
		}

		return account;

	}

}
