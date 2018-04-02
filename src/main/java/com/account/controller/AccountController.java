
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
	
	@RequestMapping(value = "accounts/{accountId}", method = RequestMethod.GET)
	public Accounts get(@PathVariable Integer accountId) {
		return accountsRepository.findOne(accountId);
	}
	
	@RequestMapping(value = "accounts/{accountId}", method = RequestMethod.PUT)
	public Accounts update(@PathVariable Integer accountId, @RequestBody Accounts accounts) {
		Accounts existingAccount = accountsRepository.findOne(accountId);
		BeanUtils.copyProperties(accounts,existingAccount);
		return accountsRepository.saveAndFlush(existingAccount);
	}
	
	@RequestMapping(value = "accounts/{accountId}", method = RequestMethod.DELETE)
	public Accounts update(@PathVariable Integer accountId) {
		Accounts existingAccount = accountsRepository.findOne(accountId);
		accountsRepository.delete(existingAccount);
		return existingAccount;
	}
}
