package com.metasocio.controller.followermanagement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metasocio.model.usermanagement.User;
import com.metasocio.service.followermanagement.FollowerService;

/*************************************************************************************
 * This class provides control to unfollow person , this Servlet implementation
 * class AddComment
 *************************************************************************************/
@WebServlet("/Unfollow")
public class Unfollow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Unfollow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/*************************************************************************************
	 * This method is removing followed person from user's following list
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 **************************************************************************************/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		//getting attribute from current http session
		User user = (User) session.getAttribute("userObject");
		//creating object of FollowerService class
		FollowerService iFollowerService=new FollowerService();
		int followerId;
		int followingId =(Integer.parseInt(request.getParameter("followingId"))) ;
	
		try {	
			followerId = user.getUserId();
			iFollowerService.removeFriend(followerId, followingId);
		    response.sendRedirect("Followings");						
		} catch (Exception e) {
		
			request.setAttribute("message","Sorry,You can't unfollow the person!! Please try after sometime");
			request.getRequestDispatcher("./exception/error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
