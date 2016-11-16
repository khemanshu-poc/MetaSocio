package com.metasocio.controller.followermanagement;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.followermanagement.FollowerService;
import com.metasocio.service.usermanagement.UserService;

/*************************************************************************************
 * This class provides control to following person , this Servlet implementation
 * class AddComment
 *************************************************************************************/
@WebServlet("/FollowPeople")
public class FollowPeople extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FollowPeople() {
		super();
	}

	/********************************************************************************************
	 * This method is adding a person to user's following list
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *******************************************************************************************/
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			int followerId;
			HttpSession session = request.getSession(false);
			//getting attribute from current http session
			User follower = (User) session.getAttribute("userObject");
			followerId = follower.getUserId();
			//creating object of UserService class
			UserService iUserService = new UserService();
			int followingId = (Integer.parseInt(request
					.getParameter("followingId")));
			//calling getUserById method existing in UserService class
			User following = iUserService.getUserById(followingId);
			FollowerService iFollowerService = new FollowerService();
			//getting all users in following set
			Set<User> followingsSet = follower.getUsers();
			followingsSet.add(following);
			follower.setUsers(followingsSet);
			iFollowerService.addFollowing(follower);
			String title = (String) request.getParameter("title");
			//if title is null then redirects to Followers controller otherwise HomePage controller
			if (title != null) {
				if (title.equalsIgnoreCase("Followers")) {
					response.sendRedirect("Followers");
				}
			} else {
				response.sendRedirect("HomePage");
			}
		} catch (MetaSocioSystemException e) {

			request.setAttribute("message", "Sorry,You can't follow the person!! Please try after sometime");
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
