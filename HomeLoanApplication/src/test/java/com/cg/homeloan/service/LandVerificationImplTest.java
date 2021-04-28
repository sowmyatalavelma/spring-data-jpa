package com.cg.homeloan.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.homeloan.entities.FinanceVerificationOfficer;
import com.cg.homeloan.entities.LandVerificationOfficer;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.Status;

/**
 * 
 * @author SOWMYA
 * @author VINAYA SREE
 *
 */

@ExtendWith({ SpringExtension.class })
@DataJpaTest
@Import({LandVerificationImpl.class,LoanApplicationImpl.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class LandVerificationImplTest {
	@Autowired
	private ILandVerificationService lService;
	
	@Autowired
	private ILoanApplicationService service;
	
	@Test
	public void testAddOfficer() {
		LandVerificationOfficer lanVerOff=new LandVerificationOfficer("Karthika", "8978342217");
		LandVerificationOfficer exLandVerificationOfficer = lService.addOfficer(lanVerOff);
		Assertions.assertEquals(exLandVerificationOfficer.getOfficerName(), lanVerOff.getOfficerName());
	}
	
	@Test
	public void testUpdateStatus() {
		
		LoanApplication lApp=service.addLoanApplication(new LoanApplication(123, LocalDate.parse("2020-08-22"), 600000, 60000,false ,false , false, Status.REJECTED));
		lApp.setLandVerificationApproval(true);;
		lApp.setFinanceVerificationApproval(true);
		LoanApplication exLoanApplication = lService.updateStatus(lApp);
		Assertions.assertEquals(exLoanApplication.isAdminApproval(), lApp.isAdminApproval());
	}
}
