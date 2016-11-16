package com.metasocio.controller.groupmanagement;

import java.io.IOException;

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
 * class that has control of join group 
 * Servlet implementation class JoinGroup
 *****************************************************************/
@WebServlet("/JoinGroup")
public class JoinGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JoinGroup() {
		super();
	}

	/**********************************************************************
	 * Method to join group
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 **********************************************************************/
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		Group group = new Group();
		User newMember = new User();
		UserService iUserService = new UserService();

		GroupService iGroupService = new GroupService();

		try {

			if (request.getParameter("pageTitle") != null
					&& request.getParameter("pageTitle").equalsIgnoreCase(
							"groupPage")) {
				group = (Group) session.getAttribute("groupObject");
				int userId = Integer.parseInt(request.getParameter("userId"));
				newMember = iUserService.getUserById(userId);
				System.out.println("Coming from group Page to join controller");

			} else {
				newMember = (User) session.getAttribute("userObject");

				int groupId = Integer.parseInt(request.getParameter("groupId"));
				group = iGroupService.getGroupById(groupId);
				System.out.println("Coming from home to join controller");
			}

			System.out.println("groupId on join controller "
					+ group.getGroupId());
			System.out.println("Joiner Id on join controller "
					+ newMember.getUserId());
			group.getUsersSet().add(newMember);
			iGroupService.updateGroup(group);

			response.sendRedirect("GroupPage?groupId=" + group.getGroupId());

		} catch (MetaSocioSystemException e) {

			request.setAttribute("message", "Sorry,you can't join the group!! Please try after sometime");
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
