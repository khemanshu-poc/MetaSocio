package com.metasocio.facade.commentmanagement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import com.metasocio.dbhelper.commentmanagement.CommentDao;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.model.commentmanagement.Comment;
/***************************************************************************
 * Name: CommentFacade
 * @author Since: 28 November,2015 
 * Description: Facade Layer to Comment on post
 **************************************************************************/
public class CommentFacade {
	/************************************************************************
	 * Name : ShareComment
	 * @param newComment
	 * @param transaction
	 * @param session
	 * @return 
	 * @throws MetaSocioException
	 * Description: Save comments on a post in database
	 ***********************************************************************/
	public boolean shareComment(Comment newComment,
			Session session) throws MetaSocioException {
		// Gets the instance of the Dao
		CommentDao iCommentDao=CommentDao.getInstance();
		// Calling method addComment existing in CommentDao class
		return iCommentDao.addComment(newComment,session);
	}
	/**************************************************************************
	 * Name : retrieveCommentListWithImageByPostID
	 * @param postId
	 * @param transaction
	 * @param session
	 * @return list of comments with images
	 * @throws MetaSocioException
	 * Description:retrieve comments on home page
	 *****************************************************************************/
	public List<Comment> retrieveCommentListWithImageByPostID(int postId,
			 Session session) throws MetaSocioException {
		// Gets the Instance of Dao
		CommentDao iCommentDao = CommentDao.getInstance();// Get comments with image in the ArrayList
		List<Comment> commentsWithImage = new ArrayList<Comment>();
		commentsWithImage = iCommentDao.retrieveCommentListWithImageByPostID(postId,
				session);// Calling retrieveCommentListWithImageByPostID method existing in CommentDao class
		return commentsWithImage;
	}
	/** ******************************************************************
	 * @param postId
	 * @param session
	 * @throws MetaSocioException
	 * ******************************************************************/
	public void deleteCommentOnPost(int postId, Session session)  throws MetaSocioException {
		CommentDao iCommentDao = CommentDao.getInstance();
		iCommentDao.deleteCommentOnPost(postId,session);;
	}
	
	/** ******************************************************************
	 * @param commentId
	 * @param session
	 * @return
	 * @throws MetaSocioException
	  *******************************************************************/
	public int deleteCommentByCommentId(int commentId, Session session) throws MetaSocioException {
		CommentDao icoCommentDao = CommentDao.getInstance();
		// decrement likes on post
		return icoCommentDao.deleteCommentByCommentId(commentId,session);
	}
	/********************************************************************
	 * @param commentId
	 * @param commentDetails
	 * @param session
	 * @throws MetaSocioException
	 * ******************************************************************/
	public void editCommentByCommentId(int commentId, String commentDetails, Session session)throws MetaSocioException {
		CommentDao icoCommentDao = CommentDao.getInstance();
		// decrement likes on post
		icoCommentDao.editCommentByCommentId(commentId,commentDetails,session);
	}
}
