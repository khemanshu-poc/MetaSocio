package com.metasocio.controller.groupmanagement;

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
import com.metasocio.model.groupmanagement.Group;
import com.metasocio.model.postmanagement.Post;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.commentmanagement.CommentService;
import com.metasocio.service.followermanagement.FollowerService;
import com.metasocio.service.groupmanagement.GroupService;
import com.metasocio.service.likemanagement.LikeService;
import com.metasocio.service.postmanagement.PostService;
import com.metasocio.service.usermanagement.UserService;

/******************************************************************
 * class that has control of group page
 * Servlet implementation class GroupPage
 *****************************************************************/
@WebServlet("/GroupPage")
public class GroupPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GroupPage() {
		super();
	}

	/**********************************************************************
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *********************************************************************/
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		User user = (User) session.getAttribute("userObject");
		GroupService iGroupService = new GroupService(); //creating object of GroupService
		UserService iUserService = new UserService();//creating object of UserService
		PostService iPostService = new PostService();//creating object of PostService

		try {
			Group group = iGroupService.getGroupById(groupId);
			User groupMember = iUserService.getUserByEmail(user.getEmailId());
			CommentService iCommentService = new CommentService();

			List<User> usersOfSamedepartmentWhoAreNotGroupMembers = iGroupService
					.getUsersHavingSameDepartmentWhoAreNotGroupMembers(
							groupMember.getDepartment(), group.getGroupId());
			// Returning list of users who are not the member of group but
			// having same department as present user have
			request.setAttribute("userObject", groupMember);
			request.setAttribute("groupObject", group);
			Map<Post, List<Comment>> postMap = new LinkedHashMap<Post, List<Comment>>();
			int startIndex = 0;
			int maximumResult = 2;
			List<Post> postsWithImage = iPostService
					.retrievePostWithImageOnHome(startIndex, maximumResult,
							group.getGroupId()); // Retrieving group posts on
													// group page
			LikeService iLikeService = new LikeService();
			Map<Post, Boolean> likeMap = new LinkedHashMap<Post, Boolean>();
			for (Post post : postsWithImage) {
				 // Retrieving like on particular post by present user
				boolean isLikedByUser = iLikeService.hasUSerAlreadyLiked(
						groupMember.getUserId(), post.getPostId());
				 // Retrieving comments list on particular post
				List<Comment> commentsWithImage = iCommentService
						.retrieveCommentListWithImageByPostID(post.getPostId());
				postMap.put(post, commentsWithImage); //putting into postMap
				likeMap.put(post, isLikedByUser); //putting into postMap
			}

			FollowerService iFollowerService = new FollowerService();
			List<User> followersList = iFollowerService.getFollowers(user);
			if (!usersOfSamedepartmentWhoAreNotGroupMembers.isEmpty()) {
				request.setAttribute("suggestedUser",
						usersOfSamedepartmentWhoAreNotGroupMembers
								.get(usersOfSamedepartmentWhoAreNotGroupMembers
										.size() - 1));
			}
			request.setAttribute("followerList", followersList);
			System.out.println("post size " + postMap.size());
			request.setAttribute("postMap", postMap);
			request.setAttribute("likeMap", likeMap);

			request.getRequestDispatcher("./view/groupmanagement/group.jsp")
					.forward(request, response);
		} catch (MetaSocioSystemException e) {
			request.setAttribute("message", "Sorry can't show your timeline!! Please try after sometime");
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
