package com.metasocio.test.followermanagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.metasocio.exception.MetaSocioException;
import com.metasocio.facade.followermanagement.FollowerFacade;
import com.metasocio.hibernate.factory.ConfigurationFactory;
import com.metasocio.model.usermanagement.User;

public class FollowerFacadeTest {

	@Test(expected=AssertionError.class)
	public void test1() throws MetaSocioException {
		User user = new User();
		FollowerFacade followerFacade = new FollowerFacade();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(followerFacade.getUsersWhomYouAreNotFollowing(1,null, session));
	}
	
	@Test
	public void test2() throws MetaSocioException {
		User user = new User();
		FollowerFacade followerFacade = new FollowerFacade();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(followerFacade.getFollowers(user, session));
	}
	
	@Test
	public void test3() throws MetaSocioException {
		User user = new User();
		FollowerFacade followerFacade = new FollowerFacade();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		Boolean check = followerFacade.removeFriend(1, 2, session);
		assertEquals(true,check);
	}
	
	@Test
	public void test4() throws MetaSocioException {
		User user = new User();
		FollowerFacade followerFacade = new FollowerFacade();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(followerFacade.getFollowings(1, session));
		
	}
	


}
