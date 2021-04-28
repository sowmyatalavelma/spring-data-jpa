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

import com.cg.homeloan.entities.Customer;
import com.cg.homeloan.entities.FinanceVerificationOfficer;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.Status;
import com.cg.homeloan.service.FinanceVerificationImpl;

/**
 * 
 * @author SOWMYA
 * @author VINAYA SREE
 *
 */

@ExtendWith({ SpringExtension.class })
@DataJpaTest
@Import({FinanceVerificationImpl.class,LoanApplicationImpl.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class FinanceVerificationImplTest {
	@Autowired
	private IFinanceVerificationService fService;
	
	@Autowired
	private ILoanApplicationService lService;
	
	@Test
	public void testAddOfficer() {
		FinanceVerificationOfficer finVerOff=new FinanceVerificationOfficer("surendar", "7654321678");
		FinanceVerificationOfficer exFinanceVerificationOfficer = fService.addOfficer(finVerOff);
		Assertions.assertEquals(exFinanceVerificationOfficer.getFinOfficerName(), finVerOff.getFinOfficerName());
	}
	
	
	@Test
	public void testUpdateStatus() {
		
		LoanApplication lApp=lService.addLoanApplication(new LoanApplication(123, LocalDate.parse("2020-08-22"), 600000, 60000,false ,true , false, Status.PENDING));
		LoanApplication exLoanApplication = fService.updateStatus(lApp);
		Assertions.assertEquals(exLoanApplication.isFinanceVerificationApproval(),lApp.isFinanceVerificationApproval());
	}
}
