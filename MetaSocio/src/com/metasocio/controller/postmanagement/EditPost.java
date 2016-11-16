package com.metasocio.controller.postmanagement;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.service.postmanagement.PostService;
/**
 * Servlet implementation class EditPost
 */
@WebServlet("/EditPost")
public class EditPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		int postId=Integer.parseInt(request.getParameter("postId"));
		String postDetails=request.getParameter("postContent");
		PostService iPostService=new PostService();
		try {
			iPostService.editPostByPostId(postId, postDetails);
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(postDetails);
		} catch (MetaSocioSystemException e) {
			// TODO Auto-generated catch block
			request.setAttribute("message","Can't update the post");
			request.getRequestDispatcher("./exception/error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
