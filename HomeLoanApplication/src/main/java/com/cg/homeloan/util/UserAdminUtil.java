package com.cg.homeloan.util;

/**
 * 
 * @author VINAYA SREE
 *
 */

import org.springframework.stereotype.Component;

import com.cg.homeloan.dto.AdminDetails;
import com.cg.homeloan.dto.UserDetails;
import com.cg.homeloan.entities.Admin;
import com.cg.homeloan.entities.User;

@Component
public class UserAdminUtil {
	public UserDetails toDetails(User user) {
		Admin admin = user.getAdmin();
		AdminDetails adminDetails = new AdminDetails(admin);
		UserDetails ud = new UserDetails(user.getUserId(), user.getPassword(), user.getRole(), adminDetails);
		return ud;

	}
}
