package com.metasocio.controller.postmanagement;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.groupmanagement.Group;
import com.metasocio.service.postmanagement.PostService;
/**
 * Servlet implementation class DeletePost
 */
@WebServlet("/DeletePost")
public class DeletePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletePost() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postId=Integer.parseInt(request.getParameter("postId"));
		PostService iPostService=new PostService();
		try {
			iPostService.deletePostByPostId(postId);
			if(request.getParameter("pageTitle")!= null && request.getParameter("pageTitle").equalsIgnoreCase("groupPage")){
				HttpSession session =request.getSession(false);
				
				Group group = (Group) session.getAttribute("groupObject");
				response.sendRedirect("GroupPage?groupId=" + group.getGroupId() );
			}	
			else{
			response.sendRedirect("HomePage");
			}
		} catch (MetaSocioSystemException e) {
			// TODO Auto-generated catch block
			String errorMessage="Can't delete post";
			request.setAttribute("message",errorMessage);
			request.getRequestDispatcher("./exception/error.jsp").forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
