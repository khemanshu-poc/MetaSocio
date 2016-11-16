package com.metasocio.test.usermanagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.metasocio.dbhelper.likemanagement.ValidateUserLike;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.hibernate.factory.ConfigurationFactory;

public class ValidateUserLikeTest {


	@Test
	public void test1() throws MetaSocioException {
		ValidateUserLike likeDao = new ValidateUserLike();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		boolean likes = likeDao.hasUSerAlreadyLiked(2,7,session);
		assertEquals(false,likes);
	}

	@Test
	public void test2() throws MetaSocioException {
		ValidateUserLike likeDao = new ValidateUserLike();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(likeDao.hasUserLikeDeleted(2,7,session));
	}
	
}
