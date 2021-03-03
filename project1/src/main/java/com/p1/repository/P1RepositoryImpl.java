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
			/*
			 * Hibernate has its own query language called "HQL" - Hibernate Query Language.
			 * HQL allows us to emphasize our Java models rather than the entities in the
			 * DB. It provides a more object-oriented approach to data persistence.
			 */
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
		// All of our work is done within the context of a Hibernate session
		Session s = null;
		/*
		 * The Transaction interface gives you control over your DB transactions. You
		 * can use it to rollback changes, commit changes, and begin transactions.
		 */
		Transaction tx = null;

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			/*
			 * This method persists the card (i.e. creates a new record in the table).
			 */
			s.save(c);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			// Always close your sessions!
			s.close();
		}
	}

	public void update(User c) {
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
}
