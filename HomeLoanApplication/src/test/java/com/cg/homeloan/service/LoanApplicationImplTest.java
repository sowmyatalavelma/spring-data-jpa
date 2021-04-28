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
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.Status;
import com.cg.homeloan.entities.User;
import com.cg.homeloan.service.FinanceVerificationImpl;
import com.cg.homeloan.service.LoanApplicationImpl;

/**
 * 
 * @author SOWMYA
 * @author VINAYA SREE
 *
 */
@ExtendWith({ SpringExtension.class })
@DataJpaTest
@Import(LoanApplicationImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class LoanApplicationImplTest {
	@Autowired
	private ILoanApplicationService lService;
	
	@Test
	public void testAddLoanApplication() {
		LoanApplication lApp=new LoanApplication(LocalDate.parse("2021-08-12"), 60000, 60000, true, true, true, Status.APPROVED,new Customer("133", "sow","1234567", "sowmya@1223", LocalDate.parse("2020-08-12"), "female", "Indian", "845645674567", "ERTYU5812D"));
		LoanApplication exLoanApplication = lService.addLoanApplication(lApp);
		Assertions.assertEquals(exLoanApplication.getApplicationId(), lApp.getApplicationId());
	}
	
	@Test
	public void testUpdateLoanApplication() {
		LoanApplication lApp=lService.addLoanApplication(new LoanApplication(LocalDate.parse("2021-08-12"), 60000, 60000, true, true, false, Status.APPROVED,new Customer("133", "sow","1234567", "sowmya@1223", LocalDate.parse("2020-08-12"), "female", "Indian", "845645674567", "ERTYU5812D")));
		lApp.setAdminApproval(true);
		
		LoanApplication exLoanApplication = lService.updateLoanApplication(lApp);
		Assertions.assertEquals(exLoanApplication.isAdminApproval(),lApp.isAdminApproval());
	}
	
	@Test
	public void testDeleteLoanApplication() {
		LoanApplication lApp=lService.addLoanApplication(new LoanApplication(LocalDate.parse("2021-08-12"), 60000, 60000, true, true, false, Status.APPROVED,new Customer("133", "sow","1234567", "sowmya@1223", LocalDate.parse("2020-08-12"), "female", "Indian", "845645674567", "ERTYU5812D")));
		LoanApplication exLoanApplication = lService.deleteLoanApplication(lApp.getApplicationId());
		Assertions.assertEquals(exLoanApplication.getApplicationId(), lApp.getApplicationId());
	}
	
	@Test
	public void testRetrieveAllLoanApplication() {
		LoanApplication lApp1=lService.addLoanApplication(new LoanApplication(LocalDate.parse("2021-08-12"), 60000, 60000, true, true, false, Status.APPROVED,new Customer("133", "sow","1234567", "sowmya@1223", LocalDate.parse("2020-08-12"), "female", "Indian", "845645674367", "ERTYU5812D")));
		LoanApplication lApp2=lService.addLoanApplication(new LoanApplication(LocalDate.parse("2020-08-12"), 23000, 2300, true, true, false, Status.APPROVED,new Customer("123", "swee","78263523", "swee@1223", LocalDate.parse("2020-06-12"), "female", "Indian", "845645674567", "ASDYU5812D")));
		
		List<LoanApplication> lList=lService.retrieveAllLoanApplication();
		Assertions.assertTrue(lList.contains(lApp1));
	}
	
	@Test
	public void testRetriveLoanApplicationById() {
		LoanApplication lApp1=lService.addLoanApplication(new LoanApplication(LocalDate.parse("2021-08-12"), 60000, 60000, true, true, false, Status.APPROVED,new Customer("133", "sow","1234567", "sowmya@1223", LocalDate.parse("2020-08-12"), "female", "Indian", "845645674367", "ERTYU5812D")));
		//LoanApplication lApp2=lService.addLoanApplication(new LoanApplication(LocalDate.parse("2020-08-12"), 23000, 2300, true, true, false, Status.APPROVED,new Customer("123", "swee","78263523", "swee@1223", LocalDate.parse("2020-06-12"), "female", "Indian", "845645674567", "ASDYU5812D")));
		
		LoanApplication exLoanApplication = lService.retrieveLoanApplicationById(lApp1.getApplicationId());
		Assertions.assertEquals(exLoanApplication.getApplicationId(),lApp1.getApplicationId());
	}
}
