package com.metasocio.test.likemanagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.metasocio.dbhelper.likemanagement.LikeDao;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.hibernate.factory.ConfigurationFactory;
import com.metasocio.model.likemanagement.Like;

public class LikeDaoTest {
	
	
	@Test(expected=AssertionError.class)
	public void test1() throws MetaSocioException {
		LikeDao likeDao = new LikeDao();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		Like like = new Like();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		Boolean check = likeDao.setLike(like,session);
		assertEquals(false,check);
	}
	
	@Test(expected=AssertionError.class)
	public void test2() throws MetaSocioException {
		LikeDao likeDao = new LikeDao();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		int check = likeDao.updateIsLiked(1,2,7,session);
		assertNotNull(check);
	}
	
	@Test
	public void test3() throws MetaSocioException {
		LikeDao likeDao = new LikeDao();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		int likes = likeDao.LikesOnPostByPostId(2,session);
		assertEquals(0,likes);
	}
	

	@Test
	public void test4() throws MetaSocioException {
		LikeDao likeDao = new LikeDao();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		int likes = likeDao.LikesOnPostByPostId(2,session);
		assertNotNull(likeDao.LikesOnPostByPostId(6,session));
	}

}
