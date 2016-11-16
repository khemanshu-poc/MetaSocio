package com.metasocio.service.followermanagement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.facade.followermanagement.FollowerFacade;
import com.metasocio.hibernate.factory.ConfigurationFactory;
import com.metasocio.model.usermanagement.User;

public class FollowerService {

	public void addFollowing(User follower) throws MetaSocioSystemException {
			Session session = null;
			// boolean isUserExists=false;
			Transaction transaction = null;
			SessionFactory sessionFactory =null;
			// String userName;
			try {
				Configuration cfg =ConfigurationFactory.getConfigurationInstance();
				 sessionFactory = cfg.buildSessionFactory();
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				/*FriendFacade iFriendFacade=new FriendFacade();*/
			    FollowerFacade iFollowerFacade=new FollowerFacade();
				

				

			    iFollowerFacade.addFollowing(follower, session);
                 transaction.commit();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("[" + e.getMessage() + "]");
				try {
					transaction.rollback();
					System.out.println("Transaction roll back");
					throw new MetaSocioSystemException("Transaction roll back,["
							+ e.getMessage() + "]", e);
				} catch (Exception e1) {
					e.printStackTrace();
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
			// return isAdded;
		
	}

	public List<User> getFollowers(User user)  throws MetaSocioSystemException {
		Session session = null;
		// boolean isUserExists=false;
		Transaction transaction = null;
		SessionFactory sessionFactory=null;
		// String userName;
		List<User> followersList;
		try {
			Configuration cfg =ConfigurationFactory.getConfigurationInstance();
			 sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			/*FriendFacade iFriendFacade=new FriendFacade();*/
		    FollowerFacade iFollowerFacade=new FollowerFacade();
			

			

		    followersList=iFollowerFacade.getFollowers(user, session);
             transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[" + e.getMessage() + "]");
			try {
				transaction.rollback();
				System.out.println("Transaction roll back");
				throw new MetaSocioSystemException("Transaction roll back,["
						+ e.getMessage() + "]", e);
			} catch (Exception e1) {
				e.printStackTrace();
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
		// return isAdded;
		return followersList;
	
	}

	public List<User> getUsersWhomYouAreNotFollowing(int userId,
			List<User> usersList) throws MetaSocioSystemException {
		Session session = null;
		// boolean isUserExists=false;
		List<User> usersWhomYouAreNotFollowing = null;
		Transaction transaction = null;
		SessionFactory sessionFactory =null;
		// String userName;
		try {
			Configuration cfg =ConfigurationFactory.getConfigurationInstance();

			//Configuration cfg = new Configuration();
			//cfg.configure("hibernate.cfg.xml");
			FollowerFacade iFollowerFacade=new FollowerFacade();

			 sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			usersWhomYouAreNotFollowing = iFollowerFacade.getUsersWhomYouAreNotFollowing(userId, usersList, session);

			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[" + e.getMessage() + "]");
			try {
				transaction.rollback();
				System.out.println("Transaction roll back");
				throw new MetaSocioSystemException("Transaction roll back,["
						+ e.getMessage() + "]", e);
			} catch (Exception e1) {
				e.printStackTrace();
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
		 return usersWhomYouAreNotFollowing;
	}

	public List<User> getFollowings(int followerId)  throws MetaSocioSystemException {
		Session session = null;
		// boolean isUserExists=false;
		List<User> followingList = new ArrayList<User>();
		Transaction transaction = null;
		SessionFactory sessionFactory =null;
		// String userName;
		try {
			Configuration cfg =ConfigurationFactory.getConfigurationInstance();

			//Configuration cfg = new Configuration();
			//cfg.configure("hibernate.cfg.xml");
			FollowerFacade iFollowerFacade =new FollowerFacade();

			sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			followingList = iFollowerFacade.getFollowings(followerId, session);

			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[" + e.getMessage() + "]");
			try {
				transaction.rollback();
				System.out.println("Transaction roll back");
				throw new MetaSocioSystemException("Transaction roll back,["
						+ e.getMessage() + "]", e);
			} catch (Exception e1) {
				e.printStackTrace();
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
		 return followingList;
	}

	public boolean removeFriend(int followerId, int followingId) throws MetaSocioSystemException {
		Session session = null;
		Transaction transaction = null;
		SessionFactory sessionFactory=null;
		boolean check;
		try {
			Configuration cfg =ConfigurationFactory.getConfigurationInstance();
			FollowerFacade iFollowerFacade=new FollowerFacade();
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			check = iFollowerFacade.removeFriend(followerId, followingId, session);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[" + e.getMessage() + "]");
			try {
				transaction.rollback();
				System.out.println("Transaction roll back");
				throw new MetaSocioSystemException("Transaction roll back,["
						+ e.getMessage() + "]", e);
			} catch (Exception e1) {
				e.printStackTrace();
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
		// return isAdded;
		return check;
	}

}
