package com.metasocio.test.likemanagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.metasocio.model.likemanagement.Like;

/**
 * @author CHETNA
 *
 */
public class LikeTest {

	@Test
	public void test1() {
		Like like = new Like();
		like.setCounter(20);
		assertEquals(20, like.getCounter());
	}

	@Test
	public void test2() {
		Like like = new Like();
		like.setCreatedBy("Chetna");
		assertEquals("Chetna", like.getCreatedBy());
	}

	@Test
	public void test3() {
		Like like = new Like();
		like.setIsLiked(0);
		assertEquals(0, like.getIsLiked());
	}

	@Test
	public void test4() {
		Like like = new Like();
		like.setLikerId(5);
		assertEquals(5, like.getLikerId());
	}
	

	@Test
	public void test5() {
		Like like = new Like();
		like.setUpdatedBy("Chetna");
		assertEquals("Chetna", like.getUpdatedBy());
	}
	

	@Test
	public void test6() {
		Like like = new Like();
		like.setCounter(9);
		assertNotNull(like.getCounter());
	}

}
