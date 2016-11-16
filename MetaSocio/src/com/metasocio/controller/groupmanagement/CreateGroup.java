package com.metasocio.controller.groupmanagement;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

/**********************************************************************************
 * Create group servlet : creating new group based on information provided by user
 * Servlet implementation class AddFriend
 *********************************************************************************/
@WebServlet("/CreateGroup")
public class CreateGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateGroup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/*********************************************************************************
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *********************************************************************************/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);		
		User adminUser = (User) session.getAttribute("userObject");		//Getting user from session attribute
				
		String groupTitle = (String) request.getParameter("groupName");		//Getting group title of new group
		GroupService iGroupService = new GroupService();	

		try {		
			UserService iUserService = new UserService();
			User admin = iUserService.getUserByEmail(adminUser.getEmailId());		//Getting user(admin) by email id
					
				Group group = new Group();			//creating group instance
				
				//Setting group info
				group.setGroupName(groupTitle);
				group.setImageUrl("https://lh3.googleusercontent.com/-YEhsrIXvM4E/AAAAAAAAAAI/AAAAAAAAAAA/_jwNL51OrZg/photo.jpg");
				Date date= new java.util.Date();
				group.setUser(admin);
				group.setCreatedAt(date);						
				Set<User> groupMembersSet = new HashSet<User>();
				groupMembersSet.add(admin);
				group.setUsersSet(groupMembersSet);			
				int groupId = iGroupService.createGroup(group);		//Creating new group				
				Group myGroup = iGroupService.getGroupById(groupId);	//getting group info by group id					
				session.setAttribute("groupObject", myGroup);		//setting attribute (group) in session				
				response.sendRedirect("GroupPage?groupId="+groupId);		//redirecting to group page					
			
		} catch (MetaSocioSystemException e) {		
			request.setAttribute("message","Sorry Can't create group, Please try after some time......");
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
