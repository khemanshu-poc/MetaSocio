package com.metasocio.about;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**************************************************************************
 * Since:28 November,2015
 *  Description: AboutMetaSocio class is a
 *         Servlet, that has control of what-is-META-SOCIO page
 ************************************************************************/
@WebServlet("/AboutMetaSocio")
public class AboutMetaSocio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AboutMetaSocio() {
		super();
	}

	/************************************************************************************
	 * This method is used to send flow of application to what-is-META-SOCIO jsp
	 * page
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *************************************************************************************/
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("./view/about/what-is-META-SOCIO.jsp")
				.forward(request, response);
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
