package StepDefenition;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;

import Factory.BaseClass;
import Utilities.ReadData;
import Utilities.WriteExcel;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.CarLoan;

public class S1_CarLoan {
    // List to hold data read from Excel
    List<HashMap<String, String>> datamaps;
    WriteExcel write = new WriteExcel(); // Instance of WriteExcel for writing data to Excel
    Logger logger = BaseClass.getLogger(); // Logger instance for logging actions
     // Instance of CarLoan page object

    // Step definition for navigating to the Car Loan page
    @Given("the user navigates to CarLoanPage")
    public void the_user_navigates_to_Car_loan_page()
    {
        logger.info("SC_001_01_Navigating to Car Loan Page");
        CarLoan car = new CarLoan(BaseClass.getDriver());
        car.navigator(); // Navigate to the Car Loan page
        car.clickCarLoan(); // Click on the Car Loan option
        logger.info("SC_001_02_Navigated to Car Loan Page successfully");
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/

    // Step definition for entering values in the Car Loan form
    @When("the user enters the value of Car Loan Page")
    public void the_user_enters_the_value(DataTable dataTable)
    {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class); // Convert DataTable to Map
        CarLoan car = new CarLoan(BaseClass.getDriver());
        // Input values from feature file into the form
        car.setLoanAmt(dataMap.get("LoanAmt")); // Set loan amount
        car.setInterest(dataMap.get("LoanInt")); // Set interest rate
        car.moveLoanTenureSlider(Integer.parseInt(dataMap.get("LoanTen"))); // Set loan tenure using slider
        car.clickOnYear(); // Click on the year button
        car.scrollToTable(); // Scroll to the table displaying results
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/

    // Step definition for entering values from an Excel row
    @Then("enter the values with excel row {string}")
    public void enter_the_values_with_excel_row(String rows)
    {
        logger.info("SC_001_03_Entering values from Excel row: {}", rows);
        // Read data from the specified Excel file and sheet
        datamaps = ReadData.data("C:\\Users\\2361433\\Downloads\\hackathon 7\\hackathon\\TestData\\CarLoanInput.xlsx", "Sheet1");
        int index = Integer.parseInt(rows) - 1; // Convert row number to zero-based index
        String loanAmount = datamaps.get(index).get("loan_amount"); // Get loan amount from Excel
        String interest = datamaps.get(index).get("interest"); // Get interest from Excel
        String tenure = datamaps.get(index).get("tenure"); // Get tenure from Excel
        logger.info("SC_001_04_Loan Amount: {}, Interest: {}, Tenure: {}", loanAmount, interest, tenure);
        // System.out.println(loanAmount + " " + interest + " " + tenure); // Print values for verification
        // Set values into the form
        CarLoan car = new CarLoan(BaseClass.getDriver());
        car.setLoanAmt(loanAmount);
        car.setInterest(interest);
        car.moveLoanTenureSlider(Integer.parseInt(tenure));
        logger.info("SC_001_05_Values entered successfully");
    }

    /*-------------------------------------------------------------------------------------------------------------*/
    
    // Step definition for clicking the year button
    @Then("the user clicks on the year button")
    public void the_user_clicks_on_the_year_button() 
    {
        logger.info("SC_001_06_Clicking on the year button");
        CarLoan car = new CarLoan(BaseClass.getDriver());
        car.clickOnYear(); // Click the year button
        logger.info("SC_001_07_Year button clicked successfully");
    }

    /*-------------------------------------------------------------------------------------------------------------*/
    
    // Step definition for scrolling to the table
    @Then("the user scroll to the table")
    public void the_user_scroll_to_the_table()
    {
        logger.info("SC_001_08_Scrolling to the table");
        CarLoan car = new CarLoan(BaseClass.getDriver());
        car.scrollToTable(); // Scroll to the table
        logger.info("SC_001_09_Scrolled to the table successfully");
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/

    // Step definition for displaying EMI data and writing it to an Excel file
    @Then("display the EMI data")
    public void display_the_emi_data() throws IOException 
    {
        logger.info("SC_001_10_Fetching data from the table");
        CarLoan car = new CarLoan(BaseClass.getDriver());
        car.clickOnYears(); // Click to display the EMI table
        String[][] dataArray = car.getEMIPaymentTableData(); // Get data from the EMI payment table
        logger.info("SC_001_11_Fetched data from the table successfully");
        // Prepare to write data into a new Excel sheet
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Timestamp for uniqueness
        String fileName = "S1_YearTable_TestNG" + timeStamp + ".xlsx"; // File name with timestamp
        String path = ".//TestData/" + fileName; // Path for the new Excel file
        logger.info("SC_001_12_Writing data to Excel file: {}", path);
        write.writeExcel(dataArray, path); // Write the fetched data to the Excel file
        logger.info("SC_001_13_Data written to Excel file successfully");
    }
}