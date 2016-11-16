package com.metasocio.test.followermanagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.metasocio.exception.MetaSocioException;
import com.metasocio.hibernate.factory.ConfigurationFactory;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.followermanagement.FollowerService;

public class FollowerServiceTest {


	@Test(expected=AssertionError.class)
	public void test1() throws MetaSocioException {
		User user = new User();
		FollowerService followerService = new FollowerService();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(followerService.getUsersWhomYouAreNotFollowing(1,null));
	}
	
	@Test
	public void test2() throws MetaSocioException {
		User user = new User();
		FollowerService followerService = new FollowerService();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(followerService.getFollowers(user));
	}
	
	@Test
	public void test3() throws MetaSocioException {
		User user = new User();
		FollowerService followerService = new FollowerService();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		Boolean check = followerService.removeFriend(1, 2);
		assertEquals(true,check);
	}
	
	@Test
	public void test4() throws MetaSocioException {
		User user = new User();
		FollowerService followerService = new FollowerService();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(followerService.getFollowings(1));
		
	}
	

}
