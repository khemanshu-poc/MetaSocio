package com.metasocio.test.followermanagement;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.metasocio.model.followermanagement.FollowersAndFollowings;

/**
 * @author CHETNA
 *
 */
public class FollowersAndFollowingsTest {

	@Test
	public void test1() {
		FollowersAndFollowings followersAndFollowings = new FollowersAndFollowings();
		followersAndFollowings.setFollowerId(2);
		assertEquals(2, followersAndFollowings.getFollowerId());
	}

	@Test
	public void test2() {
		FollowersAndFollowings followersAndFollowings = new FollowersAndFollowings();
		followersAndFollowings.setFollowerId(2);
		assertEquals(2, followersAndFollowings.getFollowerId());
	}

	@Test
	public void test3() {
		FollowersAndFollowings followersAndFollowings = new FollowersAndFollowings();
		followersAndFollowings.setFollowingId(3);
		assertEquals(3, followersAndFollowings.getFollowingId());
	}

	@Test
	public void test4() {
		FollowersAndFollowings followersAndFollowings = new FollowersAndFollowings();
		followersAndFollowings.setId(1);
		assertEquals(1, followersAndFollowings.getId());
	}

	@Test
	public void test5() {
		FollowersAndFollowings followersAndFollowings = new FollowersAndFollowings();
		followersAndFollowings.setCreatedBy("chetna");
		assertEquals("chetna", followersAndFollowings.getCreatedBy());
	}
	
	@Test
	public void test6() {
		FollowersAndFollowings followersAndFollowings = new FollowersAndFollowings();
		followersAndFollowings.setIsDelete(0);
		assertEquals(0, followersAndFollowings.getIsDelete());
	}

}
