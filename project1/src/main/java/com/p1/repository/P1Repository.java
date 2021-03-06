package com.p1.repository;

import java.util.List;

import com.p1.modles.*;
public interface P1Repository {
	List<User> findAll();
	User findByName(String name);
	User findByEmail(String email);
	User findById(int id);
	void insert(Object c);
	void update(Object c);
	void delete(User c);
	List<Reimbursement> findPending();
	List<User> finduser(int id);
	List<Reimbursement> findapproved();
}
