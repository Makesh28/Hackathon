package StepDefenition;

import Factory.BaseClass;
import Utilities.Assertions;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.UIpage;

public class S4_LoanAmtCalcUI {
    
    Logger logger = BaseClass.getLogger(); // Logger for tracking test execution
    Assertions myAssert = new Assertions(); // Assertion utility for validating test conditions
    UIpage UI = new UIpage(BaseClass.getDriver()); // UI page object for interactions with the loan amount calculator UI

    // Step definition for navigating to the loan amount calculator
    @Given("user click the loan amount calculator button")
    public void user_click_the_loan_amount_calculator_button() {
        logger.info("SC_004_01_navigating to loan amount calculator");
        // Navigate to the loan amount calculator page
        UI.navigatorForLoanAmountCalc();
        logger.info("SC_004_01_navigated to loan amount calculator");
    }

    /*-------------------------------------------------------------------------------------------------------------*/
    
    // Step definition for validating the EMI textbox and slider
    @When("user validates emi textbox and slider of Loan Amount Calculator Page")
    public void user_validates_emi_textbox_and_slider() {
        logger.info("SC_004_02_user_validates_emi_textbox_and_slider");
        
        // Check if EMI Text Box is displayed
        if(UI.getEMITextBox().isDisplayed()) {
            logger.info("SC_004_03_EMI Text Box is visible.");
            myAssert.pass();
        } else {
            logger.error("SC_004_03_EMI Text Box is not visible.");
            myAssert.fail();
        }

        // Check if EMI Text Box is enabled
        if(UI.getEMITextBox().isEnabled()) {
            logger.info("SC_004_04_EMI Text Box is enabled.");
            myAssert.pass();
        } else {
            logger.error("SC_004_04_EMI Text Box is not enabled.");
            myAssert.fail();
        }

        // Check if EMI Slider is displayed
        if(UI.getEMISlider().isDisplayed()) {
            logger.info("SC_004_05_EMI Slider is visible.");
            myAssert.pass();
        } else {
            logger.error("SC_004_05_EMI Slider is not visible.");
            myAssert.fail();
        }

        // Check if EMI Slider is enabled
        if(UI.getEMISlider().isEnabled()) {
            logger.info("SC_004_06_EMI Slider is enabled.");
            myAssert.pass();
        } else {
            logger.error("SC_004_06_EMI Slider is not enabled.");
            myAssert.fail();
        }
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/

    // Step definition for validating the interest rate textbox and slider
    @When("user validates interest rate textbox and slider of Loan Amount Calculator Page")
    public void user_validates_interest_rate_textbox_and_slider()
    {
        logger.info("SC_004_07_user_validates_interest_rate_textbox_and_slider");

        // Check if Interest Rate Text Box is displayed
        if(UI.getIntRateTextBox().isDisplayed()) {
            logger.info("SC_004_08_Interest Rate Text Box is visible.");
            myAssert.pass();
        } else {
            logger.error("SC_004_08_Interest Rate Text Box is not visible.");
            myAssert.fail();
        }

        // Check if Interest Rate Text Box is enabled
        if(UI.getIntRateTextBox().isEnabled()) {
            logger.info("SC_004_09_Interest Rate Text Box is enabled.");
            myAssert.pass();
        } else {
            logger.error("SC_004_09_Interest Rate Text Box is not enabled.");
            myAssert.fail();
        }

        // Check if Interest Rate Slider is displayed
        if(UI.getIntRateSlider().isDisplayed()) {
            logger.info("SC_004_10_Interest Rate Slider is visible.");
            myAssert.pass();
        } else {
            logger.error("SC_004_10_Interest Rate Slider is not visible.");
            myAssert.fail();
        }

        // Check if Interest Rate Slider is enabled
        if(UI.getIntRateSlider().isEnabled()) {
            logger.info("SC_004_11_Interest Rate Slider is enabled.");
            myAssert.pass();
        } else {
            logger.error("SC_004_11_Interest Rate Slider is not enabled.");
            myAssert.fail();
        }
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/

    // Step definition for validating scale change for the interest rate
    @When("user validates scale change for interest rate textbox and slider of Loan Amount Calculator Page")
    public void user_validates_scale_change_for_interest_rate_textbox_and_slider() 
    {
        logger.info("SC_004_12_Validates user_validates_scale_change_for_interest_rate_textbox_and_slider");
        
        // Move the Interest Rate Slider to the initial position
        UI.moveIntRateSlider(0);

        // Move the slider to a new position
        UI.moveIntRateSlider(112);

        // Validate the textbox value matches the slider's value
        if(UI.getIntRateTextBoxValue().equals("14.25")) {
            logger.info("SC_004_13_Scale Change for Interest Rate Text Box and Slider was successful");
            myAssert.pass();
        } else {
            logger.error("SC_004_13_Scale Change for Interest Rate Text Box and Slider was unsuccessful");
            myAssert.fail();
        }
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/

    // Step definition for validating the loan tenure textbox and slider
    @When("user validates loan tenure textbox and slider of Loan Amount Calculator Page")
    public void user_validates_loan_tenure_textbox_and_slider()
    {
        logger.info("SC_004_14_Validates user_validates_loan_tenure_textbox_and_slider");

        // Check if Loan Tenure Text Box is displayed
        if(UI.getLoanTenureTextBox().isDisplayed()) {
            logger.info("SC_004_15_Loan Tenure Text Box is visible.");
            myAssert.pass();
        } else {
            logger.error("SC_004_15_Loan Tenure Text Box is not visible.");
            myAssert.fail();
        }

        // Check if Loan Tenure Text Box is enabled
        if(UI.getLoanTenureTextBox().isEnabled()) {
            logger.info("SC_004_16_Loan Tenure Text Box is enabled.");
            myAssert.pass();
        } else {
            logger.error("SC_004_16_Loan Tenure Text Box is not enabled.");
            myAssert.fail();
        }

        // Check if Loan Tenure Slider is displayed
        if(UI.getLoanTenureSlider().isDisplayed()) {
            logger.info("SC_004_17_Loan Tenure Slider is visible.");
            myAssert.pass();
        } else {
            logger.error("SC_004_17_Loan Tenure Slider is not visible.");
            myAssert.fail();
        }

        // Check if Loan Tenure Slider is enabled
        if(UI.getLoanTenureSlider().isEnabled()) {
            logger.info("SC_004_18_Loan Tenure Slider is enabled.");
            myAssert.pass();
        } else {
            logger.error("SC_004_18_Loan Tenure Slider is not enabled.");
            myAssert.fail();
        }
    }

    /*-------------------------------------------------------------------------------------------------------------*/
    
    // Step definition for validating scale change for the loan tenure
    @When("user validates scale change for loan tenure textbox and slider of Loan Amount Calculator Page")
    public void user_validates_scale_change_for_loan_tenure_textbox_and_slider() 
    {
        logger.info("SC_004_19_Validates user validates scale change for loan tenure textbox and slider");
        
        // Move the Loan Tenure Slider to the initial position
        UI.moveLoanTenureSlider(0);

        // Move the slider to a new position
        UI.moveLoanTenureSlider(105);
        
        if(UI.getLoanTenureTextBoxValue().equals("10")) {
            logger.info("SC_004_20_Scale Change for Loan Tenure Text Box and Slider was successful");
            myAssert.pass();
        } else {
            logger.error("SC_004_20_Scale Change for Loan Tenure Text Box and Slider was unsuccessful");
            myAssert.fail();
        }
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/

    // Step definition for validating the year and month option functionality
    @When("user validates year and month option of Loan Amount Calculator Page")
    public void user_validates_year_and_month_option()
    {
        logger.info("SC_004_21_Validates user validates year and month option of Loan Amount Calculator Page");
        
        // Click on the year button to select years
        UI.clickYear();
        
        // Store the current value of the loan tenure in years
        String yearVal = UI.getLoanTenureTextBoxValue();
        int yearValInInt = Integer.parseInt(yearVal); // Convert year value to integer

        // Click on the month button to switch to months
        UI.clickMonth();
        
        // Store the current value of the loan tenure in months
        String monthVal = UI.getLoanTenureTextBoxValue();
        
        // Validate the month value corresponds to years converted to months
        if(monthVal.equals(Integer.toString(yearValInInt * 12))) {
            logger.info("SC_004_22_The data flow between the year and month is proper");
            myAssert.pass();
        } else {
            logger.error("SC_004_22_The data flow between the year and month is not proper in the Loan Amount Calculator Section.");
            myAssert.fail();
        }
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/

    // Step definition for validating fees and charges textbox and slider
    @When("user validates fees and charges textbox and slider of Loan Amount Calculator Page")
    public void user_validates_fees_and_charges_textbox_and_slider() 
    {
        logger.info("SC_004_23_Validates user_validates_fees_and_charges_textbox_and_slider");

        // Check if Fees And Charges Text Box is displayed
        if(UI.getFeesAndChargesTextBox().isDisplayed()) {
            logger.info("SC_004_24_Fees And Charges Text Box is visible.");
            myAssert.pass();
        } else {
            logger.error("SC_004_24_Fees And Charges Text Box is not visible.");
            myAssert.fail();
        }

        // Check if Fees And Charges Text Box is enabled
        if(UI.getFeesAndChargesTextBox().isEnabled()) {
            logger.info("SC_004_25_Fees And Charges Text Box is enabled.");
            myAssert.pass();
        } else {
            logger.error("SC_004_25_Fees And Charges Text Box is not enabled.");
            myAssert.fail();
        }

        // Check if Fees And Charges Slider is displayed
        if(UI.getFeesAndChargesSlider().isDisplayed()) {
            logger.info("SC_004_26_Fees And Charges Slider is visible.");
            myAssert.pass();
        } else {
            logger.error("SC_004_26_Fees And Charges Slider is not visible.");
            myAssert.fail();
        }

        // Check if Fees And Charges Slider is enabled
        if(UI.getFeesAndChargesSlider().isEnabled()) {
            logger.info("SC_004_27_Fees And Charges Slider is enabled.");
            myAssert.pass();
        } else {
            logger.error("SC_004_27_Fees And Charges Slider is not enabled.");
            myAssert.fail();
        }
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/

    // Step definition for validating scale change for fees and charges
    @When("user validates scale change for fees and charges textbox and slider of Loan Amount Calculator Page")
    public void user_validates_scale_change_for_fees_and_charges_textbox_and_slider() 
    {
        logger.info("SC_004_28_Validates user_validates_scale_change_for_fees_and_charges_textbox_and_slider");

        // Move the Fees And Charges Slider to the initial position
        UI.moveFeesAndChargesSlider(0);

        // Move the slider to a new position
        UI.moveFeesAndChargesSlider(97);
        
        // Validate the textbox value matches the slider's value
        if(UI.getFeesAndChargesTextBoxValue().equals("25,000")) {
            logger.info("SC_004_29_Scale Change for Fees And Charges Text Box and Slider was successful");
            myAssert.pass();
        } else {
            logger.error("SC_004_29_Scale Change for Fees And Charges Text Box and Slider was unsuccessful");
            myAssert.fail();
        }
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/

    // Step definition to confirm the UI validation for the loan amount calculator
    @Then("loan amount calculator ui check validation is successful")
    public void loan_amount_calculator_ui_check_validation_is_successful() 
    {
        logger.info("SC_004_30_Validates loan_amount_calculator_ui_check_validation_is_successful");
        // This step can be used for final assertions or cleanup if necessary
    }
}