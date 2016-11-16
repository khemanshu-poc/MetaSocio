package com.metasocio.test.usermanagement;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.metasocio.dbhelper.usermanagement.ValidateUser;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.hibernate.factory.ConfigurationFactory;

public class ValidateUserTest {

	@Test
	public void test1() throws MetaSocioException {
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		ValidateUser validateUser = new ValidateUser();
		boolean check = validateUser.isEmailExists("sanjay.nainani@metacube.com", session);
		assertEquals(false, check);
	}
	
	@Test
	public void test2() throws MetaSocioException {
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		ValidateUser validateUser = new ValidateUser();
		boolean check = validateUser.isEmailExists("s@metacube.com", session);
		assertEquals(false, check);
	}
	
	@Test
	public void test3() throws MetaSocioException {
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		ValidateUser validateUser = new ValidateUser();
		assertNotNull(validateUser.isEmailExists("chetna.sharma@metacube.com", session));
	}


}
