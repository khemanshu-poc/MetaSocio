package com.metasocio.controller.commentmanagement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.service.commentmanagement.CommentService;
/**************************************************************************
 * @author 
 * Since : 27 November, 2015
 *  Description : This class provides control
 *         to edit comments, this Servlet implementation class EditComment
 ***************************************************************************/
/**
 * Servlet implementation class EditPost
 */
@WebServlet("/EditComment")
public class EditComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditComment() {
		super();
	}

	/**********************************************************************************
	 * This method provides control from home Page to database that is getting
	 * comment id and comment content from home Page and edit that comment in database
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *      
	 ********************************************************************************/
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in edit comment    ------------------------------");
		int commentId = Integer.parseInt(request.getParameter("commentId"));	//Getting comment id which is to edit
		String commentDetails = request.getParameter("commentContent");		//edited comment details
		CommentService iCommentService = new CommentService();			//Creating instance of commentService
		try {
			iCommentService.editCommentByCommentId(commentId, commentDetails);		//calling comment service class to perform edit comment operation
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(commentDetails);		//setting comment details to response
		} catch (MetaSocioSystemException e) {
			request.setAttribute("message", "Can't update the comment");
			request.getRequestDispatcher("./exception/error.jsp").forward(
					request, response);			//Forwarding to error page
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
