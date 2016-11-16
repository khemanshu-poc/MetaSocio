package com.metasocio.facade.followermanagement;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Session;

import com.metasocio.dbhelper.followermanagement.FollowerDao;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.facade.usermanagement.UserFacade;
import com.metasocio.model.usermanagement.User;

public class FollowerFacade {

	public void addFollowing(User follower, Session session) throws MetaSocioException {
		//CRUD iCrud = CRUD.getInstance();
		/*FriendDao iFriendDao=FriendDao.getInstance();*/
		FollowerDao iFollowerDao=new FollowerDao();
		iFollowerDao.addFollowing(follower, session);	
	}

	public List<User> getFollowers(User user, Session session) throws MetaSocioException {
		UserFacade iUserFacade=new UserFacade();
	FollowerDao iFollowerDao=FollowerDao.getInstance();
	List<User> otherUsersList=iUserFacade.getAllUsers(session);
	List<User> followersList=iFollowerDao.getFollowers(user,otherUsersList,session);
		return followersList;
	}

	public List<User> getUsersWhomYouAreNotFollowing(int userId,
			List<User> usersList, Session session) throws MetaSocioException {
		//CRUD iCrud = CRUD.getInstance();
				FollowerDao ifFollowerDao=FollowerDao.getInstance();
				List<User> usersWhomYouAreNotFollowing=ifFollowerDao.getUsersWhomYouAreNotFollowing(userId, usersList, session);
				
			return usersWhomYouAreNotFollowing;
	}

	public List<User> getFollowings(int followerId, Session session) throws MetaSocioException {
		//CRUD iCrud = CRUD.getInstance();
		FollowerDao iFollowerDao=new FollowerDao();
		List<User> followingList = iFollowerDao.getFollowings(followerId, session);
		
	return followingList;
	}

	public boolean removeFriend(int followerId, int followingId, Session session) throws MetaSocioException {
		//CRUD iCrud = CRUD.getInstance();
		FollowerDao iFollowerDao=FollowerDao.getInstance();
		return iFollowerDao.removeFriend(followerId, followingId, session);		
	}
	
	

}
