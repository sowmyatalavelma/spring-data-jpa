package com.cg.homeloan.service;

import java.util.List;

import com.cg.homeloan.entities.Customer;


public interface ICustomerService  {
	public Customer addCustomer(Customer customer) ;
	public Customer updateCustomer(Customer customer) ;
	public Customer deleteCustomer(Customer customer);
	public Customer viewCustomer(String id) ;
	public List<Customer> viewAllCustomers();
	
	


}
