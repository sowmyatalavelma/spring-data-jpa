package com.cg.homeloan.repository;

/**
 * 
 * @author VINAYA SREE
 *
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.homeloan.entities.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {

}
