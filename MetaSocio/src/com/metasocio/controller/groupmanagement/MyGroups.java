package com.metasocio.controller.groupmanagement;

import java.io.IOException;
import java.util.List;

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
 * class that has control to show group list Servlet implementation class
 * MyGroups
 *****************************************************************/
@WebServlet("/MyGroups")
public class MyGroups extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyGroups() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *************************************************************************/
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//getting existing session
		HttpSession session = request.getSession(false);
		//getting object from session
		User user = (User) session.getAttribute("userObject");
		//creating object of UserService
		UserService iUserService = new UserService();
		//creating object of GroupService
		GroupService iGroupService = new GroupService();

		try {
			User member = iUserService.getUserByEmail(user.getEmailId());
			List<Group> myGroupList = iGroupService.getMyGroups(user
					.getUserId());

			request.setAttribute("listTitle", "My Group List");
			request.setAttribute("groupList", myGroupList);
			request.getRequestDispatcher(
					"./view/followermanagement/followers.jsp").forward(request,
					response);
		} catch (MetaSocioSystemException e) {
			 request.setAttribute("message","Sorry,Can't show your groups list!! Please try after sometime");
			  request.getRequestDispatcher("./exception/error.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
