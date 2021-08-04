package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LoanCalculatorPage extends BaseClass{

	WebDriver driver;

	public LoanCalculatorPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	@FindBy(xpath = "//label[@for='application_type_single']") WebElement applicationTypeSingle ;
    @FindBy(xpath = "//label[@for='application_type_joint']") WebElement applicationTypeJoint ;
    @FindBy(xpath = "//*[@title='Number of dependants']") WebElement noOfDependantsDropDown;
    @FindBy(xpath = "//*[@for='borrow_type_home']") WebElement homeToLiveIn;
    @FindBy(xpath = "//*[@for='borrow_type_investment']") WebElement residentialInvestment;
    @FindBy(xpath = "//*[@aria-labelledby='q2q1']") WebElement incomeField;
    @FindBy(xpath = "//*[@aria-labelledby='q2q3']") WebElement jointApplicantIncomeField;
    @FindBy(xpath = "//*[@aria-labelledby='q2q2']") WebElement otherIncomeField;
    @FindBy(xpath = "//*[@aria-labelledby='q2q4']") WebElement jointApplicantOtherIncomeField;
    @FindBy(id = "expenses") WebElement livingExpenseField;
    @FindBy(id = "homeloans") WebElement homeLoanRepaymentField;
    @FindBy(id = "otherloans") WebElement otherLoanRepaymentField;
    @FindBy(xpath = "//*[@aria-labelledby='q3q4']") WebElement otherCommitmentsField;
    @FindBy(id = "credit") WebElement creditCardLimitsField;
    @FindBy(xpath = "//*[@aria-labelledby='q1q1']/li[1]") WebElement singleApplicantRadioButton;
    @FindBy(xpath = "//*[@aria-labelledby='q1q1']/li[2]") WebElement jointApplicantRadioButton;
    @FindBy(xpath = "//*[@aria-labelledby='q1q3']/li[1]") WebElement livingPurposeRadioButton;
    @FindBy(xpath = "//*[@aria-labelledby='q1q3']/li[2]") WebElement investmentPurposeRadioButton;
    
    @FindBy(xpath = "//*[contains(@class, 'btn--borrow__calculate')]") WebElement borrowButton;
    @FindBy(className = "borrow__error__text") WebElement borrowErrorMessage;
    @FindBy(className = "start-over") WebElement startOverButton;
    @FindBy(className = "borrow__result__text__amount") WebElement borrowAmount;
	
    /**
     * This method selects the application type radio button based on the parameter passed (Single/Joint)
     * @param applicationType
     */
	public void selectApplicationType(String applicationType)
	{
		if(applicationType.contains("Single"))
		{
			applicationTypeSingle.click();
			if(singleApplicantRadioButton.getAttribute("class").equalsIgnoreCase("selected"))
			{
				System.out.println("Selected application type is Single");
			}
			else
			{
				System.out.println("Failed to select Single application type option");
				Assert.assertTrue(false, "Failed to select Single application type option");
			}
		} else
		{
			applicationTypeJoint.click();
			if(jointApplicantRadioButton.getAttribute("class").equalsIgnoreCase("selected"))
			{
				System.out.println("Selected application type is joint");
			}
			else
			{
				System.out.println("Failed to select joint application type option");
                Assert.assertTrue(false, "Failed to select joint application type option");
			}
		}
	}
	
	
	
	/**
     * This method selects the no of Dependants for the drop down field
     * @param NoOfDependants
	 * @throws InterruptedException 
     */
    public void selectNoOfDependants(String NoOfDependants) throws InterruptedException
    {
    
        Select dependantDropDownField = new Select(noOfDependantsDropDown);
        dependantDropDownField.selectByVisibleText(NoOfDependants);
        Thread.sleep(5000);
        if(dependantDropDownField.getFirstSelectedOption().getText().equalsIgnoreCase(String.valueOf(NoOfDependants)))
        {
            System.out.println("Selected number of dependants is " + NoOfDependants);
        }
        else
        {
        	System.out.println("Failed to select no dependants");
            Assert.assertTrue(false, "Failed to select no dependants");
        }
    }
    
    /**
     * This method selects the purpose of property buy based on the parameter passed (Live/Investment)
     * @param purpose
     */
    public void selectPurposeOfBuy(String purpose) throws InterruptedException 
    {
        if(purpose.contains("Live"))
        {
            homeToLiveIn.click();
            Thread.sleep(5000);
            if(livingPurposeRadioButton.getAttribute("class").equalsIgnoreCase("selected"))
            {
            	System.out.println("Selected Property is Home to live in");
            }
            else
            {
            	System.out.println("Failed to select Home to live in option");
                Assert.assertTrue(false, "Failed to select Home to live in option");
            }
        }
        else
        {
            residentialInvestment.click();
            Thread.sleep(5000);
            if(investmentPurposeRadioButton.getAttribute("class").equalsIgnoreCase("selected"))
            {
            	System.out.println("Selected Property is Residential Investment");
            }
            else
            {
            	System.out.println("Failed to select Residential Investment option");
                Assert.assertTrue(false, "Failed to select Residential Investment option");
            }
        }
    }
	
    /**
     * This method enters the income amount into income text field
     * @param income
     * @throws InterruptedException 
     */
    public void enterYourIncome(String income) throws InterruptedException
    {
    	incomeField.clear();
        incomeField.sendKeys(String.valueOf(income));
        System.out.println(incomeField.getAttribute("value"));
        System.out.println(incomeField.getAttribute("value").replace(",",""));
        Thread.sleep(5000);
        if(incomeField.getAttribute("value").replace(",","").equals(String.valueOf(income)))
        {
        	System.out.println("Entered Income before tax is "+ income);
        }
        else
        {
        	System.out.println("Failed to enter Income before tax");
            Assert.assertTrue(false, "Failed to enter Income before tax");
        }
    }
	
    /**
     * This method enters the Other income amount into Other income text field
     * @param otherIncome
     */
    public void enterOtherIncome(String otherIncome)
    {
        otherIncomeField.sendKeys(String.valueOf(otherIncome));
        if(otherIncomeField.getAttribute("value").replace(",","").equals(String.valueOf(otherIncome)))
        {
            System.out.println("Entered Other Income is "+ otherIncome);
        }
        else
        {
        	System.out.println("Failed to enter Other Income");
            Assert.assertTrue(false, "Failed to enter Other Income");
        }
    }
    
    /**
     * This method enters the joint applicant income amount into 2nd applicant income text field
     * @param jointIncome
     */
    public void enterJointApplicantIncome(String jointIncome)
    {
        jointApplicantIncomeField.sendKeys(String.valueOf(jointIncome));
        if(jointApplicantIncomeField.getAttribute("value").replace(",","").equals(String.valueOf(jointIncome)))
        {
        	System.out.println("Entered joint applicant Income before tax is "+ jointIncome);
        }
        else
        {
        	System.out.println("Failed to enter joint applicant Income");
            Assert.assertTrue(false, "Failed to enter joint applicant Income");
        }
    }
    
    /**
     * This method enters the joint applicant other income amount into 2nd applicant other income text field
     * @param jointOtherIncome
     */
    public void enterJointApplicantOtherIncome(String jointOtherIncome)
    {
        jointApplicantOtherIncomeField.sendKeys(String.valueOf(jointOtherIncome));
        if(jointApplicantOtherIncomeField.getAttribute("value").replace(",","").equals(String.valueOf(jointOtherIncome)))
        {
        	System.out.println("Entered joint applicant Other Income is "+ jointOtherIncome);
        }
        else
        {
        	System.out.println("Failed to enter joint applicant Other Income");
            Assert.assertTrue(false, "Failed to enter joint applicant Other Income");
        }
    }

    /**
     * This method enters the expenses amount into Other expenses text field
     * @param string
     * @throws InterruptedException 
     */
    public void enterLivingExpenses(String string) throws InterruptedException
    {
        livingExpenseField.sendKeys(String.valueOf(string));
        Thread.sleep(5000);
        System.out.println(string);
        System.out.println(livingExpenseField.getAttribute("value"));
        if(livingExpenseField.getAttribute("value").replace(",","").equals(String.valueOf(string)))
        {
        	System.out.println("Entered Living expenses is "+ string);
        }
        else
        {
        	System.out.println("Failed to enter Living expenses");
            Assert.assertTrue(false, "Failed to enter Living expenses");
        }
    }
    
    /**
     * This method enters the Home loan repayment amount into Home loan repayment text field
     * @param repayment
     */
    public void enterHomeLoanRepayment(String repayment)
    {
       homeLoanRepaymentField.sendKeys(String.valueOf(repayment));
        if(homeLoanRepaymentField.getAttribute("value").replace(",","").equals(String.valueOf(repayment)))
        {
        	System.out.println("Enter Current Home loan repayment is "+ repayment);
        }
        else
        {
        	System.out.println("Failed to enter Current Home loan repayment");
            Assert.assertTrue(false, "Failed to enter Current Home loan repayment");
        }
    }
    
    /**
     * This method enters the Other loan repayment amount into Other loan repayment text field
     * @param otherRepayment
     */
    public void enterOtherLoanRepayment(String otherRepayment)
    {
        otherLoanRepaymentField.sendKeys(String.valueOf(otherRepayment));
        if(otherLoanRepaymentField.getAttribute("value").replace(",","").equals(String.valueOf(otherRepayment)))
        {
        	System.out.println("Enter Other loan repayment is "+ otherRepayment);
        }
        else
        {
        	System.out.println("Failed to enter Other loan repayment");
            Assert.assertTrue(false, "Failed to enter Other loan repayment");
        }
    }
    
    /**
     * This method enters the Other Commitment amount into Other Commitment text field
     * @param otherCommitment
     */
    public void enterOtherCommitments(String otherCommitment)
    {
       otherCommitmentsField.sendKeys(String.valueOf(otherCommitment));
        if(otherCommitmentsField.getAttribute("value").replace(",","").equals(String.valueOf(otherCommitment)))
        {
        	System.out.println("Enter Other Commitments is "+ otherCommitment);
        }
        else
        {
        	System.out.println("Failed to enter Other Commitments");
            Assert.assertTrue(false, "Failed to enter Other Commitments");
        }
    }
    
    /**
     * This method enters the total credit card limit amount into total credit card limit text field
     * @param string
     */
    public void enterTotalCreditCardLimit(String string)
    {
        creditCardLimitsField.sendKeys(String.valueOf(string));
        if(creditCardLimitsField.getAttribute("value").replace(",","").equals(String.valueOf(string)))
        {
        	System.out.println("Enter Total credit card limits is "+ string);
        }
        else
        {
        	System.out.println("Failed to enter Total credit card limits");
            Assert.assertTrue(false, "Failed to enter Total credit card limits");
        }
    }

    /**
     * This method clicks on work out borrow button
     */
    public void clickOnWorkOutBorrowBtn()
    {
        borrowButton.click();
        System.out.println("Clicked on Work out Borrow button");
    }

    /**
     * This method clicks on Start Over button
     */
    public void clickOnStartOverBtn()
    {
        startOverButton.click();
        System.out.println("Clicked on Start over button");
    }
    
    /**
     * This method will give the actual loan amount from the screen
     */
    public String getApplicationEstimatedBorrowAmount()
    {
    	String amount = (borrowAmount.getText()).replace(",", "");
    	String amt = amount.replace("$", "");
    	System.out.println("Copied the actual expected loan amount");
    	return amt;
    }
    /**
     * This method will give the error message when entered only Living expenses and checked the eligibility
     */
    
    public String getBorrowErrorMessage()
    {
    	String str = borrowErrorMessage.getText();
    	System.out.println("Copied the error message when entered only Living expeneses");
    	return str;
    }
    
    /**
     * This method will check all the fields are set to default value
     */
    public void checkFieldsGotCleared()
    {
    	Assert.assertTrue(singleApplicantRadioButton.getAttribute("class").equalsIgnoreCase("selected"), "Application type field is not cleared");
        Select dependantDropDownField = new Select(noOfDependantsDropDown);
        Assert.assertTrue(dependantDropDownField.getFirstSelectedOption().getText().equalsIgnoreCase("0"), "No of dependants field is not cleared");
        Assert.assertTrue(livingPurposeRadioButton.getAttribute("class").equalsIgnoreCase("selected"), "Purpose of buy fields is not cleared");
        Assert.assertTrue(incomeField.getAttribute("value").equalsIgnoreCase("0"),"Income field is not cleared");
        Assert.assertTrue(otherIncomeField.getAttribute("value").equalsIgnoreCase("0"), "Other Income field is not cleared");
        Assert.assertTrue(!(jointApplicantIncomeField.isDisplayed()), "Joint Income field is displayed after start over");
        Assert.assertTrue(livingExpenseField.getAttribute("value").equalsIgnoreCase("0"), "Expense field is not cleared");
        Assert.assertTrue(homeLoanRepaymentField.getAttribute("value").equalsIgnoreCase("0"), "Home loan repayment field is not cleared");
        Assert.assertTrue(otherLoanRepaymentField.getAttribute("value").equalsIgnoreCase("0"), "Other loan repayment field is not cleared");
        Assert.assertTrue(otherCommitmentsField.getAttribute("value").equalsIgnoreCase("0"), "Commitments field is not cleared");
        Assert.assertTrue(creditCardLimitsField.getAttribute("value").equalsIgnoreCase("0"),"Total credit card limit field is not cleared");
        Assert.assertTrue(borrowButton.isDisplayed(), "Work out borrow button is not displayed after clear");
        
        System.out.println("All the fields are cleared after clicking on start over button");
    }
    
}
