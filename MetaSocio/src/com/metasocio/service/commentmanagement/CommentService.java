package com.metasocio.service.commentmanagement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.facade.commentmanagement.CommentFacade;
import com.metasocio.facade.postmanagement.PostFacade;
import com.metasocio.hibernate.factory.ConfigurationFactory;
import com.metasocio.model.commentmanagement.Comment;
import com.metasocio.modelhelper.ImageHelper;
/*********************************************************************
 * Name: CommentService
 * @author
 * Since : 23 Nov,2015 
 * Description : This is service class of manage comments, providing session and beginning transaction.
 *
 ***********************************************************************/
public class CommentService {
	/*****************************************************************
	 * Name : shareComment
	 * @param newComment
	 * @throws MetaSocioSystemException
	 * Description : This function is to save comment information in the database
	 *****************************************************************/
	public boolean shareComment(Comment newComment) throws MetaSocioSystemException {
		Session session = null;
		// boolean isUserExists=false;
		Transaction transaction = null;
		SessionFactory sessionFactory =null;
		boolean check;
		try {
			Configuration cfg =ConfigurationFactory.getConfigurationInstance();//getting instance of config file
              CommentFacade iCommentFacade=new CommentFacade();
			sessionFactory = cfg.buildSessionFactory();//building session factory
			session = sessionFactory.openSession();//opening session
			transaction = session.beginTransaction();//begins transaction 
			check = iCommentFacade.shareComment(newComment, session);
			transaction.commit();
		}catch (Exception e) {
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
				session.close();//closing session
			}
			if(sessionFactory!=null){
				sessionFactory.close();
			}
		}
		return check;
	}
	/************************************************************************
	 * Name : retrieveCommentListWithImageByPostID
	 * @param postId
	 * @return list of comments with images
	 * @throws MetaSocioSystemException
	 * Description : retrieve comments on home page
	 **************************************************************************/
	public List<Comment> retrieveCommentListWithImageByPostID(int postId) throws MetaSocioSystemException {
		Session session = null;
		// boolean isUserExists=false;
		Transaction transaction = null;
		SessionFactory sessionFactory=null;
		 List<Comment> commentsWithImage = new ArrayList<Comment>();	// Get comments with image in the ArrayList
		 try {
			CommentFacade iCommentFacade=new CommentFacade();
			Configuration cfg =ConfigurationFactory.getConfigurationInstance();//getting instance of config file
			sessionFactory = cfg.buildSessionFactory();//building session factory
			session = sessionFactory.openSession();//opening session
			transaction = session.beginTransaction();//begins transaction 
			commentsWithImage = iCommentFacade.retrieveCommentListWithImageByPostID(postId,  session);// Calling retrieveCommentListWithImageByPostID method existing in CommentFacade class
			transaction.commit();//	commit transaction
		} catch (Exception e) {
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
				session.close();//closing session
			}
			if(sessionFactory!=null){
				sessionFactory.close();
			}
		}
		return commentsWithImage;
	}

	/**
	 * @param commentId
	 * @throws MetaSocioSystemException
	 */
	public int deleteCommentByCommentId(int commentId)
			throws MetaSocioSystemException {
		Session session = null;
		Transaction transaction = null;
		SessionFactory sessionFactory = null;
		int check;
		try {
			// facde Layer Is Called
			CommentFacade iCommentFacade = new CommentFacade();
			Configuration cfg = ConfigurationFactory.getConfigurationInstance();
			// Session Factory is Called
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			check = iCommentFacade.deleteCommentByCommentId(commentId, session);
			transaction.commit();
		} catch (Exception e) {
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
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
		// returns the Posts With Image
		return check;
	}

	/**
	 * @param commentId
	 * @param commentDetails
	 * @throws MetaSocioSystemException
	 */
	public void editCommentByCommentId(int commentId, String commentDetails)
			throws MetaSocioSystemException {
		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		// List to store Post With Image
		/* List<Post> postsWithImage = new ArrayList<Post>(); */
		try {
			// facde Layer Is Called
			CommentFacade icCommentFacade = new CommentFacade();
			Configuration cfg = ConfigurationFactory.getConfigurationInstance();
			// Session Factory is Called
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			icCommentFacade.editCommentByCommentId(commentId, commentDetails,
					session);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[" + e.getMessage() + "]");
			try {
				transaction.rollback();

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
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
		// returns the Posts With Image
	}
}
