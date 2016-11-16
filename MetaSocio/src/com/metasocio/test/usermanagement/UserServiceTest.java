package com.metasocio.test.usermanagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.metasocio.exception.MetaSocioException;
import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.usermanagement.UserService;

public class UserServiceTest {

	@Test
	public void test1() throws MetaSocioException {
		UserService userService = new UserService();
		assertNotNull(userService
				.getUserByEmail("pooja.khandelwal@metacube.com"));
	}

	@Test
	public void test2() throws MetaSocioException {
		UserService userService = new UserService();
		assertNotNull(userService.getUserById(1));
	}

	@Test(expected = MetaSocioException.class)
	public void test3() throws MetaSocioSystemException {
		UserService userService = new UserService();
		User user = new User();
		assertNotNull(userService.getUsersHavingSameDepartment(user));
	}

	@Test
	public void test4() throws MetaSocioException {
		UserService userService = new UserService();
		boolean check = userService
				.isEmailExists("pooja.khandelwal@metacube.com");
		assertEquals(true, check);
	}

	@Test(expected = MetaSocioSystemException.class)
	public void test5() throws MetaSocioException {
		UserService userService = new UserService();
		User user = new User();
		boolean check = userService.setUserInfo(user);
		assertEquals(true, check);
	}
}
