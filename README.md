# ANZLoanCalculator


**Instructions to set up the project -**

Step-1: 
	Download workspace from GitHub “https://github.com/AnupPrasad1234/ANZLoanCalculator”
  
Step-2:
	Install JDK and add “JAVA_HOME” variable with JDK path in environment variable and include “%JAVA_HOME%\bin” in path variable
  
Step-3: 
	Import the downloaded project in eclips/IntelliJ
  
Step-4:
	Add all the jars (present under "requiredJars" folder) to your build path. Also add TestNG in eclips from eclips market place
  
Step-5:
	Run Run_Test.xml o run the suite
  
Step-6:
	After completion of execution html report "index.html" will be generated in “test-output” folder.
  
Step-7:
	Screen shots will be generated in "Screenshots folder
  
  
 **ANSWERS OF THE QUESTIONS ASKED IN THE ASSESMENT DOCUMENT-**
  
 **Answer –1**
  
Scenarios
1.	Select application type as Joint, dependants 0, purpose of buy as “Home to live in” and with income of $60,000,other income $0,2nd applicant’s income, other income of $0 and living expenses $500 and check the estimation.
2.	Select application type as Joint, dependants 0, purpose of buy as “Home to live in” and with income of $60,000,other income $0,2nd applicant’s income, other income of $10000 and living expenses $500 and check the estimation
3.	Verify scenario 10 with home loan repayment of $1,557 and $1,558.
4.	Verify scenario 10 with Joint applicant type home loan repayment of $1557 and total credit limit of $25 and $26.
5.	Verify scenario 10 with home loan repayment of $1556 and other commitments of $2 and $3.
6.	Verify scenarios 11 to 13 by increasing/decreasing income and 2nd applicant’s income.
7.	Verify scenarios 11 to 13 byincreasing/decreasing other income and 2nd applicant’s other income.
8.	Verify all the above scenarios with different no of dependants.
9.	Verify all the above scenarios with purpose of buy as Investment.
10.	Verify scenarios 2, 9 and 10 by increasing expenses and decreasing other commitments.
11.	Verify scenarios 2, 9 and 10 by decreasing expenses and increasing other commitments.
12.	Click on borrow button leaving all the fields as 0.
13.	Select application type as Single, dependants 0, purpose of buy as “Home to live in” and with income of $60,000,other income $0, living expenses $500 and check the estimation
14.	Verify scenario 2 with Home loan repayment of $1797 and $1798.
15.	Verify scenario 2 with Home loan repayment of $1797 and total credit limit of $16 and $17.
16.	Verify scenario 2 with Home loan repayment of $1796 and other commitments of $1 and $3.
17.	Verify scenarios 3 to 5 after increasing/Decreasing other loan repayment.
18.	Verify scenarios 3 to 5 after increasing/decreasing income.
19.	Verify scenarios 3 to 5 after increasing/decreasing other income.

**Answer –2**
1.	If we have larger test set, then we can test scripts in parallel.
2.	Run the scripts in fastest browser.
3.	Use selenium waits instead of Thread.sleep.
4.	Use fastest element locator to identify webelement.

**Answer –3**
1.	Use explicit wait to wait till the element to load
2.	Use javascript to get the page ready status.
