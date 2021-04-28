package com.cg.homeloan.service;
/**
 * 
 * @author VINAYA SREE
 *
 */

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.homeloan.entities.Customer;
import com.cg.homeloan.exception.CustomerNotFoundException;
import com.cg.homeloan.repository.ICustomerRepository;

@Service
@Transactional

public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerRepository cDao;
	
	@Override
	public Customer addCustomer(Customer customer) {
		
		return cDao.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer){
		
		Optional<Customer> custData=this.cDao.findById(customer.getUserId());
		if(custData.isPresent()) {
			Customer cust=custData.get();
			cust.setMobileNumber(customer.getMobileNumber());
			cust.setEmailId(customer.getEmailId());
			
			return cDao.save(cust);
		}
		else
		{
			throw new CustomerNotFoundException("Customer record not found with id"+customer.getUserId());
		}
	}

	@Override
	public Customer deleteCustomer(Customer customer) {
		Optional<Customer> custData=this.cDao.findById(customer.getUserId());
		
		if(custData.isPresent()) {
			Customer cust=custData.get();
			cDao.delete(cust);
			return cust;
		}
		else
			throw new CustomerNotFoundException("Customer Not found for id"+customer.getUserId());

	}

	@Override
	public Customer viewCustomer(String custid)  {
		Optional<Customer> opt= this.cDao.findById(custid);
		if(opt.isPresent())
			return opt.get();
		else 
			throw new CustomerNotFoundException("Customer Not found for id"+custid);
		
	}

	@Override
	public List<Customer> viewAllCustomers() {
		
		return cDao.findAll();
	}

	

}
