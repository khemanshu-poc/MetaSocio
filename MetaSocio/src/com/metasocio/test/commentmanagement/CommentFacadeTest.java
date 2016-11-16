package com.metasocio.test.commentmanagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metasocio.exception.MetaSocioException;
import com.metasocio.facade.commentmanagement.CommentFacade;
import com.metasocio.hibernate.factory.ConfigurationFactory;
import com.metasocio.model.commentmanagement.Comment;

public class CommentFacadeTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test1() throws MetaSocioException {
		CommentFacade commentFacade = new CommentFacade();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(commentFacade.retrieveCommentListWithImageByPostID(1, session));
	}
	
	@Test
	public void test2() throws MetaSocioException {
		CommentFacade commentFacade = new CommentFacade();
		Comment  comment =new Comment();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(commentFacade.shareComment(comment, session));
	}
	
	@Test
	public void test3() throws MetaSocioException  {
		CommentFacade commentFacade = new CommentFacade();
		Comment  comment =new Comment();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertEquals(true, commentFacade.shareComment(comment, session));
	}
	
	@Test
	public void test4() throws MetaSocioException{
		CommentFacade commentFacade = new CommentFacade();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(commentFacade.deleteCommentByCommentId(1, session));
	}
	

}
