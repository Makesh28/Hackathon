package TestCase;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObject.UIpage;

public class TS005_UI_LoanTenureCalc extends DriverSetup {

    // Variable to track the test pass/fail status
    private boolean testPassed = true;

    // Test case to validate the EMI Calculator page navigation and title (smoke test)
    @Test(priority = 1, groups = {"smoke"})
    public void validate_EMICalPage() throws IOException 
    {
        // Load properties file that contains the expected title of the EMI Calculator page
        FileReader file = new FileReader("./src//test//resources//config.properties");
        p = new Properties();
        p.load(file);

        // Create an instance of UIpage for interacting with UI elements
        UIpage Ui = new UIpage(driver);

        // Log the action of navigating to the EMI Calculator page
        logger.info("TS003_Navigating to the EMI Calculator page.");
        Ui.navigatorForEMICalc();  // Navigate to EMI Calculator page
        logger.info("TS003_Navigated to the EMI Calculator page.");
        
        // Retrieve the current page title and compare it to the expected value from properties
        String pageTitle = driver.getTitle();
        if (pageTitle.equals(p.getProperty("EMICalculatorPage"))) {
            logger.info("Smoke Test Successfully Verified - EMI Calculator Page");
        } else {
            // If the title doesn't match, log an error and fail the test
            logger.error("Smoke Test Failed - EMI Calculator Page");
            Assert.fail();
        }
    }

    /*-------------------------------------------------------------------------------------------------------------*/

    // Test case to validate the functionality of the Loan Tenure Calculator page (regression test)
    @Test(priority = 2, groups = {"regression"})
    public void user_validate_Loan_Tenure_Calculator_functionality() 
    {
        try {
            // Log initial action
            logger.info("UI_LoanTenure_Calculation");

            // Initialize the UIpage object to interact with UI elements
            UIpage UI = new UIpage(driver);

            // Log the action of navigating to the Loan Tenure Calculator page
            logger.info("01.Navigating to the Loan Tenure Calculator page.");
            UI.navigatorForLoanTenureCalc();
            logger.info("02.Navigated to the Loan Tenure Calculator page.");

            // Soft assertion to validate displayed elements on the Loan Tenure Calculator page
            logger.info("03.Validating displayed elements of Loan Tenure Calculator.");
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(UI.getLoanAmtTextBox().isDisplayed(), "Loan Amount Text Box is not visible");
            softAssert.assertTrue(UI.getLoanAmtSlider().isDisplayed(), "Loan Amount Slider is not visible");
            softAssert.assertTrue(UI.getEMITextBox().isDisplayed(), "EMI Text Box is not visible");
            softAssert.assertTrue(UI.getEMISlider().isDisplayed(), "EMI Slider is visible unexpectedly");
            softAssert.assertTrue(UI.getIntRateTextBox().isDisplayed(), "Interest Rate Text Box is not visible");
            softAssert.assertTrue(UI.getIntRateSlider().isDisplayed(), "Interest Rate Slider is not visible");
            softAssert.assertTrue(UI.getFeesAndChargesTextBox().isDisplayed(), "Fees And Charges Text Box is not visible");
            softAssert.assertTrue(UI.getFeesAndChargesSlider().isDisplayed(), "Fees And Charges Slider is not visible");
            logger.info("04.All elements are displayed successfully in Loan Tenure Calculator page.");

            // Validate that the UI elements are enabled
            logger.info("05.Validating enabled elements of Loan Tenure Calculator.");
            softAssert.assertTrue(UI.getLoanAmtTextBox().isEnabled(), "Loan Amount Text Box is not enabled");
            softAssert.assertTrue(UI.getLoanAmtSlider().isEnabled(), "Loan Amount Slider is not enabled");
            softAssert.assertTrue(UI.getEMITextBox().isEnabled(), "EMI Text Box is not enabled");
            softAssert.assertTrue(UI.getEMISlider().isEnabled(), "EMI Slider is not enabled");
            softAssert.assertTrue(UI.getIntRateTextBox().isEnabled(), "Interest Rate Text Box should not be enabled");
            softAssert.assertTrue(UI.getIntRateSlider().isEnabled(), "Interest Rate Slider is not enabled");
            softAssert.assertTrue(UI.getFeesAndChargesTextBox().isEnabled(), "Fees And Charges Text Box is not enabled");
            softAssert.assertTrue(UI.getFeesAndChargesSlider().isEnabled(), "Fees And Charges Slider is not enabled");
            logger.info("06.All elements are enabled successfully in Loan Tenure Calculator page.");

            // Test the scale change for Loan Amount slider and validate the displayed value
            logger.info("07.Testing scale change for Loan Amount in Loan Tenure Calculator page.");
            UI.moveLoanAmtSlider(0);  // Move the slider to the minimum position
            UI.moveLoanAmtSlider(130);  // Move the slider to the maximum position
            softAssert.assertEquals(UI.getLoanAmtTextBoxValue(), "50,00,000", "Scale change for Loan Amount did not match.");
            logger.info("08.Scale change for Loan Amount validated successfully.");

            // Test the scale change for Interest Rate slider and validate the displayed value
            logger.info("09.Testing scale change for Interest Rate in Loan Tenure Calculator page.");
            UI.moveIntRateSlider(0);  // Move the slider to the minimum value
            UI.moveIntRateSlider(112);  // Move the slider to a specified value
            softAssert.assertEquals(UI.getIntRateTextBoxValue(), "14.25", "Scale change for Interest Rate did not match.");
            logger.info("10.Scale change for Interest Rate validated successfully in Loan Tenure Calculator page.");

            // Test the scale change for Fees and Charges slider and validate the displayed value
            logger.info("11.Testing scale change for Fees and Charges in Loan Tenure Calculator page.");
            UI.moveFeesAndChargesSlider(0);  // Move the slider to the minimum position
            UI.moveFeesAndChargesSlider(97);  // Move the slider to the specified value
            softAssert.assertEquals(UI.getFeesAndChargesTextBoxValue(), "25,000", "Scale change for Fees and Charges did not match.");
            logger.info("12.Scale change for Fees and Charges validated successfully in Loan Tenure Calculator page.");

            // After all soft assertions are done, collect and report the results
            softAssert.assertAll();
            logger.info("13.Loan Tenure UI check validation is successful.");
        } 
        catch (AssertionError e) 
        {
            // If any assertion fails, log the failure and re-throw the exception to ensure the test fails
            logger.error("TS005_Loan Tenure UI check validation failed: " + e.getMessage());
            throw e;  // Re-throw the exception to ensure the test fails
        }
    }
}