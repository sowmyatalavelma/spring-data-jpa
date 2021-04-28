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
import com.cg.homeloan.entities.EMI;
import com.cg.homeloan.entities.LoanAgreement;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.Status;
import com.cg.homeloan.util.EMICalculator;

/**
 * 
 * @author SOWMYA
 * @author VINAYA SREE
 *
 */

@ExtendWith({ SpringExtension.class })
@DataJpaTest
@Import({LoanAgreementImpl.class,EMICalculator.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class LoanAgreementServiceTest {
	
	@Autowired
	private ILoanAgreementService lService;
	
	@Autowired
	private EMICalculator eCal;
	
	
	@Test
	public void TestAddLoanAgreement() {
		LoanAgreement lAgg=new LoanAgreement(123, 234, new EMI(123, LocalDate.parse("2020-08-20"), 60000, 60000, 20000));
		LoanAgreement exLoanAgreement = lService.addLoanAgreement(lAgg);
		Assertions.assertEquals(exLoanAgreement.getLoanAgreementId(), lAgg.getLoanAgreementId());
	}
	
	@Test
	public void TestUpdateLoanAgreement() {
		LoanApplication lApp=new LoanApplication(LocalDate.parse("2021-08-12"), 60000, 60000, true, true, true, Status.APPROVED,new Customer("133", "sow","1234567", "sowmya@1223", LocalDate.parse("2020-08-12"), "female", "Indian", "845645674567", "ERTYU5812D"));
		LoanAgreement lAgg=lService.addLoanAgreement(new LoanAgreement(123, 234, new EMI(123, LocalDate.parse("2020-08-20"), 60000, 60000, 20000)));
		lAgg.getEmi().setLoanAmount(lApp.getLoanAppliedAmount());
		lAgg.getEmi().setEmiAmount(eCal.getEMIAmount(lAgg.getEmi()));
		
		LoanAgreement exLoanAgreement = lService.updateLoanAgreement(lAgg);
		Assertions.assertEquals(exLoanAgreement.getEmi().getEmiAmount(),lAgg.getEmi().getEmiAmount());
	}
	
	@Test
	public void testDeleteLoanApplication() {
		LoanAgreement lAgr=lService.addLoanAgreement(new LoanAgreement(123, 234, new EMI(123, LocalDate.parse("2020-08-20"), 60000, 60000, 20000)));
		LoanAgreement exLoanAgreement = lService.deleteLoanAgreement(lAgr.getLoanAgreementId());
		Assertions.assertEquals(exLoanAgreement.getLoanAgreementId(), lAgr.getLoanAgreementId());
	}
	
	@Test
	public void TestRetrieveAllLoanAgreement() {
		LoanAgreement lArr1=lService.addLoanAgreement(new LoanAgreement(123, 234, new EMI(123, LocalDate.parse("2020-08-20"), 60000, 60000, 20000)));
		LoanAgreement lArr2=lService.addLoanAgreement(new LoanAgreement(124, 345, new EMI(124, LocalDate.parse("2020-06-23"), 30000, 30000, 40000)));
		
		List<LoanAgreement> lList=lService.retrieveAllLoanAgreement();
		Assertions.assertTrue(lList.contains(lArr1));
	}
	
	@Test
	public void testRetrieveLoanAgreementById() {
		LoanAgreement lArr1=lService.addLoanAgreement(new LoanAgreement(123, 234, new EMI(123, LocalDate.parse("2020-08-20"), 60000, 60000, 20000)));
		//LoanApplication lApp2=lService.addLoanApplication(new LoanApplication(LocalDate.parse("2020-08-12"), 23000, 2300, true, true, false, Status.APPROVED,new Customer("123", "swee","78263523", "swee@1223", LocalDate.parse("2020-06-12"), "female", "Indian", "845645674567", "ASDYU5812D")));
		
		LoanAgreement exLoanAgreement = lService.retrieveLoanAgreementById(lArr1.getLoanAgreementId());
		Assertions.assertEquals(exLoanAgreement.getLoanAgreementId(),lArr1.getLoanAgreementId());
	}
}

