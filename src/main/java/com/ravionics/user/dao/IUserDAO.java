package com.ravionics.user.dao;

import java.util.List;

import com.ravionics.user.entity.Users;

public interface IUserDAO {
    List<Users> getAllUsers();
    Users getUserById(int UserId);
    void addUser(Users users);
    void updateUser(Users users);
    void deleteUser(int UserId);
    boolean userExists(String UserEmail, String Password);
}
