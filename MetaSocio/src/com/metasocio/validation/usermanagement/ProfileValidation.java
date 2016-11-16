/**
 * 
 */
package com.metasocio.validation.usermanagement;

import com.metasocio.authentication.SendEmailUtil;
import com.metasocio.model.usermanagement.User;

/******************************************************************************
 * @author : 
 * Since: 28 November,2015
 * Description: SendEmailUtil class is to send success message of signing up 
 * on Meta-Socio  on email-id

 ******************************************************************************/
public class ProfileValidation {
	
	public String validateUserPersonalInfo(User user) {
		
		String messagePersonalInfo="";
		String regex="[0-9]+";
		if(user.getName().trim()=="" ||user.getName().trim()==null || user.getName().trim().isEmpty()){
			messagePersonalInfo="Please enter your name";
				}
		else if(user.getEmailId().trim()=="" ||user.getEmailId().trim()==null ||  user.getEmailId().trim().isEmpty() ){
			 messagePersonalInfo="Please enter email Id";
		}
		else if(!user.getEmailId().endsWith("@gmail.com")){
			messagePersonalInfo="Invalid email";
		
		}
		else if(user.getPhoneNo()!="" ){
			if(user.getPhoneNo().length()!=10){
		 messagePersonalInfo="Phone no. length should not be greater than 10";
			}
			else if(!user.getPhoneNo().matches(regex)){
				messagePersonalInfo="Invalid Phone no";
			}
			else{
				messagePersonalInfo="";
			}
		}
		else{
			messagePersonalInfo="";
		}	
	
		return messagePersonalInfo;
	}

	public String validateUserWorkAndEducationInfo(User user) {
		String messageWorkAndEducation="";
		 if(user.getDepartment().trim()=="" ||user.getDepartment().trim()==null || user.getDepartment().trim().isEmpty()){
			messageWorkAndEducation="Please specify your department";
		}
		else if(user.getRole().trim()==""|| user.getRole().trim()==null ||user.getRole().trim().isEmpty()){
			messageWorkAndEducation="Please specify your role in meta-socio";
		}
		else{
			messageWorkAndEducation="";
		}
		 return messageWorkAndEducation;
	}}