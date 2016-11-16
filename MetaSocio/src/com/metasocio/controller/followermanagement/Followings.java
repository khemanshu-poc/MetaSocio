package com.metasocio.controller.followermanagement;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.followermanagement.FollowerService;

/*************************************************************************
 * Servlet implementation class Followings, has control of followings
 ************************************************************************/
@WebServlet("/Followings")
public class Followings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Followings() {
        super();
    }
    

    /****************************************************************************************
	 * To get followings list (list of users followed by present user ) on view this
	 * 						 servlet will be called from user home page to get followings list
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *****************************************************************************************/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
			User user = (User) session.getAttribute("userObject");		//Getting user object from session
			FollowerService iFollowerService=new FollowerService();		//Creating instance of follower Service
			
			try {						
				int followerId = user.getUserId();			//getting id of present user
				List<User> followingsList = iFollowerService.getFollowings(followerId);		//Getting list of followings of present user
				request.setAttribute("listTitle", "Followings");
				request.setAttribute("usersList", followingsList);
				request.getRequestDispatcher("./view/followermanagement/followers.jsp").forward(request, response);				
			} catch (MetaSocioSystemException e) {
				request.setAttribute("message","Can't find followings");
				request.getRequestDispatcher("./exception/error.jsp").forward(request, response);
			}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
