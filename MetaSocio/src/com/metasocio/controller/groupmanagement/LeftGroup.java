package com.metasocio.controller.groupmanagement;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.groupmanagement.Group;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.groupmanagement.GroupService;
import com.metasocio.service.usermanagement.UserService;

/******************************************************************
 * class that has control of left group Servlet implementation 
 * class Left group
 *****************************************************************/
@WebServlet("/LeftGroup")
public class LeftGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LeftGroup() {
		super();
	}

	/**********************************************************************
	 * This method is used to left group
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 **********************************************************************/
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		//getting paramete from session
		User user = (User) session.getAttribute("userObject");
		UserService iUserService = new UserService(); //creating object of UserService
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		GroupService iGroupService = new GroupService();
		try {
			@SuppressWarnings("unused")
			User leftingUser = iUserService.getUserByEmail(user.getEmailId());
			Group group = iGroupService.getGroupById(groupId);
			Set<User> membersSet = group.getUsersSet();
			group.getUsersSet().clear();
			iGroupService.updateGroup(group);
			group.setUsersSet(membersSet);
			iGroupService.updateGroup(group);
			response.sendRedirect("HomePage");

		} catch (MetaSocioSystemException e) {
			request.setAttribute("message", "Sorry,Can't delete the group !! Please try after sometime");
			request.getRequestDispatcher("./exception/error.jsp").forward(
					request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
