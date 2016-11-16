
package com.metasocio.test.commentmanagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.metasocio.model.commentmanagement.Comment;
import com.metasocio.model.postmanagement.Post;
import com.metasocio.model.usermanagement.User;

/**
 * @author CHETNA
 *
 */
public class CommentTest {

	@Test
	public void test1() {
		Comment comment = new Comment();
		comment.setCommentId(1);
		assertEquals(1, comment.getCommentId());
	}

	@Test
	public void test2() {
		Comment comment = new Comment();
		comment.setCommentId(1);
		assertEquals(1, comment.getCommentId());
	}

	@Test
	public void test3() {
		Comment comment = new Comment();
		comment.setComments("It's my comment");
		assertEquals("It's my comment", comment.getComments());
	}

	@Test
	public void test4() {
		Comment comment = new Comment();
		comment.setCreatedBy("Saurabh");
		assertEquals("Saurabh", comment.getCreatedBy());
	}

	@Test
	public void test5() {
		Comment comment = new Comment();
		comment.setIsDelete(0);
		assertEquals(0, comment.getIsDelete());
	}

	@Test
	public void test6() {
		Comment comment = new Comment();
		Post post = new Post();
		comment.setPost(post);
		assertNotNull(comment.getPost());
	}

	@Test
	public void test7() {
		Comment comment = new Comment();
		User user = new User();
		comment.setUser(user);
		assertNotNull(comment.getUser());
	}

	@Test
	public void test8() {
		Comment comment = new Comment();
		comment.setUpdatedBy("Saurabh");
		assertEquals("Saurabh", comment.getUpdatedBy());
	}
}
