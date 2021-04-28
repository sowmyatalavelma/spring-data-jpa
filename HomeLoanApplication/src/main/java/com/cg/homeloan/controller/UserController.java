package com.cg.homeloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.homeloan.dto.AdminDetails;
import com.cg.homeloan.dto.CreateUser;
import com.cg.homeloan.dto.CreateUserAdminRequest;
import com.cg.homeloan.dto.UserDetails;
import com.cg.homeloan.entities.Admin;
import com.cg.homeloan.entities.User;
import com.cg.homeloan.exception.UserNotFoundException;
import com.cg.homeloan.service.IUserService;
import com.cg.homeloan.util.UserAdminUtil;
import com.cg.homeloan.util.UserUtil;
/**
 * 
 * @author VINAYA SREE
 *
 */

@RestController
@RequestMapping("/user")

public class UserController {

	@Autowired
	private IUserService service;

	@Autowired
	private UserUtil userUtil;
	@Autowired
	private UserAdminUtil useradminUtil;

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public UserDetails addNewUser(@RequestBody CreateUser reqData) {
		User user = new User(reqData.getUserId(), reqData.getPassword(), reqData.getRole());

		User us = service.addNewUser(user);
		UserDetails details = userUtil.toDetails(us);

		return details;
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/addAdmin")
	public UserDetails addAdmin(@RequestBody CreateUserAdminRequest reqData) {
		System.out.println("printing " + reqData);
		User user = new User(reqData.getUserId(), reqData.getPassword(), reqData.getRole());
		AdminDetails admindetails = reqData.getAdmindetails();
		Admin admin = new Admin(admindetails);
		admin.setUser(user);
		user.setAdmin(admin);
		User userreturn = service.addNewUser(user);
		System.out.println("printing " + userreturn);
		return useradminUtil.toDetails(userreturn);
	}

	@ResponseStatus(code=HttpStatus.OK)
	@GetMapping("/signIn")
	public User signIn(@RequestBody User user) {

		User us = service.signIn(user);
		if (!user.getPassword().equals(us.getPassword()))
			throw new UserNotFoundException("Wrong password entered!!");
		return us;

	}
	@ResponseStatus(code=HttpStatus.OK)
	@GetMapping("/signout")
	public User signOut(@RequestBody User user)
	{
		System.out.println("Request Data : "+user);
		User userS=service.signOut(user);
		return userS;
	}

}