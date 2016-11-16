package com.metasocio.model.friendsmanagement;
import java.sql.Timestamp;
import java.util.Date;
import lombok.Data;
@Data
public class Friend{
	private	int id;
	private	int friendOne ;
	private	int friendTwo;
	private	Date createdAt;
	private	Timestamp updatedAt;
	private	String createdBy;
	private	String updatedBy;
	private	int isdelete;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFriendOne() {
		return friendOne;
	}
	public void setFriendOne(int friendOne) {
		this.friendOne = friendOne;
	}
	public int getFriendTwo() {
		return friendTwo;
	}
	public void setFriendTwo(int friendTwo) {
		this.friendTwo = friendTwo;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
}
