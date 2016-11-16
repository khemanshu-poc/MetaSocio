package com.metasocio.test.usermanagement;

import static org.junit.Assert.*;

import org.junit.Test;

import com.metasocio.model.usermanagement.User;

public class UserTest {

	@Test
	public void test1() {
	User user = new User();
	user.setName("Chetna");
	assertEquals("Chetna", user.getName());
	}
	

	@Test
	public void test2() {
	User user = new User();
	user.setUserId(1);
	assertEquals(1, user.getUserId());
	}
	

	@Test
	public void test3() {
	User user = new User();
	user.setAbout("about");;
	assertEquals("about", user.getAbout());
	}
	

	@Test
	public void test5() {
	User user = new User();
	user.setAddress("Jaipur");;
	assertEquals("Jaipur", user.getAddress());
	}
	

	@Test
	public void test6() {
	User user = new User();
	user.setCity("Jaipur");
	assertEquals("Jaipur", user.getCity());
	}
	

	@Test
	public void test7() {
	User user = new User();
	user.setCreatedBy("admin");
	assertEquals("admin", user.getCreatedBy());
	}
	

	@Test
	public void test8() {
	User user = new User();
	user.setDepartment("Java");
	assertEquals("Java", user.getDepartment());
	}
	

	@Test
	public void test9() {
	User user = new User();
	user.setGender("Female");
	assertEquals("Female", user.getGender());
	}

	@Test
	public void test10() {
	User user = new User();
	user.setCollege("JECRC");
	assertEquals("JECRC", user.getCollege());
	}
	@Test
	public void test11() {
	User user = new User();
	user.setEmailId("c@metacube.com");
	assertEquals("c@metacube.com", user.getEmailId());
	}
	@Test
	public void test12() {
	User user = new User();
	user.setCourse("OOPS");
	assertEquals("OOPS", user.getCourse());
	}
	@Test
	public void test13() {
	User user = new User();
	user.setImageURL("imageURL");;
	assertEquals("imageURL", user.getImageURL());
	}
	@Test
	public void test14() {
	User user = new User();
	user.setNickName("Jimmy");
	assertEquals("Jimmy", user.getNickName());
	}
	@Test
	public void test15() {
	User user = new User();
	user.setPhoneNo("9879654232");
	assertEquals("9879654232", user.getPhoneNo());
	}
	@Test
	public void test16() {
	User user = new User();
	user.setRelationshipStatus("Single");
	assertEquals("Single", user.getRelationshipStatus());
	}
	
	@Test
	public void test17() {
	User user = new User();
	user.setRole("Trainee");
	assertEquals("Trainee", user.getRole());
	}
	@Test
	public void test18() {
	User user = new User();
	user.setIsDelete(0);;
	assertEquals(0 , user.getIsDelete());
	}
}
