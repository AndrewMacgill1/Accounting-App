
package com.account.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.account.model.Accounts;
import com.account.repository.AccountsRepository;

@RestController
@RequestMapping("api/v1/")
public class AccountController {
	
	@Autowired
	private AccountsRepository accountsRepository;
	
	@RequestMapping(value = "accounts", method = RequestMethod.GET)
	public List<Accounts> list() {
		return accountsRepository.findAll();
	}

	@RequestMapping(value = "accounts", method = RequestMethod.POST)
	public Accounts create(@RequestBody Accounts accounts) {
		return accountsRepository.saveAndFlush(accounts);
	}
	
	@RequestMapping(value = "accounts/{id}", method = RequestMethod.GET)
	public Accounts get(@PathVariable Integer id) {
		return accountsRepository.findOne(id);
	}
	
	@RequestMapping(value = "accounts/{id}", method = RequestMethod.PUT)
	public Accounts update(@PathVariable Integer id, @RequestBody Accounts accounts) {
		Accounts existingAccount = accountsRepository.findOne(id);
		BeanUtils.copyProperties(accounts,existingAccount);
		return accountsRepository.saveAndFlush(existingAccount);
	}
	
	@RequestMapping(value = "accounts/{id}", method = RequestMethod.DELETE)
	public Accounts update(@PathVariable Integer id) {
		Accounts existingAccount = accountsRepository.findOne(id);
		accountsRepository.delete(existingAccount);
		return existingAccount;
	}
}
