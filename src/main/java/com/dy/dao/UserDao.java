package com.dy.dao;

import com.dy.entity.User;

public interface UserDao {

	public void insertUser (User user);
	
	public void updateUser (User user);
	
	public void deleteUser (User user);
	
	public User findUserById (int userId);
	
}
