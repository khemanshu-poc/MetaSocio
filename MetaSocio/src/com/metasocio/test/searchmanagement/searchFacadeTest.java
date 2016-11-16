package com.metasocio.test.searchmanagement;

import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metasocio.exception.MetaSocioException;
import com.metasocio.facade.searchmanagement.SearchFacade;
import com.metasocio.hibernate.factory.ConfigurationFactory;

public class searchFacadeTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}


	@Test
	public void test1() throws MetaSocioException {
		SearchFacade facade = new SearchFacade();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull( facade.retrieveUsersByKey(session, "ch", "chetna.sharma@metacube.com"));
	}
	
}
