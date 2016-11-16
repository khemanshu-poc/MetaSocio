package com.metasocio.modelhelper;
import com.metasocio.model.commentmanagement.Comment;
import com.metasocio.model.postmanagement.Post;
public class ImageHelper {
	Post post;
	Comment comment;
	String imageURL = "";
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
}
