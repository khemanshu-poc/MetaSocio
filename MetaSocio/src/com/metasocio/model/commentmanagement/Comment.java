package com.metasocio.model.commentmanagement;
import java.sql.Timestamp;
import java.util.Date;
import com.metasocio.model.postmanagement.Post;
import com.metasocio.model.usermanagement.User;
import lombok.Data;
/*******************************************************************
 * POJO class of Comment
 ********************************************************************/
@Data
public class Comment {
	private	int commentId;
	private	String comments;
	private	Date dateCommented;
	private	Timestamp updatedAt;
	private	String createdBy;
	private	String updatedBy;
	private	int isDelete;	
	private	Post post;
	private	User user;
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getDateCommented() {
		return dateCommented;
	}
	public void setDateCommented(Date dateCommented) {
		this.dateCommented = dateCommented;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
