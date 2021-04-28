package com.cg.homeloan.repository;

/**
 * 
 * @author VINAYA SREE
 *
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.homeloan.entities.LandVerificationOfficer;

@Repository
public interface ILandVerificationRepository extends JpaRepository<LandVerificationOfficer, Integer> {

}
