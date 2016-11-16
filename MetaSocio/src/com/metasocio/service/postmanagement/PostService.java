package com.metasocio.service.postmanagement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.facade.postmanagement.PostFacade;
import com.metasocio.hibernate.factory.ConfigurationFactory;
import com.metasocio.model.postmanagement.Post;
/**
 * Name: PostService
 * @author Anurag
 * Since: 28 November,2015
 * Description: Service Layer that calls the facade
 */
public class PostService
{
	/**
	 * Name:SharePost
	 * @param newPost
	 * @throws MetaSocioSystemException
	 */
	public void savePost(Post newPost)throws MetaSocioSystemException
	{
		Session session = null;
		Transaction transaction = null;
		SessionFactory sessionFactory=null;
		try 
		{
			// Configuration is Called
			Configuration cfg =ConfigurationFactory.getConfigurationInstance();
			// Facade Layer Is Called
			PostFacade iPostFacade=new PostFacade();
			// Session Factory Instance is created
			 sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			// Share the Post
			iPostFacade.savePost(newPost, session);
			transaction.commit();
		

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("[" + e.getMessage() + "]");
			try {
				transaction.rollback();
				System.out.println("Transaction roll back");
				throw new MetaSocioSystemException("Transaction roll back,["
						+ e.getMessage() + "]", e);
			} catch (Exception e1) {
				System.out.println("error in transactiopn roll back,["
						+ e1.getMessage() + "]");
				throw new MetaSocioSystemException("[" + e.getMessage()
						+ "];error in transaction roll back,["
						+ e1.getMessage() + "]", e);
			}
		} finally {
			if (session != null) {
				session.close();
			}
			if(sessionFactory!=null){
				sessionFactory.close();
			}
		}

	}
	/**
	 * Name:retrievePostWithImageOnHome
	 * @param maximumResult 
	 * @param startIndex 
	 * @param groupId 
	 * @return
	 * @throws MetaSocioSystemException
	 * Description:retrieve post with image On home 
	 **/
	
	public  List<Post> retrievePostWithImageOnHome(int startIndex, int maximumResult, int groupId) throws MetaSocioSystemException
	{
		Session session = null;
		Transaction transaction = null;
		SessionFactory sessionFactory =null;
		// List to store  Post With Image
		 List<Post> postsWithImage = new ArrayList<Post>();	
		 try 
		 {
			// facde Layer Is Called
			PostFacade iPostFacade=new PostFacade();
			Configuration cfg =ConfigurationFactory.getConfigurationInstance();
			// Session Factory is Called
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			postsWithImage = iPostFacade.retrievePostWithImageOnHome(session,startIndex,maximumResult,groupId);
			transaction.commit();

		}
		 catch (Exception e) 
		 {
			e.printStackTrace();
			System.out.println("[" + e.getMessage() + "]");
			try {
				transaction.rollback();
				System.out.println("Transaction roll back");
				throw new MetaSocioSystemException("Transaction roll back,["
						+ e.getMessage() + "]", e);
			} catch (Exception e1) {
				System.out.println("error in transactiopn roll back,["
						+ e1.getMessage() + "]");
				throw new MetaSocioSystemException("[" + e.getMessage()
						+ "];error in transactiopn roll back,["
						+ e1.getMessage() + "]", e);
			}
		} finally {
			if (session != null) {
				session.close();
			}
			if(sessionFactory!=null){
				sessionFactory.close();
			}
		}
		 // returns the Posts With Image
		return postsWithImage;
	}








public  int deletePostByPostId(int postId) throws MetaSocioSystemException
{
	Session session = null;
	Transaction transaction = null;
	SessionFactory sessionFactory =null;
	int check;
	 try 
	 {
		// facde Layer Is Called
		PostFacade iPostFacade=new PostFacade();
		Configuration cfg =ConfigurationFactory.getConfigurationInstance();
		// Session Factory is Called
		sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		check = iPostFacade.deletePostByPostId(postId, session);
		transaction.commit();

	}
	 catch (Exception e) 
	 {
		e.printStackTrace();
		try {
			transaction.rollback();
			throw new MetaSocioSystemException("Transaction roll back,["
					+ e.getMessage() + "]", e);
		} catch (Exception e1) {
			throw new MetaSocioSystemException("[" + e.getMessage()
					+ "];error in transactiopn roll back,["
					+ e1.getMessage() + "]", e);
		}
	} finally {
		if (session != null) {
			session.close();
		}
		if(sessionFactory!=null){
			sessionFactory.close();
		}
	}
	 // returns the Posts With Image
	return check;
	
}

public  int editPostByPostId(int postId,String postDetails) throws MetaSocioSystemException
{
	Session session = null;
	Transaction transaction = null;
	SessionFactory sessionFactory=null;
	int check;
	 try 
	 {
		// facde Layer Is Called
		PostFacade iPostFacade=new PostFacade();
		Configuration cfg =ConfigurationFactory.getConfigurationInstance();
		// Session Factory is Called
		sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	   check = iPostFacade.editPostByPostId(postId,postDetails, session);
		transaction.commit();

	}
	 catch (Exception e) 
	 {
		e.printStackTrace();
		System.out.println("[" + e.getMessage() + "]");
		try {
			transaction.rollback();
			System.out.println("Transaction roll back");
			throw new MetaSocioSystemException("Transaction roll back,["
					+ e.getMessage() + "]", e);
		} catch (Exception e1) {
			System.out.println("error in transactiopn roll back,["
					+ e1.getMessage() + "]");
			throw new MetaSocioSystemException("[" + e.getMessage()
					+ "];error in transactiopn roll back,["
					+ e1.getMessage() + "]", e);
		}
	} finally {
		if (session != null) {
			session.close();
		}
		if(sessionFactory!=null){
			sessionFactory.close();
		}
	}
	return check;
	
}
}
