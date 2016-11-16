package com.metasocio.service.likemanagement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.metasocio.exception.MetaSocioException;
import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.facade.likemanagement.LikeFacade;
import com.metasocio.hibernate.factory.ConfigurationFactory;
import com.metasocio.model.usermanagement.User;

/**
 * @author 
 * Since : 23 November, 2015
 * Description : This LikeService class is providing services like session opening, session closing, beginning transaction and commit transactions.
 *  Session is opening a connection between Java and database and transactions is to commit queries in database.
 */
public class LikeService {

	/******************************************************************
	 * This function is managing likes regarding operations providing
	 * session to the facade layer and transactions will be committed
	 * in this layer, also closing session.
	 * @param user : The user who is performing likes operations.
	 * @param postId : The post on which user wants to like or unlike
	 * @throws MetaSocioException : Throwing MetaSocioException
	 * 								if any exception occurs
	 ******************************************************************/
	public void manageLikes(User user, int postId) throws MetaSocioSystemException {
		Session session = null;		//Creating session
		Transaction transaction = null;	//Creating transaction
		SessionFactory sessionFactory=null;
		try {
			Configuration cfg =ConfigurationFactory.getConfigurationInstance();		//Getting instance of configuration file
			LikeFacade iFacade = new LikeFacade();		//Creating instance of 'LikeFacade' class.
			sessionFactory = cfg.buildSessionFactory();	//Building session factory
			session = sessionFactory.openSession();		//opening session
			transaction = session.beginTransaction();	//beginning transaction
			iFacade.manageLikes(user, postId, session);		//passing session and required data to manage likes operation in Facade 
			transaction.commit();			//committing transaction 

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[" + e.getMessage() + "]");
			try {
				transaction.rollback();		//rolling back transaction if exception occurs
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
				session.close();		//closing session
			}
			if(sessionFactory!=null){
				sessionFactory.close();
			}
		}
	}

	public boolean hasUSerAlreadyLiked(int userId, int postId) throws MetaSocioSystemException {
		Session session = null;		//Creating session
		Transaction transaction = null;	//Creating transaction
		boolean hasAlreadyLiked=false;
		SessionFactory sessionFactory =null;
		try {
			Configuration cfg =ConfigurationFactory.getConfigurationInstance();		//Getting instance of configuration file
			LikeFacade iFacade = new LikeFacade();		//Creating instance of 'LikeFacade' class.
			 sessionFactory = cfg.buildSessionFactory();	//Building session factory
			session = sessionFactory.openSession();		//opening session
			transaction = session.beginTransaction();	//beginning transaction
			hasAlreadyLiked=iFacade.hasUSerAlreadyLiked(userId, postId, session);		//passing session and required data to manage likes operation in Facade 
			transaction.commit();			//committing transaction 

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[" + e.getMessage() + "]");
			try {
				transaction.rollback();		//rolling back transaction if exception occurs
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
				session.close();		//closing session
			}
			if(sessionFactory!=null){
				sessionFactory.close();
			}
		}
return hasAlreadyLiked;	}

	public int LikesOnPostByPostId(int postId) throws MetaSocioSystemException{
		Session session = null;		//Creating session
		Transaction transaction = null;	//Creating transaction
		int noOfLikes = 0;
		SessionFactory sessionFactory =null;
		try {
			Configuration cfg =ConfigurationFactory.getConfigurationInstance();		//Getting instance of configuration file
			LikeFacade iFacade = new LikeFacade();		//Creating instance of 'LikeFacade' class.
			 sessionFactory = cfg.buildSessionFactory();	//Building session factory
			session = sessionFactory.openSession();		//opening session
			transaction = session.beginTransaction();	//beginning transaction
			noOfLikes = iFacade.LikesOnPostByPostId(postId, session);		//passing session and required data to manage likes operation in Facade 
			transaction.commit();			//committing transaction 

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[" + e.getMessage() + "]");
			try {
				transaction.rollback();		//rolling back transaction if exception occurs
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
				session.close();		//closing session
			}
			if(sessionFactory!=null){
			sessionFactory.close();
			}
			}
		
		return noOfLikes;
	}
	
}
