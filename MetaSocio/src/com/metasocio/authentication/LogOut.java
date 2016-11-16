package com.metasocio.authentication;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**************************************************************************
 *  Since : 23 November, 2015 
 *  Description : Servlet implementation class
 *         LogOut extending HttpServlet, it manages logging out operations of
 *         logged-in user
 ***************************************************************************/
@WebServlet("/LogOut")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogOut() {
		super();

	}

	/**************************************************************************
	 * This method manages the logging out operations of logged-in user and
	 * redirects to index jsp page and invalidate the current http session
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 ***************************************************************************/
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
				String message = "You have successfully logged out!";
				response.sendRedirect("https://www.google.com/accounts/Logout?continue=https://appengine.google.com/_ah/logout?continue=http://localhost:8080/MetaSocio/&message="
						+ URLEncoder.encode(message, "UTF-8"));
			}
		} catch (Exception e) {
			request.setAttribute("message", "didn't logged out successfully");
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
