package com.metasocio.test.postmanagement;

import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.metasocio.exception.MetaSocioException;
import com.metasocio.facade.postmanagement.PostFacade;
import com.metasocio.hibernate.factory.ConfigurationFactory;

public class PostFacadeTest {


	@Test
	public void test1() throws MetaSocioException {
		PostFacade postFacade = new PostFacade();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull( postFacade.retrievePostWithImageOnHome(session, 0, 2, 0));
	}
	
	@Test
	public void test2() throws MetaSocioException {
		PostFacade postFacade = new PostFacade();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull( postFacade.deletePostByPostId(1, session));
	}
	
	@Test
	public void test3() throws MetaSocioException {
		PostFacade postFacade = new PostFacade();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull( postFacade.editPostByPostId(1, "postDetails", session));
	}
	
	@Test
	public void test4() throws MetaSocioException {
		PostFacade postFacade = new PostFacade();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull( postFacade.decrementLikesOnPost(1, session));
	}
	
	@Test
	public void test5() throws MetaSocioException {
		PostFacade postFacade = new PostFacade();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull( postFacade.incrementLikesOnPost(1, session));
	}
	
	
}
