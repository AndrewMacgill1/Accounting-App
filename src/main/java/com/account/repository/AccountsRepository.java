package com.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.model.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts, Integer> {

}
