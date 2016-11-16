package com.metasocio.model.groupmanagement;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.metasocio.model.usermanagement.User;

public class Group implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	int groupId;
	String groupName;
	String imageUrl;
	Date createdAt;
	Timestamp updatedAt;
	String createdBy;
	String updatedBy;
	int isdelete;  
	User user;
	Set<User> usersSet = new HashSet<User>();

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the usersSet
	 */
	public Set<User> getUsersSet() {
		return usersSet;
	}

	/**
	 * @param usersSet the usersSet to set
	 */
	public void setUsersSet(Set<User> usersSet) {
		this.usersSet = usersSet;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	Set<User> users = new HashSet<User>(0);
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public Set<User> getUsers() {
		return users;
	}

	
	public void setUsers(Set<User> users) {
		this.users = users;
	}


	public int getGroupId() {
		return groupId;
	}

	/**
	 * @param id the id to set
	 */
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the isdelete
	 */
	public int getIsdelete() {
		return isdelete;
	}

	/**
	 * @param isdelete the isdelete to set
	 */
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", groupName=" + groupName
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", isdelete=" + isdelete + "]";
	}
}
