package com.automation.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.pages.BaseClass;
import com.automation.pages.LoanCalculatorPage;

public class LoanCalculatorTest extends BaseClass {

	@Test(enabled=true)
	public void testCase_1() throws InterruptedException 
	{
		// Below line will initialize the page or locators of this page and this will return the object of same class
		LoanCalculatorPage loanCalculator = PageFactory.initElements(driver, LoanCalculatorPage.class);

		loanCalculator.selectApplicationType(excel.getStringData("Calculator", 1, 0));
		loanCalculator.selectNoOfDependants(excel.getStringData("Calculator", 1, 1));
		loanCalculator.selectPurposeOfBuy(excel.getStringData("Calculator", 1, 2));
		loanCalculator.enterYourIncome(excel.getStringData("Calculator", 1, 3));
		loanCalculator.enterOtherIncome(excel.getStringData("Calculator", 1, 4));
		loanCalculator.enterLivingExpenses(excel.getStringData("Calculator", 1, 5));
		loanCalculator.enterHomeLoanRepayment(excel.getStringData("Calculator", 1, 6));
		loanCalculator.enterOtherLoanRepayment(excel.getStringData("Calculator", 1, 7));
		loanCalculator.enterOtherCommitments(excel.getStringData("Calculator", 1, 8));
		loanCalculator.enterTotalCreditCardLimit(excel.getStringData("Calculator", 1, 9));
		loanCalculator.clickOnWorkOutBorrowBtn();

		String actualEstimatedAmount = loanCalculator.getApplicationEstimatedBorrowAmount();
		String expectedEstimatedAmount = String.valueOf(excel.getNumericData("Calculator", 1, 10));

		Assert.assertTrue(actualEstimatedAmount.equals(expectedEstimatedAmount));
	}

	@Test(enabled=true)
	public void testCase_2() throws InterruptedException 
	{
		LoanCalculatorPage loanCalculator = PageFactory.initElements(driver, LoanCalculatorPage.class);
		
		loanCalculator.selectApplicationType(excel.getStringData("Calculator", 1, 0));
		loanCalculator.selectNoOfDependants(excel.getStringData("Calculator", 1, 1));
		loanCalculator.selectPurposeOfBuy(excel.getStringData("Calculator", 1, 2));
		loanCalculator.enterYourIncome(excel.getStringData("Calculator", 1, 3));
		loanCalculator.enterOtherIncome(excel.getStringData("Calculator", 1, 4));
		loanCalculator.enterLivingExpenses(excel.getStringData("Calculator", 1, 5));
		loanCalculator.enterHomeLoanRepayment(excel.getStringData("Calculator", 1, 6));
		loanCalculator.enterOtherLoanRepayment(excel.getStringData("Calculator", 1, 7));
		loanCalculator.enterOtherCommitments(excel.getStringData("Calculator", 1, 8));
		loanCalculator.enterTotalCreditCardLimit(excel.getStringData("Calculator", 1, 9));
		loanCalculator.clickOnWorkOutBorrowBtn();
		loanCalculator.clickOnStartOverBtn();
		loanCalculator.checkFieldsGotCleared();
	}

	@Test(enabled=true)
	public void testCase_3() throws InterruptedException 
	{
		LoanCalculatorPage loanCalculator = PageFactory.initElements(driver, LoanCalculatorPage.class);
		loanCalculator.enterLivingExpenses("1");
		loanCalculator.clickOnWorkOutBorrowBtn();
		String actualErrorMessage = loanCalculator.getBorrowErrorMessage();
		String expectedErrorMessage = excel.getStringData("Misc", 1, 0);
		
		Assert.assertTrue(actualErrorMessage.equals(expectedErrorMessage));
	}
}
