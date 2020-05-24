package com.ravionics.user.service;

import java.util.List;

import com.ravionics.user.entity.Users;

public interface IUserService {
    List<Users> getAllUsers();
    Users getUserById(int UsersId);
    boolean addUser(Users Users);
    void updateUser(Users Users);
    void deleteUser(int UsersId);
    boolean validateUser(String userEmailId,String password);
}
