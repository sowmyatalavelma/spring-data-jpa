package com.cg.homeloan.service;

/**
 * 
 * @author VINAYA SREE
 *
 */

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.homeloan.entities.User;
import com.cg.homeloan.exception.CustomerNotFoundException;
import com.cg.homeloan.exception.UserNotFoundException;
import com.cg.homeloan.repository.IUserRepository;

@Service
public class UserImpl implements IUserService {

	@Autowired
	private IUserRepository uDao;

	@Override
	public User addNewUser(User user) {
		User uObj = uDao.save(user);

		return uObj;
	}

	@Override
	public User signIn(User user) {
		Optional<User> opt = uDao.findById(user.getUserId());
		if (!opt.isPresent())
			throw new CustomerNotFoundException("User not found by id " + user.getUserId());

		return opt.get();
	}

	@Override
	public User signOut(User user) {
		Optional<User>opt=uDao.findById(user.getUserId());
		if(!opt.isPresent())
			throw new UserNotFoundException("User not found for id "+user.getUserId());
		return opt.get();
	}

}
