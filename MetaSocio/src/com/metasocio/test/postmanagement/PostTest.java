package com.metasocio.test.postmanagement;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.metasocio.model.postmanagement.Post;

/**
 * @author CHETNA
 *
 */
public class PostTest {

	@Test
	public void test1() {
		Post post = new Post();
		post.setPostId(1);
		assertEquals(1, post.getPostId());
	}
	
	@Test
	public void test2() {
		Post post = new Post();
		post.setGroupId(3);;
		assertEquals(3, post.getGroupId());
	}
	
	@Test
	public void test3() {
		Post post = new Post();
		post.setLikes(30);;
		assertEquals(30, post.getLikes());
	}
	
	@Test
	public void test4() {
		Post post = new Post();
		post.setPostDetails("Hello...It's my post");;
		assertEquals("Hello...It's my post", post.getPostDetails());
	}
	
	@Test
	public void test5() {
		Post post = new Post();
		post.setCreatedBy("Admin");
		assertEquals("Admin", post.getCreatedBy());
	}
	
	@Test
	public void test6() {
		Post post = new Post();
		post.setIsDelete(1);
		assertEquals(1, post.getIsDelete());
	}
	

	@Test
	public void test7() {
		Post post = new Post();
		post.setUpdatedBy("Admin");
		assertEquals("Admin", post.getUpdatedBy());
	}

}
