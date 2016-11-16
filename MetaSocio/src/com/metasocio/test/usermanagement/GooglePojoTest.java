package com.metasocio.test.usermanagement;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.metasocio.model.usermanagement.GooglePojo;

public class GooglePojoTest {

	@Test
	public void test1() {
		GooglePojo googlePojo = new GooglePojo();
		googlePojo.setEmail("chetna.sharma@metacube.com");
		assertEquals("chetna.sharma@metacube.com", googlePojo.getEmail());
	}

	@Test
	public void test2() {
		GooglePojo googlePojo = new GooglePojo();
		googlePojo.setId("id1");
		assertEquals("id1", googlePojo.getId());

	}

	@Test
	public void test3() {
		GooglePojo googlePojo = new GooglePojo();
		googlePojo.setFamily_name("Sharma");
		assertEquals("Sharma", googlePojo.getFamily_name());
	}
	
	@Test
	public void test4() {
		GooglePojo googlePojo = new GooglePojo();
		googlePojo.setGiven_name("Nidhi Sharma");;
		assertEquals("Nidhi Sharma", googlePojo.getGiven_name());
	}
	
	@Test
	public void test5() {
		GooglePojo googlePojo = new GooglePojo();
		googlePojo.setHd("metaacube.com");;
		assertEquals("metaacube.com", googlePojo.getHd());
	}
	
	@Test
	public void test6() {
		GooglePojo googlePojo = new GooglePojo();
		googlePojo.setPicture("pictureURL");;
		assertEquals("pictureURL", googlePojo.getPicture());
	}

}
