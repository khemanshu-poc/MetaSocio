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

/*****************************************************************
 * Servlet implementation class AddFriend
 *****************************************************************/
@WebServlet("/DeleteGroup")
public class DeleteGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	/***********************************************************************
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 **********************************************************************/
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		//getting attribute from current http session
		User user = (User) session.getAttribute("userObject");
		//creating object of UserService
		UserService iUserService = new UserService();
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		GroupService iGroupService = new GroupService();
		System.out.println(groupId);
		try {
			User admin = iUserService.getUserByEmail(user.getEmailId());
			Group group = iGroupService.getGroupById(groupId);
			if (group.getUser().getUserId() == admin.getUserId()) {
				group.setUpdatedBy(admin.getName());
				group.setIsdelete(1);
				group.getUsersSet().clear();
				iGroupService.updateGroup(group);
			}
			response.sendRedirect("HomePage");
		} catch (MetaSocioSystemException e) {

			request.setAttribute("message", "Sorry....group can't be deleted....");
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
