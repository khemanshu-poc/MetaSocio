package com.metasocio.model.postmanagement;
import java.sql.Timestamp;
import java.util.Date;
import com.metasocio.model.groupmanagement.Group;
import com.metasocio.model.usermanagement.User;
import lombok.Data;
/**
 * Name:Post
 * @author Anurag
 * Since: 28 November,2015
 * Description: Post Pojo Class
 */
public class Post
{
	// To store post id
	private	int postId;
	// To store Post Details
	private	String postDetails;
	// To store GroupId
	// to store Date
	private	Date datePosted;
	// To store Likes
	private	int likes;
	// To store Update At
	private	Timestamp updatedAt;
	// To store CreatedBy
	private	String createdBy;
	// To store UpdateBy
	private	String updatedBy;
	// to store is Delete Field
	private	int isDelete;
	private  User user;
	private int groupId;
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	/**
	 * @return the postId
	 */
	public int getPostId() {
		return postId;
	}
	/**
	 * @param postId the postId to set
	 */
	public void setPostId(int postId) {
		this.postId = postId;
	}
	/**
	 * @return the postDetails
	 */
	public String getPostDetails() {
		return postDetails;
	}
	/**
	 * @param postDetails the postDetails to set
	 */
	public void setPostDetails(String postDetails) {
		this.postDetails = postDetails;
	}
	/**
	 * @return the groupId
	 */
	/**
	 * @return the datePosted
	 */
	public Date getDatePosted() {
		return datePosted;
	}
	/**
	 * @param datePosted the datePosted to set
	 */
	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}
	/**
	 * @return the likes
	 */
	public int getLikes() {
		return likes;
	}
	/**
	 * @param likes the likes to set
	 */
	public void setLikes(int likes) {
		this.likes = likes;
	}
	/**
	 * @return the updatedAt
	 */
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}
	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	/**
	 * @return the isdelete
	 */
	public int getIsDelete() {
		return isDelete;
	}
	/**
	 * @param isdelete the isdelete to set
	 */
	public void setIsDelete(int isdelete) {
		this.isDelete = isdelete;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
