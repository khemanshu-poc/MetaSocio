package com.metasocio.test.commentmanagement;

import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.metasocio.dbhelper.commentmanagement.CommentDao;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.hibernate.factory.ConfigurationFactory;
import com.metasocio.model.commentmanagement.Comment;

/**
 * @author CHETNA
 *
 */
public class CommentDaoTest {

	@Test
	public void test1() throws MetaSocioException {
		CommentDao commentDao = new CommentDao();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		Comment comment = new Comment();
		assertNotNull(commentDao.addComment(comment, session));
	}

	@Test
	public void test2() throws MetaSocioException {
		CommentDao commentDao = new CommentDao();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(commentDao.deleteCommentByCommentId(0, session));
	}

	@Test
	public void test3() throws MetaSocioException {
		CommentDao commentDao = new CommentDao();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(commentDao.retrieveCommentListWithImageByPostID(1,
				session));
	}
	
	@Test
	public void test4() throws MetaSocioException {
		CommentDao commentDao = new CommentDao();
		Configuration cfg = ConfigurationFactory.getConfigurationInstance();
		Session session = null;
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		assertNotNull(commentDao.editCommentByCommentId(1, "comment detail", session));
	}
}
