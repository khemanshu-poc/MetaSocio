package com.metasocio.test.groupmanagement;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.metasocio.model.groupmanagement.Group;

public class GroupTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test1() {
		Group group = new Group();
		group.setCreatedBy("admin");
		assertEquals("admin", group.getCreatedBy());
	}

	@Test
	public void test2() {
		Group group = new Group();
		group.setGroupId(1);
		assertEquals(1, group.getGroupId());
	}


	@Test
	public void test3() {
		Group group = new Group();
		group.setGroupName("GET");;
		assertEquals("GET", group.getGroupName());
	}


	@Test
	public void test4() {
		Group group = new Group();
		group.setImageUrl("imageUrl");
		assertEquals("imageUrl", group.getImageUrl());
	}


	@Test
	public void test5() {
		Group group = new Group();
		group.setIsdelete(1);
		assertEquals(1, group.getIsdelete());
	}
	

	@Test
	public void test6() {
		Group group = new Group();
		group.setUpdatedBy("A");
		assertEquals("A", group.getUpdatedBy());
	}


}
