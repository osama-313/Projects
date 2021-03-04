package com.p1.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.p1.modles.Reimbursement;
import com.p1.modles.User;
import com.p1.util.HibernateSessionFactory;

public class P1RepositoryImpl implements P1Repository {

	public List<User> findAll() {
		List<User> users = new ArrayList<>();

		Session s = null;
		Transaction tx = null;

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
		
			users = s.createQuery("FROM User", User.class).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}

		return users;

	}

	public User findByName(String name) {
		User c = null;
		Session s = null;
		Transaction tx = null;

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			c =  (User) s.createQuery("from User u where u.firstname = :firstname")
					.setParameter("firstname", name)
					.getSingleResult();
			
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}

		return c;
	}

	public User findById(int id) {
		User c = null;
		Session s = null;
		Transaction tx = null;

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			c = s.get(User.class, id);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return c;
	}

	public void insert(Object c) {
		
		Session s = null;

		
		Transaction tx = null;

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
		
			s.save(c);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
	}

	public void update(Object c) {
		Session s = null;
		Transaction tx = null;

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			s.update(c);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
	}

	public void delete(User c) {
		Session s = null;
		Transaction tx = null;

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			s.delete(c);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}

	}

	@Override
	public User findByEmail(String email) {
		User c = null;
		Session s = null;
		Transaction tx = null;

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			c =  (User) s.createQuery("from User u where u.email = :email")
					.setParameter("email", email)
					.getSingleResult();
			
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}

		return c;

	}

	@Override
	public List<Reimbursement> findPending() {
		List<Reimbursement> req = new ArrayList<>();

		Session s = null;
		Transaction tx = null;

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			req = (List<Reimbursement>) s.createQuery("from Reimbursement u where u.Status =:status", Reimbursement.class)
					.setParameter("status", "pending").getResultList();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return req;
	}

	@Override
	public List<User> finduser(int id) {
		List<User> user = new ArrayList<>();

		Session s = null;
		Transaction tx = null;

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			user = (List<User>) s.createQuery("from User u where u.userId =:card_id", User.class)
					.setParameter("card_id", id).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return user;
	}

	@Override
	public List<Reimbursement> findapproved() {
		List<Reimbursement> req = new ArrayList<>();

		Session s = null;
		Transaction tx = null;

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			req = (List<Reimbursement>) s.createQuery("from Reimbursement u where u.Status =:status", Reimbursement.class)
					.setParameter("status","Approved").getResultList();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return req;
	}
}
