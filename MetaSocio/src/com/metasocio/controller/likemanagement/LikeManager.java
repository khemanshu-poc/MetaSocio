package com.metasocio.controller.likemanagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.likemanagement.LikeService;

/**
 * @author 
 * Since : 23 November, 2015
 *  Description : Servlet implementation class
 *         LikeManager extending HttpServlet, Managing likes regarding
 *         operations
 */
@WebServlet("/LikeManager")
public class LikeManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**********************************************************************
	 * constructor for this class invoking super class also
	 * 
	 * @see HttpServlet#HttpServlet()
	 *********************************************************************/
	public LikeManager() {
		super();
	}

	/**
	 * This method is called when user makes a get request.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response); // calling doPost method
	}

	/*****************************************************************************************
	 * This function is called when user makes a post request
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 ****************************************************************************************/
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String postID = request.getParameter("postID"); // getting parameter
														// from request
		
		//int groupId = Integer.parseInt(request.getParameter("groupId"));
		User user = new User(); // Creating instance of 'User' POJO
		try {
			String LikesUpdated = null;
			HttpSession session = request.getSession(false); // Checking for session
			user = (User) session.getAttribute("userObject"); // Getting session attribute (user info)
			LikeService iService = new LikeService(); // Creating instance of 'LikeService' class
			iService.manageLikes(user, Integer.parseInt(postID));
			// calling function of LikeService class to manage whole like operations
			System.out.println("postid" + postID);
			int noOfLikes = iService.LikesOnPostByPostId(Integer
					.parseInt(postID));
			String likes = Integer.toString(noOfLikes);
			
			LikeService iLikeService = new LikeService();
			boolean isLikedByUser = iLikeService.hasUSerAlreadyLiked(
					user.getUserId(), Integer.parseInt(postID));
			System.out.println(isLikedByUser);
			if (isLikedByUser) {
				LikesUpdated = "<a href='#'><i class='fa fa-thumbs-up' id ='like"
						+ postID
						+ "' onClick='loadInfo("
						+ postID
						+ ")"
						+ "' value='"
						+ postID
						+ "' style='color:grey'></i></a>" + likes;
			} else {
				LikesUpdated = "<a href='#'><i class='fa fa-thumbs-up' id ='like"
						+ postID
						+ "' onClick='loadInfo("
						+ postID
						+ ")"
						+ "' value='"
						+ postID
						+ "' style='color:orange'></i></a>" + likes;
			}
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(LikesUpdated);// redirecting to caller
		/*} */}catch (MetaSocioSystemException e) {
			request.setAttribute("message", "Error in Getting likes, Please try After some time."); // setting an attribute in request
			request.getRequestDispatcher("./exception/error.jsp").forward(request, response); // forwarding to error page if any exception occurs
		}
	}
}
