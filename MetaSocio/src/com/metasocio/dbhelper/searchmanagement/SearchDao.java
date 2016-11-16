package com.metasocio.dbhelper.searchmanagement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.metasocio.exception.MetaSocioException;
import com.metasocio.model.usermanagement.User;
/***********************************************************************
 * @author Since : 23 November, 2015
 *  Description : This class is directly
 *  fetching the data from database related to text typed in search box.
 ***********************************************************************/
public class SearchDao {
	private static SearchDao iSearchDao;// Declaring static instance of class
	/************************************
	 * Creating private constructor
	 ***********************************/
	public SearchDao() {
	}
	/****************************************************************
	 * This function is to create single instance of this class, 
	 * if the instance already exists return the previous one
	 * and if instance is null create a new instance.
	 * 
	 * @return : Returning instance of this class
	 ************************************************************/
	public static SearchDao getInstance() {
		iSearchDao = new SearchDao();//Creating instance of this class
		return iSearchDao;//Returning instance of this class
	}
	/******************************************************************
	 * This method contains query that is fetching data of User from 
	 * database of related search.
	 * @param transaction
	 * @param session
	 * @param search
	 * @param email 
	 * @return User List of related search
	 * @throws MetaSocioException
	 *****************************************************************/
	public List<User> retrieveUsersByKey(
			Session session, String search, String email) throws MetaSocioException {
		Query query = session.createQuery("FROM User WHERE name like'" + search
				+ "%' ORDER BY name");//Array List of User type 
		List<User> searchResult = new ArrayList<User>();
		//query.setParameter("email",email);
		
		searchResult = query.list();//Searched Users in list named searchResult
		
		for(int i=0;i<searchResult.size();i++){
			if(searchResult.get(i).getEmailId().equalsIgnoreCase(email)){
				searchResult.remove(i);
			}
		}
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+searchResult);
		return searchResult;
	}
}
