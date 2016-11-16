package com.metasocio.test.postmanagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.metasocio.dbhelper.postmanagement.PostDao;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.hibernate.factory.ConfigurationFactory;

public class PostDaoTest {
	@Test
	public void test1() throws MetaSocioException {
		PostDao postDao = new PostDao();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(postDao.decrementLikesOnPost(1, session));
	}
	
	@Test
	public void test2() throws MetaSocioException {
		PostDao postDao = new PostDao();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(postDao.deletePostByPostId(1, session));
	}
	

	@Test
	public void test3() throws MetaSocioException {
		PostDao postDao = new PostDao();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(postDao.editPostByPostId(3, "hello nidhi....", session));
	}
	

	@Test
	public void test4() throws MetaSocioException {
		PostDao postDao = new PostDao();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(postDao.incrementLikesOnPost(1, session));
	}
	
	@Test
	public void test5() throws MetaSocioException {
		PostDao postDao = new PostDao();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		int value = postDao.incrementLikesOnPost(1, session);
		assertEquals(0, value);
	}
	
	@Test
	public void test6() throws MetaSocioException {
		PostDao postDao = new PostDao();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		int value = postDao.deletePostByPostId(1, session);
		assertEquals(0, value);
	}
	

	@Test
	public void test7() throws MetaSocioException {
		PostDao postDao = new PostDao();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(postDao.retrievePostWithImageOnHome(session, 1, 2, 0));
	}
}
