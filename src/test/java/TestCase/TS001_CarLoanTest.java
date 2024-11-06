package TestCase;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import Factory.BaseClass;
import Utilities.ReadData;
import Utilities.WriteExcel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.CarLoan;
import pageObject.HomeLoan;

public class TS001_CarLoanTest extends DriverSetup {
    // Creating an object for WriteExcel utility to write data to Excel file
    WriteExcel write = new WriteExcel();
    // List of HashMaps to store data read from Excel
    List<HashMap<String, String>> datamaps;
    // Properties object to load the config properties
    public Properties p;

    @Test(priority = 1, groups = {"smoke"})
    public void validate_carLoanPage() throws IOException {
        // Load configuration file for property values
        FileReader file = new FileReader("./src//test//resources//config.properties");
        p = new Properties();
        p.load(file);

        // Create an object of the CarLoan page object
        CarLoan obj = new CarLoan(driver);

        // Logging test steps
        logger.info("Car_Loan_Test");
        logger.info("01: Navigating to the Car Loan page.");
        
        // Navigate to the Car Loan page
        obj.navigator();
        logger.info("02: Navigated to the Car Loan page.");
        logger.info("03: Clicking on Car Loan.");
        
        // Click on the Car Loan link/button
        obj.clickCarLoan();
        logger.info("04: Clicked on Car Loan.");

        // Get the title of the current page and compare it with expected title from the properties file
        String pageTitle = driver.getTitle();
        if (pageTitle.equals(p.getProperty("CarLoanPage"))) {
            logger.info("Smoke Test Successfully Verified - Car Loan Page");
        } else {
            // If title doesn't match, log an error and fail the test
            logger.error("Smoke Test Failed - Car Loan Page");
            Assert.fail();
        }
    }

    /*-------------------------------------------------------------------------------------------------------------*/

    @Test(priority = 2, groups = {"regression"})
    public void user_enteringValues_carLoan() throws IOException {
        // Create an object of the CarLoan page object
        CarLoan obj = new CarLoan(driver);

        // Logging test steps
        logger.info("05: Reading data from Excel file.");
        
        // Read data from an Excel file (CarLoanInput.xlsx)
        datamaps = ReadData.data(System.getProperty("user.dir") + "\\TestData\\CarLoanInput.xlsx", "Sheet1");

        // Assuming the first row of data is the test data we want to use
        int index = 0;
        String loanAmount = datamaps.get(index).get("loan_amount");
        String interest = datamaps.get(index).get("interest");
        String tenure = datamaps.get(index).get("tenure");

        // Log the data that is read from Excel
        logger.info("06: Data read from Excel file: Loan Amount = " + loanAmount + ", Interest = " + interest + ", Tenure = " + tenure);

        // Set loan amount on the UI (CarLoan page)
        logger.info("07: Setting Loan Amount.");
        obj.setLoanAmt(loanAmount);
        logger.info("08: Loan Amount set to " + loanAmount);

        // Set interest rate on the UI
        logger.info("09: Setting Interest Rate.");
        obj.setInterest(interest);
        logger.info("10: Interest Rate set to " + interest);

        // Move the loan tenure slider to a specific position (example value: -375)
        logger.info("11: Moving Loan Tenure Slider.");
        obj.moveLoanTenureSlider(-375);
        logger.info("12: Loan Tenure Slider moved.");

        // Click on the "Year" button to switch to yearly EMI calculation
        logger.info("13: Clicking on Year.");
        obj.clickOnYear();
        logger.info("14: Clicked on Year.");

        // Scroll to the table that contains the EMI data
        logger.info("15: Scrolling to the table.");
        obj.scrollToTable();
        logger.info("16: Scrolled to the table.");

        // Click on the "Years" option to get EMI data for years (instead of months)
        logger.info("17: Clicking on Years.");
        obj.clickOnYears();
        logger.info("18: Clicked on Years.");

        // Fetch the EMI payment table data from the UI
        logger.info("19: Fetching EMI Payment Table Data.");
        String[][] dataArray = obj.getEMIPaymentTableData();
        logger.info("20: Fetched EMI Payment Table Data.");

        // Generate a timestamp to append to the filename to make it unique
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String fileName = "TS001_YearTable_TestNG" + timeStamp + ".xlsx";
        String path = ".//TestData/" + fileName;

        // Log the file path where data will be saved
        logger.info("21: Writing data to Excel file: " + path);

        // Write the fetched EMI data into an Excel file
        write.writeExcel(dataArray, path);
        logger.info("22: Data written to Excel file successfully.");
    }
}