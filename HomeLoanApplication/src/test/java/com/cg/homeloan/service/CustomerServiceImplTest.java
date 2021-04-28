package com.cg.homeloan.service;


import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.homeloan.entities.Customer;
import com.cg.homeloan.entities.User;
import com.cg.homeloan.service.CustomerServiceImpl;
import com.cg.homeloan.service.ICustomerService;

/**
 * 
 * @author SOWMYA
 * @author VINAYA SREE
 *
 */

@ExtendWith({ SpringExtension.class })
@DataJpaTest
@Import(CustomerServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class CustomerServiceImplTest {
	
	@Autowired
	private ICustomerService service;
	
	@Test
	public void testAddCustomer() {
		Customer cust=service.addCustomer(new Customer("123", "sowmya", "7093106623", "sowmya@22", LocalDate.parse("1999-08-22"), "female", "Indian", "845621349087", "ALWPG5809L",new User(123, "sow123", "Customer")));
		Customer exCustomer = service.addCustomer(cust);
		Assertions.assertEquals(exCustomer.getCustomerName(), cust.getCustomerName());
	}

	
	@Test
	public void testUpdateCustomer() {
		
		Customer cust=service.addCustomer(new Customer("123", "sowmya", "7093106623", "sowmya@22", LocalDate.parse("1999-08-22"), "female", "Indian", "845621349087", "ALWPG5809L",new User(123, "sow123", "Customer")));
		cust.setMobileNumber("7093106623");
		cust.setEmailId("sowmya@123");
		Customer exCustomer = service.updateCustomer(cust);
		Assertions.assertEquals(exCustomer.getMobileNumber(),cust.getMobileNumber());
	}
	
	@Test
	public void testDeleteCustomer() {
		Customer cust=service.addCustomer(new Customer("123", "sowmya", "7093106623", "sowmya@22", LocalDate.parse("1999-08-22"), "female", "Indian", "845621349087", "ALWPG5809L",new User(123, "sow123", "Customer")));
		Customer exCustomer = service.deleteCustomer(cust);
		Assertions.assertEquals(exCustomer.getUserId(), cust.getUserId());
		
	}
	
	@Test
	public void testViewAllCustomer() {
		String localDate="2021-08-12";
		Customer cust1 = service.addCustomer(new Customer("123", "sowmya", "7093106623", "sowmya@22", LocalDate.parse("1999-08-22"), "female", "Indian", "845621349087", "ALWPG5809L",new User(123, "sow123", "Customer")));
		Customer cust2 = service.addCustomer(new Customer("124", "sumaja", "8978298812", "sumaja@123", LocalDate.parse("2020-08-21"), "female", "Indian", "845612345689", "PLMPG3809P",new User(124, "su123", "Customer")));
		Customer cust3 = service.addCustomer(new Customer("125", "vinaya", "9877123226", "vinaya@23", LocalDate.parse("1999-02-18"), "female", "Indian", "890765431234", "AMWPG5789W",new User(125, "vin123", "Customer")));
		
		Customer cust4 = new Customer("123", "sow", null, null, LocalDate.parse(localDate), "female", "Indian", "876543287", "asdfgh365");
		List<Customer> cList=service.viewAllCustomers();
		Assertions.assertTrue(cList.contains(cust3));
		
	}
}
