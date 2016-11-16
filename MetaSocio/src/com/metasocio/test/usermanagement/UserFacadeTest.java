package com.metasocio.test.usermanagement;

import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.metasocio.exception.MetaSocioException;
import com.metasocio.facade.usermanagement.UserFacade;
import com.metasocio.hibernate.factory.ConfigurationFactory;
import com.metasocio.model.usermanagement.User;

public class UserFacadeTest {

	@Test
	public void test1() throws MetaSocioException {
		UserFacade userFacade = new UserFacade();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(userFacade.getUserByEmail("pooja.khandelwal@metacube.com", session));
	}
	

	@Test
	public void test2() throws MetaSocioException {
		UserFacade userFacade = new UserFacade();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(userFacade.getAllUsers(session));
	}
	

	@Test(expected = NullPointerException.class)
	public void test3() throws MetaSocioException {
		UserFacade userFacade = new UserFacade();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		User user = new User();
		assertNotNull(userFacade.getUsersHavingSameDepartment(user, session));
	}
	

	@Test
	public void test4() throws MetaSocioException {
		UserFacade userFacade = new UserFacade();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(userFacade.getUserById(1, session));
	}

	@Test
	public void test5() throws MetaSocioException {
		UserFacade userFacade = new UserFacade();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(userFacade.isEmailExists("pooja.khandelwal@metacube.com", session));
	}

}
