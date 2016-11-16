package com.metasocio.test.postmanagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.metasocio.exception.MetaSocioException;
import com.metasocio.hibernate.factory.ConfigurationFactory;
import com.metasocio.service.postmanagement.PostService;

public class PostServiceTest {


	
	@Test
	public void test1() throws MetaSocioException {
		PostService postService = new PostService();
		assertNotNull(postService.deletePostByPostId(1));
	}
	
	
	@Test
	public void test2() throws MetaSocioException {
		PostService postService = new PostService();
		int value = postService.deletePostByPostId(1);
		assertEquals(0, value);
	}
	

	@Test
	public void test3() throws MetaSocioException {
		PostService postService = new PostService();
		assertNotNull(postService.retrievePostWithImageOnHome(1, 2, 0));
	}
	
	@Test
	public void test4() throws MetaSocioException {
		PostService postService = new PostService();
		assertNotNull(postService.editPostByPostId(1, "postDetails"));
	}
}
