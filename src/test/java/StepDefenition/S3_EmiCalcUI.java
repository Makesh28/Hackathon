package StepDefenition;


import org.apache.logging.log4j.Logger;
import Factory.BaseClass;
import Utilities.Assertions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.UIpage;

public class S3_EmiCalcUI {
	 
	Assertions myAssert = new Assertions(); // Custom assertions utility for validation
	UIpage Ui = new UIpage(BaseClass.getDriver()); // UI page object for EMI calculator interactions
	Logger logger = BaseClass.getLogger(); // Logger for logging actions
	@Given("user navigates to EMI Calc Page")
	public void user_navigates_to_EMI_calc_page() 
	{
		logger.info("SC_003_01_Navigating to EMI Calc Page");
		// Navigating to the respective page
		Ui.navigatorForEMICalc(); // Call the method to navigate to EMI Calculator
		logger.info("SC_003_02_Navigated to EMI Calc Page");
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	
	// Step definition for validating the loan amount textbox and slider
	@When("user validates loan amount textbox and slider of EMI Calculator page")
	public void user_validate_interest_amount_textbox_and_slider() 
	{
		logger.info("SC_003_03_Validating loan amount textbox and slider");
		
		// Validate if Loan Amount Text Box is visible
		if(Ui.getLoanAmtTextBox().isDisplayed()) {
			logger.info("SC_003_04_Loan amount textbox and slider is visible");
			myAssert.pass(); // Log success if visible
		} else {
			logger.error("SC_003_04_Loan Amount Text Box is not visible.");
			myAssert.fail(); // Log failure if not visible
		}
		// Validate if Loan Amount Text Box is enabled
		if(Ui.getLoanAmtTextBox().isEnabled()) {
			logger.info("SC_003_05_Loan Amount Text Box is enabled");
			myAssert.pass(); // Log success if enabled
		} else {
			logger.error("SC_003_05_Loan Amount Text Box is not enabled.");
			myAssert.fail(); // Log failure if not enabled
		}
		
		// Validate if Loan Amount Slider is visible
		if(Ui.getLoanAmtSlider().isDisplayed()) {
			logger.info("SC_003_06_Loan Amount slider is visible.");
			myAssert.pass(); // Log success if visible
		} else {
			logger.error("SC_003_06_Loan Amount Slider is not visible.");
			myAssert.fail(); // Log failure if not visible
		}
		
		// Validate if Loan Amount Slider is enabled
		if(Ui.getLoanAmtSlider().isEnabled()) {
			logger.info("SC_003_07_Loan Amount slider is enabled.");
			myAssert.pass(); // Log success if enabled
		} else {
			logger.error("SC_003_07_Loan Amount Slider is not enabled.");
			myAssert.fail(); // Log failure if not enabled
		}
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	
	// Step definition for validating scale change of loan amount textbox and slider
	@When("user validates scale change for loan amount textbox and slider of EMI Calculator page")
	public void user_validate_scale_change_for_loan_amount_textbox_and_slider()
	{
		logger.info("SC_003_08_Validating scale change for loan amount textbox and slider");
		
		// Moving the Slider to Initial Position
		Ui.moveLoanAmtSlider(0);
		// Moving the slider to Desired Position
		Ui.moveLoanAmtSlider(130);
		
		// Validate if the value in the textbox matches the slider's value
		if(Ui.getLoanAmtTextBoxValue().equals("50,00,000")) {
			logger.info("SC_003_09_scale Change for Loan Amount Text Box and Slider was successful");
			myAssert.pass(); // Log success if values match
		} else {
			logger.error("SC_003_09_Scale Change for Loan Amount Text Box and Slider was unsuccessful");
			myAssert.fail(); // Log failure if values do not match
		}
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/

	// Step definition for validating interest rate textbox and slider
	@When("user validates interest rate textbox and slider of EMI Calculator page")
	public void user_validates_interest_rate_textbox_and_slider() 
	{
		logger.info("SC_003_10_Validating interest rate textbox and slider");
		
		// Validate if Interest Rate Text Box is visible
		if(Ui.getIntRateTextBox().isDisplayed()) {
			logger.info("SC_003_11_Interest Rate Text Box is visible.");
			myAssert.pass(); // Log success if visible
		} else {
			logger.error("SC_003_11_Interest Rate Text Box is not visible.");
			myAssert.fail(); // Log failure if not visible
		}
		
		// Validate if Interest Rate Text Box is enabled
		if(Ui.getIntRateTextBox().isEnabled()) {
			logger.info("SC_003_12_Interest Rate Text Box is enabled.");
			myAssert.pass(); // Log success if enabled
		} else {
			logger.error("SC_003_12_Interest Rate Text Box is not enabled.");
			myAssert.fail(); // Log failure if not enabled
		}
		
		// Validate if Interest Rate Slider is visible
		if(Ui.getIntRateSlider().isDisplayed()) {
			logger.info("SC_003_13_Interest Rate Slider is visible.");
			myAssert.pass(); // Log success if visible
		} else {
			logger.error("SC_003_13_Interest Rate Slider is not visible.");
			myAssert.fail(); // Log failure if not visible
		}
		
		// Validate if Interest Rate Slider is enabled
		if(Ui.getIntRateSlider().isEnabled()) {
			logger.info("SC_003_14_Interest Rate Slider is enabled.");
			myAssert.pass(); // Log success if enabled
		} else {
			logger.error("SC_003_14_Interest Rate Slider is not enabled.");
			myAssert.fail(); // Log failure if not enabled
		}
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
 
	// Step definition for validating scale change of interest rate textbox and slider
	@When("user validates scale change for interest rate textbox and slider of EMI Calculator page")
	public void user_validates_scale_change_for_interest_rate_textbox_and_slider()
	{	
		logger.info("SC_003_15_Validating scale change for interest rate textbox and slider");
		
		// Moving the Slider to Initial Position
		Ui.moveIntRateSlider(0);
		
		// Moving the slider to Desired Position
		Ui.moveIntRateSlider(112);
		
		// Validate if the value in the textbox matches the slider's value
		if(Ui.getIntRateTextBoxValue().equals("14.25")) {
			logger.info("SC_003_16_Scale Change for Interest Rate Text Box and Slider was successful");
			myAssert.pass(); // Log success if values match
		} else {
			logger.error("SC_003_16_Scale Change for Interest Rate Text Box and Slider was unsuccessful");
			myAssert.fail(); // Log failure if values do not match
		}
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	
	// Step definition for validating loan tenure textbox and slider
	@When("user validates loan tenure textbox and slider of EMI Calculator page")
	public void user_validates_loan_tenure_textbox_and_slider() {
		logger.info("SC_003_17_Validating loan tenure textbox and slider");
		
		// Validate if Loan Tenure Text Box is visible
		if(Ui.getLoanTenureTextBox().isDisplayed()) {
			logger.info("SC_003_18_Loan Tenure Text Box is visible.");
			myAssert.pass(); // Log success if visible
		} else {
			logger.error("SC_003_18_Loan Tenure Text Box is not visible.");
			myAssert.fail(); // Log failure if not visible
		}
		
		// Validate if Loan Tenure Text Box is enabled
		if(Ui.getLoanTenureTextBox().isEnabled()) {
			logger.info("SC_003_19_Loan Tenure Text Box is enabled.");
			myAssert.pass(); // Log success if enabled
		} else {
			logger.error("SC_003_19_Loan Tenure Text Box is not enabled.");
			myAssert.fail(); // Log failure if not enabled
		}
		
		// Validate if Loan Tenure Slider is visible
		if(Ui.getLoanTenureSlider().isDisplayed()) {
			logger.info("SC_003_20_Loan Tenure Slider is visible.");
			myAssert.pass(); // Log success if visible
		} else {
			logger.error("SC_003_20_Loan Tenure Slider is not visible.");
			myAssert.fail(); // Log failure if not visible
		}
		
		// Validate if Loan Tenure Slider is enabled
		if(Ui.getLoanTenureSlider().isEnabled()) {
			logger.info("SC_003_21_Loan Tenure Slider is enabled.");
			myAssert.pass(); // Log success if enabled
		} else {
			logger.error("SC_003_21_Loan Tenure Slider is not enabled.");
			myAssert.fail(); // Log failure if not enabled
		}
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
 
	// Step definition for validating scale change of loan tenure textbox and slider
	@When("user validates scale change for loan tenure textbox and slider of EMI Calculator page")
	public void user_validates_scale_change_for_loan_tenure_textbox_and_slider() 
	{
		logger.info("SC_003_22_Validating scale change for loan tenure textbox and slider");
		
		// Moving the Slider to Initial Position
		Ui.moveLoanTenureSlider(0);	
		// Moving the slider to Desired Position
		Ui.moveLoanTenureSlider(105);
		
		// Validate if the value in the textbox matches the slider's value
		if(Ui.getLoanTenureTextBoxValue().equals("10")) {
			logger.info("SC_003_23_Scale Change for Loan Tenure Text Box and Slider was successful");
			myAssert.pass(); // Log success if values match
		} else {
			logger.error("SC_003_23_Scale Change for Loan Tenure Text Box and Slider was unsuccessful");
			myAssert.fail(); // Log failure if values do not match
		}
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
 
	// Step definition for validating year and month option functionality
	@When("user validates year and month option of EMI Calculator page")
	public void user_validates_year_and_month_option() {
		logger.info("SC_003_24_Validating year and month option");
		
		// Clicking on the year button
		Ui.clickYear();
		// Storing the value of year in a string
		String yearVal = Ui.getLoanTenureTextBoxValue();
		// Converting the year value to the month value
		int yearValInInt = Integer.parseInt(yearVal);
		// Clicking on the month Button
		Ui.clickMonth();
		// Storing the value of month in a string
		String monthVal = Ui.getLoanTenureTextBoxValue();
		
		// Assert that the month value is 12 times the year value
		if(monthVal.equals(Integer.toString(yearValInInt * 12))) {
			myAssert.pass(); // Log success if values match
			logger.info("SC_003_25_The data flow between the year and month is proper ");
		} else {
			logger.error("SC_003_25_The data flow between the year and month is not proper in the Loan Amount Calculator Section..");
			myAssert.fail(); // Log failure if values do not match
		}
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	
	// Step definition for validating fees and charges textbox and slider
	@When("user validates fees and charges textbox and slider of EMI Calculator page")
	public void user_validate_fees_and_charges_textbox_and_slider() 
	{
		logger.info("SC_003_26_Validating fees and charges textbox and slider");
		
		// Validate if Fees And Charges Text Box is visible
		if(Ui.getFeesAndChargesTextBox().isDisplayed()) {
			logger.info("SC_003_27_Fees And Charges Text Box is visible.");
			myAssert.pass(); // Log success if visible
		} else {
			logger.error("SC_003_27_Fees And Charges Text Box is not visible.");
			myAssert.fail(); // Log failure if not visible
		}
		
		// Validate if Fees And Charges Text Box is enabled
		if(Ui.getFeesAndChargesTextBox().isEnabled()) {
			logger.info("SC_003_28_Fees And Charges Text Box is enabled.");
			myAssert.pass(); // Log success if enabled
		} else {
			logger.error("SC_003_28_Fees And Charges Text Box is not enabled.");
			myAssert.fail(); // Log failure if not enabled
		}
		// Validate if Fees And Charges Slider is visible
		if(Ui.getFeesAndChargesSlider().isDisplayed()) {
			logger.info("SC_003_29_Fees And Charges Slider is visible.");
			myAssert.pass(); // Log success if visible
		} else {
			logger.error("SC_003_29_Fees And Charges Slider is not visible.");
			myAssert.fail(); // Log failure if not visible
		}
		// Validate if Fees And Charges Slider is enabled
		if(Ui.getFeesAndChargesSlider().isEnabled()) {
			logger.info("SC_003_30_Fees And Charges Slider is enabled.");
			myAssert.pass(); // Log success if enabled
		} else {
			logger.error("SC_003_30_Fees And Charges Slider is not enabled.");
			myAssert.fail(); // Log failure if not enabled
		}
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	
	// Step definition for validating scale change of fees and charges textbox and slider
	@When("user validates scale change for fees and charges textbox and slider of EMI Calculator page")
	public void user_validates_scale_change_for_fees_and_charges_textbox_and_slider() 
	{
		logger.info("SC_003_31_user_validates_scale_change_for_fees_and_charges_textbox_and_slider");
		// Moving the Slider to Initial Position
		Ui.moveFeesAndChargesSlider(0);
		// Moving the slider to Desired Position
		Ui.moveFeesAndChargesSlider(97);
		// Validate if the value in the textbox matches the slider's value
		if(Ui.getFeesAndChargesTextBoxValue().equals("25,000")) {
			logger.info("SC_003_32_Scale Change for Fees And Charges Text Box and Slider was successful");
			myAssert.pass(); // Log success if values match
		} else {
			logger.error("SC_003_32_Scale Change for Fees And Charges Text Box and Slider was unsuccessful");
			myAssert.fail(); // Log failure if values do not match
		}
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	
	// Step definition for final validation message after EMI Calculator checks
	@Then("Emi Calculator ui check validation is successful")
	public void EMI_Calc_ui_check_validation_is_successful() 
	{
	    logger.info("SC_003_33_EMI Calculator UI Check validation is successful");
	}
}