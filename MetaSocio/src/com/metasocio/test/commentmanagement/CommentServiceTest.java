
package com.metasocio.test.commentmanagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.metasocio.exception.MetaSocioException;
import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.hibernate.factory.ConfigurationFactory;
import com.metasocio.model.commentmanagement.Comment;
import com.metasocio.service.commentmanagement.CommentService;

/**
 * @author CHETNA
 *
 */
public class CommentServiceTest {

	@Test
	public void test1() throws MetaSocioException {
		CommentService commentService = new CommentService();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(commentService.retrieveCommentListWithImageByPostID(1));
	}
	
	@Test(expected= MetaSocioException.class)
	public void test2() throws MetaSocioSystemException {
		CommentService commentService = new CommentService();
		Comment  comment =new Comment();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(commentService.shareComment(comment));
	}

	@Test(expected= MetaSocioException.class)
	public void test3() throws MetaSocioSystemException  {
		CommentService commentService = new CommentService();
		Comment  comment =new Comment();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertEquals(false,commentService.shareComment(comment));
	}
	
	@Test(expected= AssertionError.class)
	public void test4() throws MetaSocioSystemException {
		CommentService commentService = new CommentService();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(commentService.deleteCommentByCommentId(1));
		}
	}
	
	

