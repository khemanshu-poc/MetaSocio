package com.metasocio.controller.groupmanagement;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.groupmanagement.Group;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.groupmanagement.GroupService;
import com.metasocio.service.usermanagement.UserService;

/**************************************************************************************
 * This class has control of getting remaining group in which user is not a member
 * 
 * Servlet implementation class AddFriend
 *************************************************************************************/
@WebServlet("/GetRemainingGroups")
public class GetRemainingGroups extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRemainingGroups() {
        super();
        // TODO Auto-generated constructor stub
    }

	/*****************************************************************************************
	 * This method is getting remaining groups in which user is not a member
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 ***************************************************************************************/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);
		User user = (User) session.getAttribute("userObject");
		UserService iUserService = new UserService(); // create group of UserService class
		GroupService iGroupService=new GroupService();// create group of GroupService class

		try {	
			User member = iUserService.getUserByEmail(user.getEmailId());		
			List<Group> groupList = iGroupService.getAllGroups();
			List<Group> groupListInWhichUserIsNotMember = iGroupService.getGroupsInWhichUserIsNotMember(member, groupList);
			request.setAttribute("listTitle", "Groups List");
			request.setAttribute("groupList", groupListInWhichUserIsNotMember);
			request.getRequestDispatcher("./view/followermanagement/followers.jsp").forward(request, response);				
		} catch (MetaSocioSystemException e) {
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
