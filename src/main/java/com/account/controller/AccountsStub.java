package com.account.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.account.model.Accounts;

public class AccountsStub {
	private static Map<Integer, Accounts> accounts = new HashMap<Integer, Accounts>();
	private static Integer idIndex = 3;

	//populate initial wrecks
/*	static {
		Accounts a = new Accounts( "Alice", "Smith", 1000);
		accounts.put(1, a);
		Accounts b = new Accounts( "Bob", "Richardson", 1001);
		accounts.put(1, b);
		Accounts c = new Accounts( "Charlie", "Johnson", 1002);
		accounts.put(1, c);
	}*/

	public static List<Accounts> list() {
		return new ArrayList<Accounts>(accounts.values());
	}

	public static Accounts create(Accounts account) {
		idIndex += idIndex;
		account.setAccountId(idIndex);
		accounts.put(idIndex, account);
		return account;
	}

	public static Accounts get(Integer accountId) {
		return accounts.get(accountId);
	}

	public static Accounts update(Integer accountId, Accounts account) {
		accounts.put(accountId, account);
		return account;
	}

	public static Accounts delete(Integer accountId) {
		return accounts.remove(accountId);
	}
}