package com.BankAPI.repository;

import java.util.List;


import com.BankAPI.models.Account;
import com.BankAPI.models.User;

public interface Repository {
	List<User> finduser();
	User finduserById(int id);
	User finduserByName(String name);
	public void insertUser(User user);
	void updateUser(User user, int id);

	
	public void insertToAccount(Account acount, int user_id);
	Account findAccountById(int id);
	void updateAccountBalnce(double amount, int accountId);
	Account getUserBalance(int accountId);
	List<Account> findAccount();
	List<Account> findAccountByStatusID(int statusid);
	List<Account> findAccountByuser(int userid);

	void updateAccount(Account account, int id);
}
