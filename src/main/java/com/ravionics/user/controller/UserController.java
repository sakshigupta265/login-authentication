package com.ravionics.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ravionics.user.entity.UserEntity;
import com.ravionics.user.entity.Users;
import com.ravionics.user.service.IUserService;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private IUserService userService;

	@GetMapping("user/{id}")
	public ResponseEntity<Users> getUserById(@PathVariable("id") Integer id) {
		Users User = userService.getUserById(id);
		return new ResponseEntity<Users>(User, HttpStatus.OK);
	}

	@GetMapping("getAllUsers")
	public ResponseEntity<List<Users>> getAllUsers() {
		List<Users> list = userService.getAllUsers();
		return new ResponseEntity<List<Users>>(list, HttpStatus.OK);
	}

	@PostMapping("addUser")
	public ResponseEntity<Void> addUser(@RequestBody Users user, UriComponentsBuilder builder) {
		boolean flag = userService.addUser(user);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/User/{id}").buildAndExpand(user.getUserId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("updateUser")
	public ResponseEntity<Users> updateUser(@RequestBody Users user) {
		userService.updateUser(user);
		return new ResponseEntity<Users>(user, HttpStatus.OK);
	}

	@DeleteMapping("deleteUser/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
		userService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("validateUser")
	public ResponseEntity<Boolean> validateUser(@RequestBody UserEntity userEntity) {
		boolean validateStatus = userService.validateUser(userEntity.getUserEmail(), userEntity.getUserPassword());
		if (validateStatus)
			return new ResponseEntity<Boolean>(validateStatus, HttpStatus.OK);
		else
			return new ResponseEntity<Boolean>(validateStatus, HttpStatus.UNAUTHORIZED);

	}

}
