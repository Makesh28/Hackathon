package StepDefenition;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.Logger;

import Factory.BaseClass;
import Utilities.WriteExcel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.HomeLoan;

public class S2_HomeLoan {
	
	WriteExcel write = new WriteExcel(); // Instance of WriteExcel for writing data to Excel
	Logger logger = BaseClass.getLogger(); // Logger instance for logging actions
	 HomeLoan home = new HomeLoan(BaseClass.getDriver());

	// Step definition for navigating to the Home Loan page
	@Given("the user navigates to HomeLoanPage")
	public void the_user_navigates_to_home_loan_page()
	{
	    logger.info("SC_002_01_Navigating to Home Loan Page");
	    home.navigator(); // Navigate to the Home Loan page
	    logger.info("SC_002_02_Navigated to Home Loan Page successfully");	
	}

	/*-------------------------------------------------------------------------------------------------------------*/
	
	// Step definition for scrolling to the table on the Home Loan page
	@When("the user scroll the table")
	public void the_user_scroll_the_table() 
	{
	    logger.info("SC_002_03_Scrolling to the table");
	   // HomeLoan home = new HomeLoan(BaseClass.getDriver()); // Create instance of HomeLoan page object
	    home.scrollToTable(); // Scroll to the table displaying loan data
	    logger.info("SC_002_04_Scrolled to the table successfully");
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/

	// Step definition for printing the table data and writing it to an Excel file
	@Then("printing the table")
	public void printing_the_table() throws IOException, InterruptedException 
	{
		logger.info("SC_002_05_Fetching data from the table");
		Thread.sleep(5000); // Optional: Pause to allow the table to fully load (commented out for production)
		String[][] datas = home.getTableData(); // Fetch data from the table
		Thread.sleep(5000); // Optional: Pause after fetching data (commented out for production)
		logger.info("SC_002_06_Fetched data from the table successfully");
		// Prepare to write data into a new Excel sheet
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Timestamp for uniqueness
		String fileName = "S2_YearTable_Cucumber" + timeStamp + ".xlsx"; // Create file name with timestamp
		String path = ".//TestData/" + fileName; // Define the path for the new Excel file
		logger.info("SC_002_07_Writing data to Excel file: {}", path);
		write.writeExcel(datas, path); // Write the fetched data to the Excel file
		logger.info("SC_002_08_Data written to Excel file successfully");
	}
}