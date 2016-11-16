package com.metasocio.controller.usermanagement;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metasocio.authentication.SendEmailUtil;
import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.usermanagement.GooglePojo;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.usermanagement.UserService;
import com.metasocio.validation.usermanagement.ProfileValidation;

/**
 * Servlet implementation class CreateUserProfile
 */
@WebServlet("/CreateUserProfile")
public class CreateUserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateUserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name=request.getParameter("name");
		
		
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String phnNo=request.getParameter("phoneNumber");
		String city=request.getParameter("city");
		String department=request.getParameter("department");
		String role=request.getParameter("role");
		String college=request.getParameter("college");
		String course=request.getParameter("course");
		String highSchool=request.getParameter("highSchool");
		String stream=request.getParameter("stream");
		String dobString=request.getParameter("dateOfBirth");
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM/dd/yyyy");
		Date dob = null;
		if(dobString!=""){
			try {
				dob = simpleDateFormat.parse(dobString);
			}
			catch (ParseException e) {

				/*request.setAttribute("message", "Cannot create or update profile. Please try after some time.");
				request.getRequestDispatcher("./view/exception/error.jsp").forward(request, response);;*/
			}
		}
		String gender=request.getParameter("gender");
		String about=request.getParameter("about");
		String nickName=request.getParameter("nickName");
		String relationshipStatus=request.getParameter("relationship");
		String image=request.getParameter("picture");
		User user=new User();
		user.setName(name);
		user.setEmailId(email);
		user.setAddress(address);
		user.setPhoneNo(phnNo);
		user.setCity(city);
		user.setDepartment(department);
		user.setRole(role);
		user.setCollege(college);
		user.setCourse(course);
		user.setHighSchool(highSchool);
		user.setStream(stream);
		user.setDateOfBirth(dob);
		user.setGender(gender);
		user.setAbout(about);
		user.setNickName(nickName);
		user.setRelationshipStatus(relationshipStatus);
		user.setImageURL(image);
		UserService iUserService=new UserService();
		
		GooglePojo userDataObject=new GooglePojo();
		userDataObject.setName(name);
		userDataObject.setEmail(email);
		userDataObject.setPicture(image);
		Date date=new Date();
		
		HttpSession session=request.getSession(false);
		
	//	session.setAttribute("userDataObject",user) ;
	    request.setAttribute("editUserDataObject", user);
		String regex="[0-9]+";
		try {
			
			ProfileValidation iProfileValidation=new ProfileValidation();
			String errorMessageForPersonalInfo= iProfileValidation.validateUserPersonalInfo(user);
			String errorMessageForWorkAndEducationInfo=iProfileValidation.validateUserWorkAndEducationInfo(user);
			if(errorMessageForPersonalInfo!=""){
			request.setAttribute("messagePersonalInfo",errorMessageForPersonalInfo);
			request.getRequestDispatcher("./view/usermanagement/profile.jsp").forward(request, response);
			}
			else if(errorMessageForWorkAndEducationInfo!=""){
				request.setAttribute("messageWorkAndEducation",errorMessageForWorkAndEducationInfo);
				request.getRequestDispatcher("./view/usermanagement/profile.jsp").forward(request, response);
			}
			else{
				
				User userProfile=iUserService.getUserByEmail(email);
				
				if(userProfile==null){
					user.setCreatedAt(date);
					iUserService.setUserInfo(user);
					User newUser=iUserService.getUserByEmail(email);
					session.setAttribute("userObject",newUser);
					SendEmailUtil sendEmail = new SendEmailUtil();
				 	String emailSubject = newUser.getName()+" welcome to the Metacube network on Meta-Socio";
				 	
				 	String emailBody = "Welcome to Meta-Socio, "+newUser.getName()+" !"
				 			+ "You're now a part of Meta-Socio's private, "
				 			+ "social collaboration network. Meta-Socio makes it easy to work together in teams "
				 			+ "and stay up to date on what others are working on.";
				 	sendEmail.sendEmail(newUser.getEmailId(),emailSubject, emailBody);
				}
				
				else{
					
					userProfile.setName(name);
					userProfile.setEmailId(email);
					userProfile.setAddress(address);
					userProfile.setPhoneNo(phnNo);
					userProfile.setCity(city);
					userProfile.setDepartment(department);
					userProfile.setRole(role);
					userProfile.setCollege(college);
					userProfile.setCourse(course);
					userProfile.setHighSchool(highSchool);
					userProfile.setStream(stream);
					userProfile.setDateOfBirth(dob);
					userProfile.setGender(gender);
					userProfile.setAbout(about);
					userProfile.setNickName(nickName);
					userProfile.setRelationshipStatus(relationshipStatus);
					userProfile.setImageURL(image);
					iUserService.updateUserInfo(userProfile);
					User newUser=iUserService.getUserByEmail(email);
					session.setAttribute("userObject",newUser);
				}
			response.sendRedirect("HomePage");
			}
		} catch (MetaSocioSystemException e) {
			request.setAttribute("message", "Can not create or update profile. Please try after some time.");
			request.getRequestDispatcher("./view/exception/error.jsp").forward(request, response);
		}
	}

}
