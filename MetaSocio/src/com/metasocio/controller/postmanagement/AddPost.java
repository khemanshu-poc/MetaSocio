package com.metasocio.controller.postmanagement;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.postmanagement.Post;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.postmanagement.PostService;

/**
 * Servlet implementation class AddPost
 */
@WebServlet("/AddPost")
/**
 * Name:AddPost
 * @author Anurag,2015
 * Since:28 November
 * Description: Adds The post to the Home Page
 */
public class AddPost extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Name: doGet
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Description: Gets the request
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	}

	/**
	 * Name: doPost
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Description: Post the Data and Calls the Next servlet
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String post=request.getParameter("post");
	
		User user=new User();
		try 
		{
			int groupId;
			if((request.getParameter("groupId")!=null)){
				groupId = Integer.parseInt(request.getParameter("groupId"));
			}else{
				groupId = 0;
			}
			
			
			HttpSession session =request.getSession(false);
		
			user=(User) session.getAttribute("userObject");
			
			PostService iPostService=new PostService();
			Post newPost=new Post();
			Date date= new java.util.Date();
			newPost.setDatePosted(date);
			newPost.setCreatedBy(user.getName());
			newPost.setGroupId(groupId);
			newPost.setUser(user);
			
			newPost.setPostDetails(post);
			
			iPostService.savePost(newPost);
		
			if(request.getParameter("pageTitle")!= null && request.getParameter("pageTitle").equalsIgnoreCase("groupPage")){
				response.sendRedirect("GroupPage?groupId="+groupId);
			}	
			else{
			response.sendRedirect("HomePage");
		} }
		catch (MetaSocioSystemException e) 
		{
			request.setAttribute("message","Can't share the post");
			request.getRequestDispatcher("./exception/error.jsp").forward(request, response);
		}
	}
}
