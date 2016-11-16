package com.metasocio.controller.searchmanagement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import com.google.gson.Gson;
import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.searchmanagement.SearchService;

/*********************************************************************************
 * @author Since : 02 December, 2015 
 * Description : Servlet implementation class SearchByName extending HttpServlet,
 *  Managing search by name
 **********************************************************************************/

@WebServlet("/searchByName")
public class searchByName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public searchByName() {
		super();
		// TODO Auto-generated constructor stub
	}

	/********************************************************************************
	 * This method gets User list of search result from database and convert that
	 *  list into JSON Array then send this array to java script file.

	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *****************************************************************************/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String keyToSearch = request.getParameter("search");
		System.out.println("Its controller of search-------------------------"+keyToSearch);
		HttpSession session=request.getSession(false);
		User user=(User) session.getAttribute("userObject");
		
		String email=user.getEmailId();
		//get parameter from search text box 
		if (!((keyToSearch.trim()).equals(""))) {
			List<User> resultantUsers = new ArrayList<User>();//Array list of Users declaration 
			SearchService iSearchService = new SearchService();//Creating object of SearchService
			
				//Retrieving search result by calling method retrieveSearchResult existing in SearchService class
				resultantUsers = iSearchService.retrieveUsersByKey(keyToSearch,email);
				System.out.println("Its controller of search resultantUsers-------------------------"+resultantUsers);
				
				List<User> resultantUsersDetails = new ArrayList<User>();//Array list of Users declaration 
				for(int i=0;i<resultantUsers.size();i++){
					User u=new User();
					u.setName(resultantUsers.get(i).getName());
					u.setImageURL(resultantUsers.get(i).getImageURL());
					u.setUserId(resultantUsers.get(i).getUserId());
					resultantUsersDetails.add(u);
				}
				
			//converting list of Users into JSONArray
			JSONArray searchResultJsonObject=JSONArray.fromObject(resultantUsersDetails);
			System.out.println("Its controller of search resultantUsers searchResultJsonObject-------------------------"+searchResultJsonObject);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(new Gson().toJson(searchResultJsonObject));
		} else{
			response.getWriter().write("");
		}
		
		} catch (MetaSocioSystemException e) {
			request.setAttribute("message", "Cant search this person. Please try after some time.");
			request.getRequestDispatcher("./view/exception/error.jsp");
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
