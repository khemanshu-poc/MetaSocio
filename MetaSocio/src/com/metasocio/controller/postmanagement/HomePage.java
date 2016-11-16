package com.metasocio.controller.postmanagement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.commentmanagement.Comment;
import com.metasocio.model.postmanagement.Post;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.commentmanagement.CommentService;
import com.metasocio.service.followermanagement.FollowerService;
import com.metasocio.service.likemanagement.LikeService;
import com.metasocio.service.postmanagement.PostService;
import com.metasocio.service.usermanagement.UserService;

/**
 * Servlet implementation class HomePage
 */
@WebServlet("/HomePage")
/**
 * Name: HomePage
 * @author Anurag
 * Since: 28 November,2015
 * Description: It extends the homepage and extends the http servlet 
 */
public class HomePage extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomePage()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Name: doGet
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *      Description: gets the value and sends the data
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		User user = new User();
		try
		{
			// Getting the value from the session
			HttpSession session = request.getSession(false);
			user = (User) session.getAttribute("userObject");
			// Calling the service Layer
			UserService iUserService = new UserService();
			// isService.setUserInfo(user);
			PostService iPostService = new PostService();
			// Calling the Comment service layer
			CommentService iCommentService = new CommentService();
			List<User> usersOfSamedepartment;
			// getting the users from the same deepartment
			usersOfSamedepartment = iUserService.getUsersHavingSameDepartment(user);
			// Putting the postmap with the list and post
			Map<Post, List<Comment>> postMap = new LinkedHashMap<Post, List<Comment>>();
			Map<Post, Boolean> likeMap = new LinkedHashMap<Post,Boolean>();
			
			int startIndex = 0;
			int maximumResult = 2;
			int groupId = 0;
			// Getting the posts with image
			List<Post> postsWithImage = iPostService.retrievePostWithImageOnHome(startIndex,maximumResult,groupId);
			
			
			
			
			
			
			
			LikeService iLikeService  = new LikeService();
			FollowerService iFollowerService=new FollowerService();
			List<User> followersList = iFollowerService.getFollowers(user);
			// Iterating over post 
			for (Post post : postsWithImage) 
			{
				boolean isLikedByUser = iLikeService.hasUSerAlreadyLiked(user.getUserId(),post.getPostId());
				// Adding to the list with comment
				List<Comment> commentsWithImage = iCommentService.retrieveCommentListWithImageByPostID(post.getPostId());
				// puts the post with image
				postMap.put(post, commentsWithImage);
				likeMap.put(post, isLikedByUser);
			}
			request.setAttribute("followerList", followersList);
			request.setAttribute("usersList", usersOfSamedepartment);
			request.setAttribute("postMap", postMap);
			request.setAttribute("likeMap", likeMap);
			request.getRequestDispatcher("./view/postmanagement/home.jsp")
					.forward(request, response);
		} 
		catch (MetaSocioSystemException e) 
		{
			
			request.setAttribute("message", "Cant Show your timeline. Please try After some time.");
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
