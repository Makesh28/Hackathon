package StepDefenition;

import org.apache.logging.log4j.Logger;
import Factory.BaseClass;
import Utilities.Assertions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.UIpage;

public class S5_LoanTenCalc {
    
    Assertions myAssert = new Assertions(); // Assertion utility for validating test conditions
    UIpage UI = new UIpage(BaseClass.getDriver()); // UI page object for interacting with the loan tenure calculator UI
    Logger logger = BaseClass.getLogger(); // Logger for tracking test execution

    // Step definition for navigating to the loan tenure calculator page
    @Given("user click the loan tenure calculator button of Loan Tenure Page")
    public void user_click_the_loan_tenure_calculator_button() 
    {
        logger.info("SC_005_01_user navigating to loan tenure page");
        // Navigating to the respective loan tenure calculator page
        UI.navigatorForLoanTenureCalc();
        logger.info("SC_005_02_user navigating to loan tenure page");
    }

    /*-------------------------------------------------------------------------------------------------------------*/
   
    // Step definition for validating the loan amount textbox and slider
    @When("user validates loan amount textbox and slider of Loan Tenure Page")
    public void user_validate_loan_amount_textbox_and_slider() 
    {
        logger.info("SC_005_03_Validates user_validate_loan_amount_textbox_and_slider");

        // Validating if Loan Amount Text Box is visible
        if (UI.getLoanAmtTextBox().isDisplayed()) {
            logger.info("SC_005_04_Loan Amount Text Box is visible.");
            myAssert.pass();
        } else {
            logger.error("SC_005_04_Loan Amount Text Box is not visible.");
            myAssert.fail();
        }

        // Validating if Loan Amount Text Box is enabled
        if (UI.getLoanAmtTextBox().isEnabled()) {
            logger.info("SC_005_05_Loan Amount Text Box is enabled.");
            myAssert.pass();
        } else {
            logger.error("SC_005_05_Loan Amount Text Box is not enabled.");
            myAssert.fail();
        }

        // Validating if Loan Amount Slider is visible
        if (UI.getLoanAmtSlider().isDisplayed()) {
            logger.info("SC_005_06_Loan Amount Slider is visible.");
            myAssert.pass();
        } else {
            logger.error("SC_005_06_Loan Amount Slider is not visible.");
            myAssert.fail();
        }

        // Validating if Loan Amount Slider is enabled
        if (UI.getLoanAmtSlider().isEnabled()) {
            logger.info("SC_005_07_Loan Amount Slider is enabled.");
            myAssert.pass();
        } else {
            logger.error("SC_005_07_Loan Amount Slider is not enabled.");
            myAssert.fail();
        }
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/

    // Step definition for validating the scale change of the loan amount
    @When("user validates scale change for loan amount textbox and slider of Loan Tenure Page")
    public void user_validate_scale_change_for_loan_amount_textbox_and_slider()
    {
        logger.info("SC_005_08_Validates user_validate_scale_change_for_loan_amount_textbox_and_slider");
        // Move the Loan Amount Slider to the initial position
        UI.moveLoanAmtSlider(0);
        // Move the slider to a new position
        UI.moveLoanAmtSlider(130);
        logger.info("SC_005_09_Validates moveLoanAmtSlider");

        // Validate the textbox value matches the expected value
        if (UI.getLoanAmtTextBoxValue().equals("50,00,000")) {
            logger.info("SC_005_10_Scale Change for Loan Amount Text Box and Slider was successful");
            myAssert.pass();
        } else {
            logger.error("SC_005_10_Scale Change for Loan Amount Text Box and Slider was unsuccessful");
            myAssert.fail();
        }
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/

    // Step definition for validating the EMI textbox and slider
    @When("user validates emi textbox andslider of Loan Tenure Page")
    public void user_validate_emi_textbox_and_slider()
    {
        logger.info("SC_005_11_Validates user_validate_emi_textbox_and_slider");

        // Validate if EMI Text Box is visible
        if (UI.getEMITextBox().isDisplayed()) {
            logger.info("SC_005_12_EMI Text Box is visible.");
            myAssert.pass();
        } else {
            logger.error("SC_005_12_EMI Text Box is not visible.");
            myAssert.fail();
        }

        // Validate if EMI Text Box is enabled
        if (UI.getEMITextBox().isEnabled()) {
            logger.info("SC_005_13_EMI Text Box is enabled.");
            myAssert.pass();
        } else {
            logger.error("SC_005_13_EMI Text Box is not enabled.");
            myAssert.fail();
        }

        // Validate if EMI Slider is visible
        if (UI.getEMISlider().isDisplayed()) {
            logger.info("SC_005_14_Validates getEMISlider");
            myAssert.pass();
        } else {
            logger.error("SC_005_14_EMI Slider is not visible.");
            myAssert.fail();
        }

        // Validate if EMI Slider is enabled
        if (UI.getEMISlider().isEnabled()) {
            logger.info("SC_005_15_EMI Slider is enabled.");
            myAssert.pass();
        } else {
            logger.error("SC_005_15_EMI Slider is not enabled.");
            myAssert.fail();
        }
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/

    // Step definition for validating the interest rate textbox and slider
    @When("user validates interest rate textbox and slider of Loan Tenure Page")
    public void user_validate_interest_rate_textbox_and_slider()
    {
        logger.info("SC_005_16_Validates user_validate_interest_rate_textbox_and_slider");

        // Validate if Interest Rate Text Box is visible
        if (UI.getIntRateTextBox().isDisplayed()) {
            logger.info("SC_005_17_Interest Rate Text Box is visible.");
            myAssert.pass();
        } else {
            logger.error("SC_005_17_Interest Rate Text Box is not visible.");
            myAssert.fail();
        }

        // Validate if Interest Rate Text Box is enabled
        if (UI.getIntRateTextBox().isEnabled()) {
            logger.info("SC_005_18_Interest Rate Text Box is enabled.");
            myAssert.pass();
        } else {
            logger.error("SC_005_18_Interest Rate Text Box is not enabled.");
            myAssert.fail();
        }

        // Validate if Interest Rate Slider is visible
        if (UI.getIntRateSlider().isDisplayed()) {
            logger.info("SC_005_19_Interest Rate Slider is visible.");
            myAssert.pass();
        } else {
            logger.error("SC_005_19_Interest Rate Slider is not visible.");
            myAssert.fail();
        }

        // Validate if Interest Rate Slider is enabled
        if (UI.getIntRateSlider().isEnabled()) {
            logger.info("SC_005_20_Interest Rate Slider is enabled.");
            myAssert.pass();
        } else {
            logger.error("SC_005_20_Interest Rate Slider is not enabled.");
            myAssert.fail();
        }
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/

    // Step definition for validating the scale change of the interest rate
    @When("user validates scale change for interest rate textbox and slider of Loan Tenure Page")
    public void user_validate_scale_change_for_interest_rate_textbox_and_slider() 
    {
        logger.info("SC_005_21_Validates user_validate_scale_change_for_interest_rate_textbox_and_slider");
        // Move the Interest Rate Slider to the initial position
        UI.moveIntRateSlider(0);
        // Move the slider to a new position
        UI.moveIntRateSlider(112);

        // Validate the textbox value matches the expected value
        if (UI.getIntRateTextBoxValue().equals("14.25")) {
            logger.info("SC_005_22_Scale Change for Interest Rate Text Box and Slider was successful");
            myAssert.pass();
        } else {
            logger.error("SC_005_22_Scale Change for Interest Rate Text Box and Slider was unsuccessful");
            myAssert.fail();
        }
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/

    // Step definition for validating the fees and charges textbox and slider
    @When("user validates fees and charges textbox and slider of Loan Tenure Page")
    public void user_validate_fees_and_charges_textbox_and_slider() 
    {
        logger.info("SC_005_23_Validates user_validate_fees_and_charges_textbox_and_slider");

        // Validate if Fees And Charges Text Box is visible
        if (UI.getFeesAndChargesTextBox().isDisplayed()) {
            logger.info("SC_005_24_Fees And Charges Text Box is visible.");
            myAssert.pass();
        } else {
            logger.error("SC_005_24_Fees And Charges Text Box is not visible.");
            myAssert.fail();
        }

        // Validate if Fees And Charges Text Box is enabled
        if (UI.getFeesAndChargesTextBox().isEnabled()) {
            logger.info("SC_005_25_Fees And Charges Text Box is enabled.");
            myAssert.pass();
        } else {
            logger.error("SC_005_25_Fees And Charges Text Box is not enabled.");
            myAssert.fail();
        }

        // Validate if Fees And Charges Slider is visible
        if (UI.getFeesAndChargesSlider().isDisplayed()) {
            logger.info("SC_005_26_Fees And Charges Slider is visible.");
            myAssert.pass();
        } else {
            logger.error("SC_005_26_Fees And Charges Slider is not visible.");
            myAssert.fail();
        }

        // Validate if Fees And Charges Slider is enabled
        if (UI.getFeesAndChargesSlider().isEnabled()) {
            logger.info("SC_005_27_Fees And Charges Slider is enabled.");
            myAssert.pass();
        } else {
            logger.error("SC_005_27_Fees And Charges Slider is not enabled.");
            myAssert.fail();
        }
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/

    // Step definition for validating the scale change of fees and charges
    @When("user validates scale change for fees and charges textbox and slider of Loan Tenure Page")
    public void user_validates_scale_change_for_fees_and_charges_textbox_and_slider()
    {
        logger.info("SC_005_28_Validates user_validates_scale_change_for_fees_and_charges_textbox_and_slider");

        // Move the Fees And Charges Slider to the initial position
        UI.moveFeesAndChargesSlider(0);
        // Move the slider to a new position
        UI.moveFeesAndChargesSlider(97);

        // Validate the textbox value matches the expected value
        if (UI.getFeesAndChargesTextBoxValue().equals("25,000")) {
            logger.info("SC_005_29_Scale Change for Fees And Charges Text Box and Slider was successful");
            myAssert.pass();
        } else {
            logger.error("SC_005_29_Scale Change for Fees And Charges Text Box and Slider was unsuccessful");
            myAssert.fail();
        }
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/

    // Final assertion step for successful validation of loan tenure UI
    @Then("loan tenure ui check validation is successful")
    public void loan_tenure_ui_check_validation_is_successful() 
    {
        logger.info("SC_005_30_Validates loan_tenure_ui_check_validation_is_successful");
        // This step can be used for final assertions or cleanup if necessary
    }
}