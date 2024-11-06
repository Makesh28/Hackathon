package TestCase;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.WriteExcel;
import pageObject.CarLoan;
import pageObject.HomeLoan;

public class TS002_HomeLoanTest extends DriverSetup {

    // Creating an object for WriteExcel utility to write data to an Excel file
    WriteExcel write = new WriteExcel();

    @Test(priority = 1, groups = {"smoke"})
    public void validate_HomeLoanPage() throws IOException {
        // Load configuration file to get expected values (e.g., page title)
        FileReader file = new FileReader("./src//test//resources//config.properties");
        p = new Properties();
        p.load(file);

        // Logging the test steps
        logger.info("Home_Loan_Test");

        // Create an object of the HomeLoan page object
        HomeLoan home = new HomeLoan(driver);

        // Log navigation to the Home Loan page
        logger.info("01. Navigating to the Home Loan page.");
        home.navigator();

        // Log successful navigation
        logger.info("02. Navigated to the Home Loan page.");

        // Get the title of the current page and compare it with expected title from properties
        String pageTitle = driver.getTitle();
        if (pageTitle.equals(p.getProperty("HomeLoanPage"))) {
            logger.info("Smoke Test Successfully Verified - Home Loan Page");
        } else {
            // If title doesn't match, log an error and fail the test
            logger.error("Smoke Test Failed - Home Loan Page");
            Assert.fail();
        }
    }

    /*-------------------------------------------------------------------------------------------------------------*/

    @Test(priority = 2, groups = {"regression"})
    public void homeloan() throws IOException {
        // Create an object of the HomeLoan page object
        HomeLoan home = new HomeLoan(driver);

        // Log the action of scrolling to the table
        logger.info("03. Scrolling to the table.");
        home.scrollToTable();
        logger.info("04. Scrolled to the table.");

        // Log fetching of the table data
        logger.info("05. Fetching table data.");
        String[][] datas = home.getTableData();  // Fetch the table data from the Home Loan page
        logger.info("06. Fetched table data.");

        // Generate a timestamp for unique Excel file name
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String fileName = "TS002_YearTable_TestNG" + timeStamp + ".xlsx";
        String path = ".//TestData/" + fileName;

        // Log the path where the data will be written
        logger.info("07. Writing data to Excel file: " + path);

        // Write the fetched data to the specified Excel file
        write.writeExcel(datas, path);
        logger.info("08. Data written to Excel file successfully.");
    }
}