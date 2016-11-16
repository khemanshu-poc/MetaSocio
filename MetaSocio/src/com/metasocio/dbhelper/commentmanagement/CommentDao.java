package com.metasocio.dbhelper.commentmanagement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.metasocio.exception.MetaSocioException;
import com.metasocio.model.commentmanagement.Comment;
import com.metasocio.model.usermanagement.User;
/****************************************************************************
 * @author : 
 * Since: 28 November,2015
 * Description: This class is directly querying the database regarding 
 * comments on post to get the required information.
 ****************************************************************************/
public class CommentDao {
	private static CommentDao iCommentDao; //making static instance of class 
	/**
	 * Creating private constructor
	 */
	public CommentDao() {

	}
	/****************************************************************
	 * This function is to create single instance of this class, 
	 * if the instance already exists return the previous one
	 * and if instance is null create a new instance.
	 * 
	 * @return : Returning instance of this class
	 ************************************************************/
	public static CommentDao getInstance() {

		/*	if (iCommentDao == null) {*/
		iCommentDao = new CommentDao();

		/*	}*/
		return iCommentDao;//Returning instance of this class
	}
	/*************************************************************
	 * This function is to save comment information in the database
	 * @param newComment
	 * @param transaction
	 * @param session
	 * @return 
	 * @throws MetaSocioException
	 ************************************************************/
	public boolean addComment(Comment newComment,
			Session session) throws MetaSocioException {
		try{
		session.save(newComment);	
		return true;
		}
		catch(Exception e){
			return false;
		}
	}
	/**************************************************************
	 * This function is to retrieve comment list with image on home 
	 * page from the database
	 * @param postId
	 * @param transaction
	 * @param session
	 * @return list of comments with user's image whom commented
	 * @throws MetaSocioException
	 **************************************************************/
	public List<Comment> retrieveCommentListWithImageByPostID(int postId,
			Session session) throws MetaSocioException {

		// query to retrieve comments from comment table
		Query query = session.createQuery("select cm.commentId, cm.comments, cm.dateCommented, cm.updatedAt, cm.createdBy,"
				+ "cm.updatedBy, cm.isDelete, cm.user from Comment cm where cm.post.postId=:id AND cm.isDelete=:isdelete order by cm.dateCommented desc");
		query.setInteger("id",postId);
		query.setInteger("isdelete",0);


		@SuppressWarnings("unchecked")
		List<Object[]> rows=query.list();


		//declaration of array list named commentsWithImage 
		List<Comment> commentsWithImage = new ArrayList<Comment>();
		for (Object[] row: rows) {
			// Creating object of Comment class
			Comment comment = new Comment();
			// Setting comment information in comment object
			comment.setCommentId((int) row[0]);
			comment.setComments((String)row[1]);
			comment.setDateCommented((Date) row[2]);
			//  comment.setCreatedAt((Date) row[3]);
			comment.setUpdatedAt( (Timestamp) row[3]);
			comment.setCreatedBy((String) row[4]);
			comment.setUpdatedBy((String) row[5]);
			comment.setIsDelete((int) row[6]);
			// imageHelper.setComment(comment);
			comment.setUser((User) row[7]);
			//adding this object to list commentsWithImage
			commentsWithImage.add(comment);
		}
		return commentsWithImage;
	}
	
	/*************************************************************************************
	 * @param postId
	 * @param session
	 * @throws MetaSocioException
	 **************************************************************************************/
	public void deleteCommentOnPost(int postId, Session session) throws MetaSocioException  {
		Query deleteCommentOnPost = session.createQuery("UPDATE Comment as c SET c.isDelete "
				+ "= "+ 1 +" WHERE c.post.postId = "+postId+""); 		//Preparing query to update required field
		deleteCommentOnPost.executeUpdate();	

	}

	/*********************************************
	 * @param commentId
	 * @param session
	 * @return
	 * @throws MetaSocioException
	 *********************************************/
	public int deleteCommentByCommentId(int commentId, Session session) throws MetaSocioException {
		Query deleteCommentByCommentId = session.createQuery("UPDATE Comment as c SET c.isDelete "
				+ "= "+ 1 +" WHERE c.commentId = "+commentId+""); 		//Preparing query to update required field
		return deleteCommentByCommentId.executeUpdate();	
	}

	/*******************************************
	 * @param commentId
	 * @param commentDetails
	 * @param session
	 * @return
	 * @throws MetaSocioException
	 ********************************************/
	public int editCommentByCommentId(int commentId, String commentDetails, Session session) throws MetaSocioException {
		Query editCommentByCommentId = session.createQuery("UPDATE Comment as c SET c.comments=:comments WHERE c.commentId = "+commentId+""); 		//Preparing query to update required field
		editCommentByCommentId.setString("comments", commentDetails);
		return editCommentByCommentId.executeUpdate();	

	}

}
