package com.cg.homeloan.util;

/**
 * 
 * @author VINAYA SREE
 *
 */

import org.springframework.stereotype.Component;

import com.cg.homeloan.dto.UserDetails;
import com.cg.homeloan.entities.User;

@Component
public class UserUtil {
	public UserDetails toDetails(User user) {

		UserDetails ud = new UserDetails(user.getUserId(), user.getPassword(), user.getRole());
		return ud;

	}
}
