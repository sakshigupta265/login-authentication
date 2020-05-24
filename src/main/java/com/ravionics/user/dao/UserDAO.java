package com.ravionics.user.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ravionics.user.entity.Users;
@Transactional
@Repository
public class UserDAO implements IUserDAO {
	@PersistenceContext 
	private EntityManager entityManager;	
	@Override
	public Users getUserById(int userId) {
		return entityManager.find(Users.class, userId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getAllUsers() {
		String hql = "FROM Users as usr ORDER BY usr.userId";
		return (List<Users>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addUser(Users users) {
		entityManager.persist(users);
	}
	@Override
	public void updateUser(Users users) {
		Users usr = getUserById(users.getUserId());
		usr.setUserName(users.getUserName());
		usr.setUserEmail(users.getUserEmail());
		entityManager.flush();
	}
	@Override
	public void deleteUser(int userId) {
		entityManager.remove(getUserById(userId));
	}
	@Override
	public boolean userExists(String userEmail, String userPassword) {
		String hql = "FROM Users as usr WHERE usr.userEmail = ? and usr.userPassword = ?";
		int count = entityManager.createQuery(hql).setParameter(1, userEmail)
		              .setParameter(2, userPassword).getResultList().size();
		return count > 0 ? true : false;
	}
}
