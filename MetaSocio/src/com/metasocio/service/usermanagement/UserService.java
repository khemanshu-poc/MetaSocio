package com.metasocio.service.usermanagement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.facade.usermanagement.UserFacade;
import com.metasocio.hibernate.factory.ConfigurationFactory;
import com.metasocio.model.usermanagement.User;

public class UserService {
	public boolean isEmailExists(String email) throws MetaSocioSystemException {
		Session session = null;
		boolean isUserExists = false;
		Transaction transaction = null;
		SessionFactory sessionFactory = null;
		try {
			Configuration cfg = ConfigurationFactory.getConfigurationInstance();
			UserFacade iUserFacade = new UserFacade();
			sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			isUserExists = iUserFacade.isEmailExists(email, session);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				transaction.rollback();
				throw new MetaSocioSystemException("Transaction roll back,["
						+ e.getMessage() + "]", e);
			} catch (Exception e1) {
				e1.printStackTrace();
				throw new MetaSocioSystemException("[" + e.getMessage()
						+ "];error in transactiopn roll back,["
						+ e1.getMessage() + "]", e);
			}

		} finally {
			if (session != null) {
				session.close();
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
		return isUserExists;
	}

	public boolean setUserInfo(User user) throws MetaSocioSystemException {
		Session session = null;
		Transaction transaction = null;
		SessionFactory sessionFactory = null;
		boolean check;
		try {
			Configuration cfg = ConfigurationFactory.getConfigurationInstance();
			UserFacade iUserFacade = new UserFacade();
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			check = iUserFacade.setUserInfo(user, session);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[" + e.getMessage() + "]");
			try {
				transaction.rollback();
				System.out.println("Transaction roll back");
				throw new MetaSocioSystemException("Transaction roll back,["
						+ e.getMessage() + "]", e);
			} catch (Exception e1) {
				e1.printStackTrace();
				System.out.println("error in transactiopn roll back,["
						+ e1.getMessage() + "]");
				throw new MetaSocioSystemException("[" + e.getMessage()
						+ "];error in transactiopn roll back,["
						+ e1.getMessage() + "]", e);
			}
		} finally {
			if (session != null) {
				session.close();
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
		return check;

	}

	public List<User> getUsersHavingSameDepartment(User user)
			throws MetaSocioSystemException {
		Session session = null;
		Transaction transaction = null;
		List<User> usersOfSameDepartment;
		SessionFactory sessionFactory = null;
		try {
			Configuration cfg = ConfigurationFactory.getConfigurationInstance();
			UserFacade iUserFacade = new UserFacade();
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			usersOfSameDepartment = iUserFacade.getUsersHavingSameDepartment(
					user, session);
			transaction.commit();

		} catch (Exception e) {
			System.out.println("[" + e.getMessage() + "]");
			try {
				transaction.rollback();
				System.out.println("Transaction roll back");
				throw new MetaSocioSystemException("Transaction roll back,["
						+ e.getMessage() + "]", e);
			} catch (Exception e1) {
				System.out.println("error in transactiopn roll back,["
						+ e1.getMessage() + "]");
				throw new MetaSocioSystemException("[" + e.getMessage()
						+ "];error in transactiopn roll back,["
						+ e1.getMessage() + "]", e);
			}
		} finally {
			if (session != null) {
				session.close();
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}

		return usersOfSameDepartment;
	}

	public User getUserByEmail(String email) throws MetaSocioSystemException {
		Session session = null;
		Transaction transaction = null;
		SessionFactory sessionFactory = null;
		User user;
		try {
			Configuration cfg = ConfigurationFactory.getConfigurationInstance();
			UserFacade iUserFacade = new UserFacade();

			sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			user = iUserFacade.getUserByEmail(email, session);
			transaction.commit();

		} catch (Exception e) {

			System.out.println("[" + e.getMessage() + "]");
			try {
				transaction.rollback();
				System.out.println("Transaction roll back");
				throw new MetaSocioSystemException("Transaction roll back,["
						+ e.getMessage() + "]", e);
			} catch (Exception e1) {
				System.out.println("error in transactiopn roll back,["
						+ e1.getMessage() + "]");
				throw new MetaSocioSystemException("[" + e.getMessage()
						+ "];error in transactiopn roll back,["
						+ e1.getMessage() + "]", e);
			}
		} finally {
			if (session != null) {
				session.close();
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
		return user;
	}

	public User getUserById(int followingId) throws MetaSocioSystemException {
		Session session = null;
		Transaction transaction = null;
		SessionFactory sessionFactory = null;
		User user;
		try {
			Configuration cfg = ConfigurationFactory.getConfigurationInstance();
			UserFacade iUserFacade = new UserFacade();
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			user = iUserFacade.getUserById(followingId, session);
			transaction.commit();
		} catch (Exception e) {

			System.out.println("[" + e.getMessage() + "]");
			try {
				transaction.rollback();
				System.out.println("Transaction roll back");
				throw new MetaSocioSystemException("Transaction roll back,["
						+ e.getMessage() + "]", e);
			} catch (Exception e1) {
				System.out.println("error in transactiopn roll back,["
						+ e1.getMessage() + "]");
				throw new MetaSocioSystemException("[" + e.getMessage()
						+ "];error in transactiopn roll back,["
						+ e1.getMessage() + "]", e);
			}
		} finally {
			if (session != null) {
				session.close();
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
		return user;
	}

	public void updateUserInfo(User user) throws MetaSocioSystemException {
		Session session = null;
		Transaction transaction = null;
		SessionFactory sessionFactory = null;
		try {
			Configuration cfg = ConfigurationFactory.getConfigurationInstance();
			UserFacade iUserFacade = new UserFacade();
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			iUserFacade.updateUserInfo(user, session);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				transaction.rollback();
				throw new MetaSocioSystemException("Transaction roll back,["
						+ e.getMessage() + "]", e);
			} catch (Exception e1) {
				e1.printStackTrace();
				throw new MetaSocioSystemException("[" + e.getMessage()
						+ "];error in transactiopn roll back,["
						+ e1.getMessage() + "]", e);
			}
		} finally {
			if (session != null) {
				session.close();
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
	}
}
