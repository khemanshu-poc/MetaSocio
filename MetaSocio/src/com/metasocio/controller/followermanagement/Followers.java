package com.metasocio.controller.followermanagement;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.followermanagement.FollowerService;

/****************************************************************
 * Servlet implementation class Followers
 ***************************************************************/
@WebServlet("/Followers")
public class Followers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Followers() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**********************************************************************************************
	 * To get followers list (list of users who are following the present user) on view this
	 * 							 servlet will be called from user home page to get followers list
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *********************************************************************************************/
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			HttpSession session = request.getSession(false);		
			User user = (User) session.getAttribute("userObject");		//Getting user object from session
			FollowerService iFollowerService = new FollowerService();	//Creating instance of follower Service
			List<User> followersList = iFollowerService.getFollowers(user);	//Getting followers list
			List<User> followersWhomYouAreNotFollowing = iFollowerService	//Getting list of followers whom present user does not follows
					.getUsersWhomYouAreNotFollowing(user.getUserId(),
							followersList);
			
			//Setting attribute to request
			request.setAttribute("followersWhomYouAreNotFollowing",	
					followersWhomYouAreNotFollowing);		
			request.setAttribute("usersList", followersList);
			request.setAttribute("listTitle", "Followers");
			request.getRequestDispatcher(
					"./view/followermanagement/followers.jsp").forward(request,
					response);			//Forwarding to followers list page
		} catch (MetaSocioSystemException e) {
			request.setAttribute("message", "Can't find followers");
			request.getRequestDispatcher("./exception/error.jsp").forward(
					request, response);		//Forwarding to error page if any exception occurred
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
