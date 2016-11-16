package com.metasocio.dbhelper.usermanagement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.model.usermanagement.User;
public class UserDao {
	private static UserDao iUserDao;
	public UserDao() {
	}
	public static UserDao getInstance() {
			iUserDao = new UserDao();
		return iUserDao;
	}
	public boolean setUserInfo(User user, Session session)
			throws MetaSocioException {
		try{
			session.save(user);
			return true;
		}
		catch (Exception e){
			return false;
		}
	}
	@SuppressWarnings("unchecked")
	public List<User> getUsersHavingSameDepartment(String department,
			 Session session) throws MetaSocioException {
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("department", department));
		List<User> usersList = new ArrayList<User>();
		usersList = criteria.list();
		return usersList;
	}
	public User getUserByEmail(String email, Session session)throws MetaSocioException {
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("emailId", email));
	
	User user = (User) criteria.uniqueResult();
		return user;
	}
	public User getUserById(int followingId, Session session) throws MetaSocioException {
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userId", followingId));
		User user = new User();
		user = (User) criteria.uniqueResult();
		return user;
	}
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(Session session) throws MetaSocioException {
		List<User> usersList = new ArrayList<User>();
		usersList = session.createQuery("FROM User").list(); 
		return usersList;
	}
	public void updateUserInfo(User user, Session session) throws MetaSocioException {
		session.update(user);
		
	}
}
