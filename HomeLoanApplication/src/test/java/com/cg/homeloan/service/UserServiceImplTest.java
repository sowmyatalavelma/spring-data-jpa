package com.cg.homeloan.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.homeloan.entities.Admin;
import com.cg.homeloan.entities.Customer;
import com.cg.homeloan.entities.User;

/**
 * 
 * @author SOWMYA
 * @author VINAYA SREE
 *
 */

@ExtendWith({ SpringExtension.class })
@DataJpaTest
@Import(UserImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class UserServiceImplTest {

	@Autowired
	private IUserService uService;

	@Test
	public void TestAddNewUser() {
		User us = new User(123, "soww", "Customer");
		User exUser = uService.addNewUser(us);
		Assertions.assertEquals(exUser.getUserId(), us.getUserId());
		
		//Testing User who is an Admin
		
		User us1 = new User(122, "swee", "Admin", new Admin("surendhar", "897654676778"));
		User exUser1 = uService.addNewUser(us1);
		us1.getAdmin().setUserId(exUser1.getAdmin().getUserId());
		Assertions.assertEquals(exUser1.getAdmin().getUserId(), us1.getAdmin().getUserId());
		
	}


	@Test
	public void TestSignIn() {
		User user = new User(123, "soww", "Customer");

		User userAdded = uService.signIn(user);
		Assertions.assertEquals(userAdded.getUserId(), user.getUserId());

	}

	@Test
	public void testSignOut() {
		User user = new User(123, "soww", "Customer");

		User userSignOut = uService.signOut(user);
		Assertions.assertEquals(userSignOut.getUserId(), user.getUserId());
	}
}
