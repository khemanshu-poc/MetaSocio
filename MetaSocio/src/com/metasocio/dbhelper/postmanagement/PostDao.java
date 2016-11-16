package com.metasocio.dbhelper.postmanagement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.model.postmanagement.Post;
import com.metasocio.model.usermanagement.User;
/**
 * Name: PostDao
 * @author : Anurag
 * Since: 28 November,2015
 * Description: Data base access object
 */
public class PostDao 
{
	private static PostDao iPostDao;
	public PostDao() 
	{
	}
	public static PostDao getInstance() 
	{
			iPostDao = new PostDao();
		return iPostDao;
	}
	/**
	 * Name: addPost
	 * @param newPost: post to be updated
	 * @param transaction: transaction to be updated
	 * @param session: session to be updated
	 * @throws MetaSocioException
	 */
	public void savePost(Post newPost,Session session) throws MetaSocioException
	{
		// save the data to the database
		session.saveOrUpdate(newPost);
		
	}
	/**
	 * Name: retrieve post with Image
	 * @param transaction
	 * @param session
	 * @param maximumResult 
	 * @param startIndex 
	 * @param groupId 
	 * @return
	 * @throws MetaSocioException
	 * Description: retrive image 
	 **/
	public List<Post> retrievePostWithImageOnHome(Session session, int startIndex, int maximumResult, int groupId) throws MetaSocioException
	{
		// Query with session to update
		Query query = session.createQuery("select pm.postId, pm.postDetails, pm.groupId, pm.datePosted, pm.likes,"
				+ "pm.updatedAt, pm.createdBy, pm.updatedBy, pm.isDelete, pm.user from Post pm WHERE pm.isDelete=:isdelete and pm.groupId=:groupId order by pm.datePosted desc ");
		// getting the object with rows 
		query.setInteger("isdelete", 0);
		query.setInteger("groupId", groupId);
		query.setFirstResult(startIndex);
		query.setMaxResults(maximumResult);
		@SuppressWarnings("unchecked")
		List<Object[]> rows=query.list();
		// getting the post with image
		  List<Post> postsWithImage = new ArrayList<Post>();
		for (Object[] row: rows)
		{
			// sets the data to the post table
			Post post=new Post();
		    post.setPostId((int) row[0]);
		    post.setPostDetails((String)row[1]);
		    post.setGroupId((int)row[2]);
		    post.setDatePosted((Timestamp) row[3]);
		    post.setLikes((int) row[4]);
		    post.setUpdatedAt( (Timestamp) row[5]);
		    post.setCreatedBy((String) row[6]);
		    post.setUpdatedBy((String) row[7]);
		    post.setIsDelete((int) row[8]);
		    post.setUser((User) row[9]);
		    postsWithImage.add(post);
		}
		// returns the list with post image
		return postsWithImage;
	}
	/**       
	 * Name: incrementLikesOnPost
	 * @param postId
	 * @param transaction
	 * @param session
	 * @return 
	 * @throws MetaSocioException
	 * Description: increments the likes on post
	 */
	public int incrementLikesOnPost(int postId,Session session) throws MetaSocioException
	{ 
		// Update like on post
		Query updateLikesOnPost = session.createQuery("UPDATE Post as pm SET pm.likes = pm.likes + 1 WHERE pm.postId = "+postId+"");
		return updateLikesOnPost.executeUpdate();
	}
	/**
	 * Name: decrementLikesOnpost
	 * @param postId
	 * @param transaction
	 * @param session
	 * @return 
	 * @throws MetaSocioException
	 */
	public int decrementLikesOnPost(int postId,Session session)  throws MetaSocioException 
	{
		// Descrement the likes on post
		Query updateNoOfLikes = session.createQuery("UPDATE Post as pm SET pm.likes = pm.likes - 1 WHERE pm.postId = "+postId+"");
		return updateNoOfLikes.executeUpdate();
	}
	public int deletePostByPostId(int postId, Session session) throws MetaSocioException  {
		Query updateIsDelete = session.createQuery("UPDATE Post as p SET p.isDelete "
				+ "= "+ 1 +" WHERE p.postId = "+postId+""); 		//Preparing query to update required field
		return updateIsDelete.executeUpdate();	
	}
	public int editPostByPostId(int postId, String postDetails, Session session) throws MetaSocioException  {
		Query editPost = session.createQuery("UPDATE Post as p SET p.postDetails=:postDetails WHERE p.postId = "+postId+""); 
		editPost.setString("postDetails", postDetails);
		//Preparing query to update required field
		return editPost.executeUpdate();	
	}
}
