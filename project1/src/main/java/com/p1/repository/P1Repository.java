package com.p1.repository;

import java.util.List;

import com.p1.modles.*;
public interface P1Repository {
	List<User> findAll();
	User findByName(String name);
	User findById(int id);
	void insert(User c);
	void update(User c);
	void delete(User c);

}
