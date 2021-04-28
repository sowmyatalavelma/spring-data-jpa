package com.cg.homeloan.util;

/**
 * 
 * @author VINAYA SREE
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.homeloan.dto.CustomerDetails;
import com.cg.homeloan.dto.UserDetails;
import com.cg.homeloan.entities.Customer;
import com.cg.homeloan.entities.User;

@Component
public class CustomerUtil {
	public CustomerDetails toDetails(Customer cust) {
		User user = cust.getUser();
		UserDetails ud = new UserDetails(user);
		CustomerDetails custDetails = new CustomerDetails(cust.getUserId(), cust.getCustomerName(),
				cust.getMobileNumber(), cust.getEmailId(), cust.getDateOfBirth(), cust.getGender(),
				cust.getNationality(), cust.getAadharNumber(), cust.getPanNumber(), ud);
		return custDetails;

	}

	public List<CustomerDetails> toDetails(List<Customer> list) {
		List<CustomerDetails> customerDetailsList = new ArrayList<>();
		for (Customer customer : list) {
			customerDetailsList.add(toDetails(customer));
		}
		return customerDetailsList;
	}
}
