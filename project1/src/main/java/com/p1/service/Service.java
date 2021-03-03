package com.p1.service;

import java.util.List;

import com.p1.modles.Reimbursement;
import com.p1.modles.User;
import com.p1.repository.P1Repository;
import com.p1.repository.P1RepositoryImpl;

public class Service {
private P1Repository repo;
	
	public Service() {
		repo = new P1RepositoryImpl();
	}
	
	public void insert(Object c) {
		this.repo.insert(c);
	}
	
	public void delete(User c) {
		this.repo.delete(c);
	}
	
	public List<User> findAll(){
		return this.repo.findAll();
	}
	
	public User findById(int id) {
		return this.repo.findById(id);
	}
	
	public void update(User c) {
		this.repo.update(c);
	}
	
	public User findByName(String name) {
		return this.repo.findByName(name);
	}
	
	public User findByEmail(String email) {
		return this.repo.findByEmail(email);

	}
	public List<Reimbursement> findPending() {
		return this.repo.findPending();
	}
	public List<User> finduser(int id) {
		return this.repo.finduser(id);

	}

}
