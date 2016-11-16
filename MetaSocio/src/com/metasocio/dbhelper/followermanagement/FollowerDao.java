package com.metasocio.dbhelper.followermanagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.model.usermanagement.User;

public class FollowerDao {
	
	private static FollowerDao iFollowerDao;
	public static FollowerDao getInstance() {
		//Checking if instance already exists
		/*if (iFollowerDao == null) {*/
			iFollowerDao = new FollowerDao(); 		//Creating instance of this class
		/*}*/
		return iFollowerDao;		//Returning instance of this class
	}
	public void addFollowing(User follower, Session session) throws MetaSocioException {
		session.saveOrUpdate(follower);
	}
	
	public List<User> getFollowers(User user, List<User> otherUsersList,
			Session session)  throws MetaSocioException{
		List<User> followersList = new ArrayList<User>();
		for(User otherUser : otherUsersList){						
		 Set<User> otherUserFollowingSet = otherUser.getUsers();
		 Iterator<User> iterator = otherUserFollowingSet.iterator();
		 while(iterator.hasNext()){
			 User folowingUser = iterator.next();
			 if(folowingUser.getUserId()==user.getUserId()){
				 followersList.add(otherUser);
			 	}
		 	}
		 }
		 System.out.println(followersList);
		return followersList;
	}
	
	
	public List<User> getUsersWhomYouAreNotFollowing(int userId, List<User> usersList,
			Session session) throws MetaSocioException {
		System.out.println("hi-------------------------");
			// Criteria criteria = session.createCriteria(Friends.class);
			List<User> followingList = new ArrayList<User>();
			Query query;
			String hql = "from User u where u.userId =:userId";
			query = session.createQuery(hql);
			query.setInteger("userId", userId);
			
			User follower =  (User) query.uniqueResult();
			System.out.println(follower+"-------------------------------------------------------------");
		Set<User> userSet =new LinkedHashSet<User>(); 
		
		userSet = follower.getUsers();
		
		
		Set<Integer> userIdSet = new LinkedHashSet<Integer>();
			if (userSet.isEmpty()) {
				System.out.println("No friends");	
				followingList = usersList;
			} else {	
				 Iterator<User> iterator = userSet.iterator(); 
			      
				   // check values
				   while (iterator.hasNext()){
					   User user=new User();
					   user=(User) iterator.next();
					   userIdSet.add(user.getUserId());
				   //System.out.println("Value: "+iterator.next() + " ");  
				   }
				   
				   
			for (User user : usersList) {
				//System.out.println("id from crud" + user.getUserId());
				if(!userIdSet.contains(user.getUserId())){
					System.out.println("usarId not friend-----------------"+user.getName() +"  "+user.getUserId());
				followingList.add(user);
				System.out.println(followingList);
				}
			}
			}
			return followingList;
			
			
			
				
			
				 
			
			
			
			
			

	}
	public List<User> getFollowings(int followerId, Session session)  throws MetaSocioException {
		List<User> followingsList = new ArrayList<User>();
		//List<Set<User>> userSetList = new ArrayList<Set<User>>();
		Query query;
		String hql = "from User where userId=" + followerId;
		query = session.createQuery(hql);
		User actualUser = (User) query.uniqueResult();
	//Set<User> userSet =new LinkedHashSet<User>(); 
	
		List<User> followingList =  new ArrayList<User>();					
		 Set<User> followingSet = actualUser.getUsers();
		 Iterator<User> iterator = followingSet.iterator();
		 while(iterator.hasNext()){
			
			 User following = iterator.next();
			followingList.add(following);
		 }
		 if(followingList.size()>0)
			{
				System.out.println("in friend dao not null");
			}
			else{
				System.out.println("in friend dao null");}
		 System.out.println("Hii");
		 for(User user : followingList){
			 System.out.println(user.getName());
		 }
		 
		return followingList;
	}
	public boolean removeFriend(int followerId, int followingId, Session session)throws MetaSocioException {
		String hql1 = "from User where userId="+followerId;
		Query query1 = session.createQuery(hql1);
		User follower = (User) query1.uniqueResult();
		String hql2 = "from User where userId="+followingId;
		Query query2 = session.createQuery(hql2);
		User following = (User) query2.uniqueResult();
		follower.getUsers().remove(following);
		try{
		session.saveOrUpdate(follower);
		return true;
		}
		catch(Exception e){
		return false;
		}
	}
	}


