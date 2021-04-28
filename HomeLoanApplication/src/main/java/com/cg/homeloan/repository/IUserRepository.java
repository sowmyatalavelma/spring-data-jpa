package com.cg.homeloan.repository;

/**
 * 
 * @author VINAYA SREE
 *
 */

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.homeloan.entities.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
