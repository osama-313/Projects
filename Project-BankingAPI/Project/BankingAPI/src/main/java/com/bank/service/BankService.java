package com.bank.service;

import java.util.List;

import com.BankAPI.models.Account;
import com.BankAPI.models.User;
import com.BankAPI.repository.Repository;
import com.BankAPI.repository.RepositoryImpl;

public class BankService {
private Repository repository;
	
	public BankService() {
		this.repository = new RepositoryImpl();
	}
	
	public List<User> finduser(){
		return this.repository.finduser();
	}
	
	public User finduserById(int id) {
		return this.repository.finduserById(id);
	}
	public User finduserByName(String name) {
		return this.repository.finduserByName(name);
	}
	public  void insertUser(User user) {
		this.repository.insertUser(user);
	}
	public void insertToAccount(Account acount , int userid)
	{
		this.repository.insertToAccount(acount, userid);
	}
	public void updateAccountBalnce(double amount, int accountId)
	{
		this.repository.updateAccountBalnce(amount, accountId);
	}
	public Account getUserBalance(int accountId)
	{
		return this.repository.getUserBalance(accountId);
	}
	public void UpdateUser(User user, int id) 
	{
		 this.repository.updateUser(user, id);
	}
	public List<Account> findAccount(){
		return this.repository.findAccount();
	}
	public Account FindAccountByID(int id) {
		return this.repository.findAccountById(id);
	}
	public List<Account> findAccountByStatusid(int statusid)
	{
		return this.repository.findAccountByStatusID(statusid);
	}
	public List<Account> findAccountByuser(int userid)
	{
		return this.repository.findAccountByuser(userid);
	}
	public void updateAccount(Account account, int id)
	{
		this.repository.updateAccount(account, id);
	}

}
