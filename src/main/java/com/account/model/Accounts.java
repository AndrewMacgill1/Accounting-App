package com.account.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Accounts {
	
	
	String firstname;
	String surname;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer accountId;

	public Accounts() { }

	public Accounts(String firstname, String surname, Integer accountId) {
		this.firstname = firstname;
		this.surname = surname;
		this.accountId = accountId;
		}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	
}
