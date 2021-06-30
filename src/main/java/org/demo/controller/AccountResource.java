package org.demo.controller;

import org.demo.model.Account;
import org.demo.repository.IAccountRepository;
import org.demo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/account", 
	produces = MediaType.APPLICATION_JSON_VALUE, 
	consumes = MediaType.APPLICATION_JSON_VALUE)
public class AccountResource {

	@Autowired
	IAccountRepository repository;
	
	@Autowired
	IAccountService service;
	
	@GetMapping("/{id}")
	public Account find(@PathVariable("id") long id) {

		Account account = service.find(id);

		return account;

	}

}
