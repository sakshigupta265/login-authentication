package com.ravionics.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravionics.user.dao.IUserDAO;
import com.ravionics.user.entity.Users;
@Service
public class UserService implements IUserService {
	@Autowired
	private IUserDAO userDAO;
	@Override
	public Users getUserById(int UsersId) {
		Users obj = userDAO.getUserById(UsersId);
		return obj;
	}	
	@Override
	public List<Users> getAllUsers(){
		return userDAO.getAllUsers();
	}
	@Override
	public synchronized boolean addUser(Users users){
       if (userDAO.userExists(users.getUserEmail(),users.getUserPassword())) {
    	   return false;
       } else {
    	   userDAO.addUser(users);
    	   return true;
       }
	}
	@Override
	public void updateUser(Users users) {
		userDAO.updateUser(users);
	}
	@Override
	public void deleteUser(int UsersId) {
		userDAO.deleteUser(UsersId);
	}
	@Override
	public boolean validateUser(String userEmailId,String password) {
		return userDAO.userExists(userEmailId, password);
		
	}
}
