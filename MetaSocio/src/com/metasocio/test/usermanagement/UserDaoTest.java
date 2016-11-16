package com.metasocio.test.usermanagement;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.metasocio.dbhelper.usermanagement.UserDao;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.hibernate.factory.ConfigurationFactory;
import com.metasocio.model.usermanagement.User;

public class UserDaoTest {

	@Test
	public void test1() throws MetaSocioException {
		UserDao userDao = new UserDao();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(userDao.getUserByEmail("sanjay.nainani@metacube.com", session));
	}

	@Test(expected = AssertionError.class)
	public void test2() throws MetaSocioException {
		UserDao userDao = new UserDao();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(userDao.getUserByEmail("nidhi.sharma@metacube.com", session));
	}
	

	@Test
	public void test3() throws MetaSocioException {
		UserDao userDao = new UserDao();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(userDao.getUserById(1, session));
	}
	
	@Test
	public void test4() throws MetaSocioException {
		UserDao userDao = new UserDao();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(userDao.getAllUsers(session));
	}
	
	@Test(expected = AssertionError.class)
	public void test5() throws MetaSocioException {
		UserDao userDao = new UserDao();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(userDao.getUserById(0, session));
	}
	

	@Test
	public void test6() throws MetaSocioException {
		UserDao userDao = new UserDao();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(userDao.getUsersHavingSameDepartment("Java", session));
	}
	
	@Test
	public void test7() throws MetaSocioException {
		UserDao userDao = new UserDao();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		User user = new User();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertEquals(true,userDao.setUserInfo(user, session));
	}
}
