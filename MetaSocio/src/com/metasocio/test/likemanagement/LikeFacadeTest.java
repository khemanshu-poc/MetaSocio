package com.metasocio.test.likemanagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.metasocio.exception.MetaSocioException;
import com.metasocio.facade.likemanagement.LikeFacade;
import com.metasocio.hibernate.factory.ConfigurationFactory;

public class LikeFacadeTest {


	@Test
	public void test1() throws MetaSocioException {
		LikeFacade likeFacade = new LikeFacade();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		Boolean check = likeFacade.hasUSerAlreadyLiked(1, 1, session);
		assertEquals(false,check);
	}
	
	@Test
	public void test2() throws MetaSocioException {
		LikeFacade likeFacade = new LikeFacade();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(likeFacade.LikesOnPostByPostId(7, session));
	}
	
}
