package com.metasocio.controller.commentmanagement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.groupmanagement.Group;
import com.metasocio.service.commentmanagement.CommentService;

/**************************************************************************
 * @author
 *  Since : 27 November, 2015 
 *  Description : This class provides control
 *         to delete comments, this Servlet implementation class DeleteComment
 ***************************************************************************/
@WebServlet("/DeleteComment")
public class DeleteComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteComment() {
		super();
	}

	/**********************************************************************************
	 * This method provides control from home Page to database that is getting
	 * comment id from home Page and delete that comment from database
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 ********************************************************************************/
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int commentId = Integer.parseInt(request.getParameter("commentId"));// getting comment id of comment  to be deleted from homepage
		CommentService iCommentService = new CommentService();// creating instance of CommentService class
		try {
			iCommentService.deleteCommentByCommentId(commentId);// deleting comment by calling deleteCommentByCommentId() method exists in 
			                                                    //CommentService class  if pageTitle retrived from request is group page 
			                                                     //then redirect to Group[Page controller else redirects to HomePage controller
			if (request.getParameter("pageTitle") != null
					&& request.getParameter("pageTitle").equalsIgnoreCase(
							"groupPage")) {
				HttpSession session = request.getSession(false);// getting http  session
				Group group = (Group) session.getAttribute("groupObject");// getting  group object from current http session
				response.sendRedirect("GroupPage?groupId=" + group.getGroupId());// redirecting user to GroupPage  controller
			} else {
				response.sendRedirect("HomePage");// redirecting user to HomePage controller
			}
		} catch (MetaSocioSystemException e) {
			String errorMessage = "Can't delete comment";
			request.setAttribute("message", errorMessage);
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
	}

}
