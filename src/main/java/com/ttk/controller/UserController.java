package com.ttk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ttk.entity.User;
import com.ttk.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	UserService uservice;
	
	@PostMapping("/User/addUser")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user)
	{
		return new ResponseEntity<User>(uservice.addUser(user),HttpStatus.CREATED);

	}
	//@PathVariable : bind to URI template variable
	//http://localhost:8080/Teacher/get(1)
	@GetMapping("/User/get/{uid}")
	public ResponseEntity<User> getUser(@PathVariable ("uid") int uid)
	{
		return new ResponseEntity<User>(uservice.getUserDetail(uid),HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/User/remove/{uid}")
	public ResponseEntity<String> deleteUser(@PathVariable ("uid") int uid)
	{
		uservice.deleteUserDetail(uid);
		return new ResponseEntity<String>("Deleted Sucessfully", HttpStatus.OK);
	}

	//update
	//@RequestBody : Student object call to JSON file
	@PutMapping("/User/update/{uid}")
	public ResponseEntity<String> updateUser(@RequestBody User user,@PathVariable("uid") int uid) {
	uservice.updateUserDetail(user,uid); // Delegate to service layer
	return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);

	}
}
